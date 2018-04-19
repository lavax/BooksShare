package com.teamtyphoon.booksshare.book;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLConnection;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.teamtyphoon.booksshare.config.PictureUploadProperties;

import net.coobird.thumbnailator.Thumbnails;

//TODO:
@Controller
// @SessionAttributes("picturePath")
public class PictureUploadController {
	private final Resource picturesDir;
	private final Resource anonymousPicture;
	private final Resource defaultBookCover;
	private final MessageSource messageSource;

	@Autowired
	public PictureUploadController(PictureUploadProperties uploadProperties, MessageSource messageSource) {
		picturesDir = uploadProperties.getUploadPath();
		anonymousPicture = uploadProperties.getAnonymousPicture();
		defaultBookCover = uploadProperties.getDefaultBookCover();
		this.messageSource = messageSource;

	}

	// @ModelAttribute("picturePath")
	// public Resource picturePath() {
	// return anonymousPicture;
	// }

	// @ModelAttribute("defaultBookCover")
	// public Resource defaultBookCoverPath() {
	// return defaultBookCover;
	// }

	// @RequestMapping("upload")
	// public String uploadPage() {
	// return "profile/uploadPage";
	// }

	@RequestMapping(value = "/profile", params = { "upload" }, method = RequestMethod.POST)
	public String onUpload(@RequestParam MultipartFile file, RedirectAttributes redirectAttrs) throws IOException {
		if (file.isEmpty() || !isImage(file)) {
			redirectAttrs.addFlashAttribute("error", "Incorrect file. Please upload a picture.");
			return "redirect:/profile";
		}

		String fileExtension = getFileExtension(file.getOriginalFilename());
		File tempFile = File.createTempFile("pic", fileExtension, picturesDir.getFile());
		try (InputStream in = file.getInputStream(); OutputStream out = new FileOutputStream(tempFile)) {
			IOUtils.copy(in, out);
		}
		Resource picturePath = copyFileToPictures(file);

		return "redirect:profile";
	}

	@RequestMapping(value = "/bookCover")
	public void getUploadedPicture(HttpServletResponse response) throws IOException {
		response.setHeader("Content-Type", URLConnection.guessContentTypeFromName(defaultBookCover.toString()));
		InputStream inputStream = defaultBookCover.getInputStream();
		// Thumbnails.of(inputStream).size(150,
		// 150).toOutputStream(response.getOutputStream());
		IOUtils.copy(inputStream, response.getOutputStream());
	}

	@ExceptionHandler(IOException.class)
	public ModelAndView handleIOException(Locale locale) {
		ModelAndView modelAndView = new ModelAndView("profile/uploadPage");
		modelAndView.addObject("error", messageSource.getMessage("upload.io.exception", null, locale));
		return modelAndView;
	}

	@RequestMapping("uploadError")
	public ModelAndView onUploadError(Locale locale) {
		ModelAndView modelAndView = new ModelAndView("profile/uploadPage");
		modelAndView.addObject("error", messageSource.getMessage("upload.file.too.big", null, locale));
		return modelAndView;
	}

	private boolean isImage(MultipartFile file) {
		return file.getContentType().startsWith("image");
	}

	private static String getFileExtension(String name) {
		return name.substring(name.lastIndexOf("."));
	}

	private Resource copyFileToPictures(MultipartFile file) throws IOException {
		String fileExtension = getFileExtension(file.getOriginalFilename());
		File tempFile = File.createTempFile("pic", fileExtension, picturesDir.getFile());
		try (InputStream in = file.getInputStream(); OutputStream out = new FileOutputStream(tempFile)) {
			IOUtils.copy(in, out);
		}
		return new FileSystemResource(tempFile);
	}
	// The rest of the code remains the same
}
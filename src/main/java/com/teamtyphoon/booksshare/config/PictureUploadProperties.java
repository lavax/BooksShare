package com.teamtyphoon.booksshare.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

@ConfigurationProperties(prefix = "upload.pictures")
public class PictureUploadProperties {
	private Resource uploadPath;
	private Resource anonymousPicture;
	private Resource defaultBookCover;

	public Resource getDefaultBookCover() {
		return defaultBookCover;
	}

	public void setDefaultBookCover(Resource defaultBookCover) {
		this.defaultBookCover = defaultBookCover;
	}

	public Resource getAnonymousPicture() {
		return anonymousPicture;
	}

	public void setAnonymousPicture(String anonymousPicture) {
		this.anonymousPicture = new DefaultResourceLoader().getResource(anonymousPicture);
	}

	public Resource getUploadPath() {
		return uploadPath;
	}

	public void setUploadPath(String uploadPath) {
		this.uploadPath = new DefaultResourceLoader().getResource(uploadPath);
	}
}
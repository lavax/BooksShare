package com.teamtyphoon.booksshare.config;

import java.time.LocalDate;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;

import com.teamtyphoon.booksshare.date.CNLocalDateFormatter;

@Configuration
public class WebConfigeration {

//	public void addFormatters(FormatterRegistry registry) {
//		registry.addFormatterForFieldType(LocalDate.class, new CNLocalDateFormatter());
////		registry.addConverter(Long.class, String.class, new Converter<Long, String>() {
////
////			@Override
////			public String convert(Long source) {
////				return source.toString();
////			}
////
////		});
////		registry.addConverter(String.class, Long.class, new Converter<String, Long>() {
////
////			@Override
////			public Long convert(String source) {
////				return Long.valueOf(source);
////			}
////		});
//	}

}

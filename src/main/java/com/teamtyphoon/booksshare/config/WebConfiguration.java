package com.teamtyphoon.booksshare.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfiguration {
//
//	@Override
//	public void addFormatters(FormatterRegistry registry) {
//		registry.addFormatterForFieldType(LocalDate.class, new CNLocalDateFormatter());
//	}
//
//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(localeChangeInterceptor());
//	}
//
//	@Override
//	@Order(1)
//	public void configurePathMatch(PathMatchConfigurer configurer) {
//		UrlPathHelper urlPathHelper = new UrlPathHelper();
//		urlPathHelper.setRemoveSemicolonContent(false);
//		configurer.setUrlPathHelper(urlPathHelper);
//		configurer.setUseRegisteredSuffixPatternMatch(true);
//	}
//
//	@Bean
//	@Primary
//	public ObjectMapper objectMapper(Jackson2ObjectMapperBuilder builder) {
//		ObjectMapper objectMapper = builder.createXmlMapper(false).build();
//		objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
//		return objectMapper;
//	}
//
//	@Bean
//	public Docket userApi() {
//		return new Docket(DocumentationType.SWAGGER_2).select().paths(path -> path.startsWith("/api/")).build();
//	}
//
//	@Bean
//	public SessionLocaleResolver localeResolver() {
//		return new SessionLocaleResolver();
//	}
//
//	@Bean
//	public LocaleChangeInterceptor localeChangeInterceptor() {
//		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
//		localeChangeInterceptor.setParamName("lang");
//		return localeChangeInterceptor;
//	}
//
//	@Bean
//	public EmbeddedServletContainerCustomizer containerCustomizer() {
//		return container -> container.addErrorPages(new ErrorPage(MultipartException.class, "/uploadError"));
//	}
//
//	@Bean
//	public Filter etagFilter() {
//		return new ShallowEtagHeaderFilter();
//	}
}
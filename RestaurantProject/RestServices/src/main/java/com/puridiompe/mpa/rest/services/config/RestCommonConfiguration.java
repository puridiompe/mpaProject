/**
 * 
 */
package com.puridiompe.mpa.rest.services.config;

import java.text.SimpleDateFormat;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.puridiompe.mpa.common.json.DatetimeDeserializer;
import com.puridiompe.mpa.common.json.DatetimeSerializer;
import com.puridiompe.mpa.common.type.Datetime;

/**
 * @author Johnny
 *
 */
@Configuration
public class RestCommonConfiguration {

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource resource = new ReloadableResourceBundleMessageSource();
		resource.setBasenames("classpath:messages/messages",
				"classpath:messages/validations", "classpath:messages/errors");
		resource.setUseCodeAsDefaultMessage(true);
		resource.setDefaultEncoding("UTF-8");
		resource.setCacheSeconds(30);

		return resource;
	}

	@Bean
	public MappingJackson2HttpMessageConverter messageConverter() {
//		ObjectMapper mapper = new ObjectMapper();
//		mapper.setSerializationInclusion(Include.NON_NULL);
//		mapper.enable(SerializationFeature.INDENT_OUTPUT);
//		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,
//				true);
//		
//		
//
//		MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
//		converter.setObjectMapper(mapper);
		
		Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
		builder.serializationInclusion(Include.NON_NULL);
		// builder.propertyNamingStrategy(PropertyNamingStrategy.LOWER_CASE);

		builder.deserializerByType(Datetime.class, new DatetimeDeserializer());
		builder.serializerByType(Datetime.class, new DatetimeSerializer());
		builder.indentOutput(true).failOnUnknownProperties(true)
				.dateFormat(new SimpleDateFormat("dd-MM-yyyy"));
		
		return new MappingJackson2HttpMessageConverter(builder.build());
	}
}

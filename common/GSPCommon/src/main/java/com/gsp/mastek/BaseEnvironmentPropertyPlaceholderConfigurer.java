package com.gsp.mastek;

import java.io.IOException;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternUtils;

import com.gsp.mastek.common.CommonUtils;

@Configuration
public class BaseEnvironmentPropertyPlaceholderConfigurer {		

	@Bean
	public static PropertyPlaceholderConfigurer properties() throws IOException {
		final PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
		
		ResourcePatternResolver resolver = ResourcePatternUtils
				.getResourcePatternResolver(new DefaultResourceLoader(Thread.currentThread().getContextClassLoader()));
		Resource[] resources = resolver.getResources("classpath*:env/" + CommonUtils.getEnvironmentName() + "/GSP_*.properties");
		ppc.setLocations(resources);

		return ppc;
	}

	@Bean(name = "messageSource")
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageBundle = new ReloadableResourceBundleMessageSource();
		messageBundle.setBasename("classpath:env/" + CommonUtils.getEnvironmentName() + "/GSP_messages");
		messageBundle.setDefaultEncoding("UTF-8");
		return messageBundle;
	}	
	
}

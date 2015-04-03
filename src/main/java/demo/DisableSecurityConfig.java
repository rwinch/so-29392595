package demo;

import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.FilterChainProxy;

@Configuration
public class DisableSecurityConfig {


	@Bean
	public FilterRegistrationBean springSecurityFilterChainRegistrationBean(@Qualifier("springSecurityFilterChain") Filter filter) {
		if(!(filter instanceof FilterChainProxy)) {
			throw new IllegalStateException("Incorrect type " + filter);
		}
		FilterRegistrationBean bean = new FilterRegistrationBean();
		bean.setFilter(filter);
		bean.setEnabled(false);
		return bean;
	}
}

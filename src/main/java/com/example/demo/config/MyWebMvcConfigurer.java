package com.example.demo.config;

import com.example.demo.controller.interceptor.OneInterceptor;
import com.example.demo.controller.interceptor.TwoInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@EnableWebMvc
public class MyWebMvcConfigurer implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		/**
		 * 拦截器按照顺序执行
		 */
		registry.addInterceptor(new OneInterceptor()).addPathPatterns("/one/**");

		registry.addInterceptor(new TwoInterceptor()).addPathPatterns("/two/**")
													 .addPathPatterns("/one/**");

		/*registry.addInterceptor(getLoginInterceptor())
				.addPathPatterns("/**")
				.excludePathPatterns("/error")
				.excludePathPatterns("/static/*");*/
		
	}

	/*@Bean
	public HandlerInterceptor getLoginInterceptor(){
		return new LoginInterceptor();
	}
*/


	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry){
		registry.addResourceHandler("/static/**")
				.addResourceLocations("classpath:/static/");

		registry.addResourceHandler("swagger-ui.html")
				.addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**")
				.addResourceLocations("classpath:/META-INF/resources/webjars/");



	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")//设置允许跨域的路径
				.allowedOrigins("*")//设置允许跨域请求的域名
				.allowCredentials(true)//是否允许证书 不再默认开启
				.allowedMethods("GET", "POST", "PUT", "DELETE")//设置允许的方法
				.maxAge(3600);//跨域允许时间
	}

}

package com.example.demo.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @PropertySource 中的属性解释
1.value：指明加载配置文件的路径。
2.ignoreResourceNotFound：指定的配置文件不存在是否报错，默认是false。当设置为 true 时，若该文件不存在，程序不会报错。实际项目开发中，最好设置 ignoreResourceNotFound 为 false。
3.encoding：指定读取属性文件所使用的编码，我们通常使用的是UTF-8。*/

@Configuration
@ConfigurationProperties(prefix="com.imooc.opensource")
@PropertySource(value="classpath:resource.properties",encoding = "UTF-8")
public class Resource {
	private String name;
	private String website;
	private String language;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
}

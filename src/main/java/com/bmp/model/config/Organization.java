package com.bmp.model.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
@Configuration
@Qualifier("organization")
public class Organization {
	
	@Value("${ORGANIZATION_KEY}")
	private String key;
	
	@Value("${ORGANIZATION_NAME}")
	private String name;
	
	@Value("${ORGANIZATION_LOGO}")
	private String logo;
	
	@Value("${ORGANIZATION_ICON}")
	private String icon;
	
	@Value("${ORGANIZATION_TITLE}")
	private String title;
	
	@Value("${ORGANIZATION_ADDRESS}")
	private String address;
	
	@Value("${ORGANIZATION_PIN_CODE}")
	private String pincode;
	
	@Value("${ORGANIZATION_FOOTER_COPYRIGHT}")
	private String footerCopyright;
	
	
	public String getKey() {
		return key;
	}
	public String getName() {
		return name;
	}
	public String getLogo() {
		return logo;
	}
	public String getAddress() {
		return address;
	}
	public String getPincode() {
		return pincode;
	}
	public String getIcon() {
		return icon;
	}
	public String getTitle() {
		return title;
	}
	public String getFooterCopyright() {
		return footerCopyright;
	}
	
	
	


}

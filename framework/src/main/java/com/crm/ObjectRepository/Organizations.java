 package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organizations {
	public Organizations(WebDriver driver) {
		PageFactory.initElements(driver,this);
		}
	
	@FindBy(linkText="Create Organization...")
	private WebElement CreateOrgImg;
	
	public WebElement getCreateOrgImg() {
		return CreateOrgImg;
		}

	

	}

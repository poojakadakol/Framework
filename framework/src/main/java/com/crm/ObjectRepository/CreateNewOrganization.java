package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrganization {
	public CreateNewOrganization(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	@FindBy(name="accountname")
	private WebElement orgNameEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public WebElement getsaveBtn()
	{
	return	saveBtn;
	}
	public void createOrg(String data1) 
	{
		orgNameEdt.sendKeys(data1);
	}
		public void saveBtn() 
		{
			saveBtn.click();
		}
		
	}



package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Deleteproduct{
	public void deleteproduct(WebDriver driver1)
	{
		PageFactory.initElements(driver1, this);
	}
     
	@FindBy(xpath=("//input[@name='Delete']"))
	private WebElement Deletproduct;
	
	 public WebElement getDeletproduct() {
		return Deletproduct;
	}
    public void Deletproduct()
    {
    	Deletproduct.click();
    }
}



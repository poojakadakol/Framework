package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
//Initilaztion
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	//Declaration
	@FindBy(name="user_name")
	private WebElement UserNameTextField;

	@FindBy(name="user_password")
	private WebElement PassWordTextField;
	
	@FindBy(id="submitButton")
	private WebElement submitButton;
	
	//getter methods

	public WebElement getUserNameTextField() {
		return UserNameTextField;
	}
    public WebElement getPassWordTextField() {
		return PassWordTextField;
	}
    public WebElement getSubmitButton() {
		return submitButton;
    }
//Business logics
    /**
    *this method is used to login the app
    *@author-pooja
    */
public void login(String UserName,String PassWord)
{
	UserNameTextField.sendKeys(UserName);
	PassWordTextField.sendKeys(PassWord);
	submitButton.click();
}
	}

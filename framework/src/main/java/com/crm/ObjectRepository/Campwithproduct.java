package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Campwithproduct {
	private static final String data = null;
	public Campwithproduct(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath=("//img[@title='Select']"))
	private WebElement PlusImage;
	
	@FindBy(id="search_txt")
	private WebElement searchtextfield;
	
	@FindBy(id="submit")
	private WebElement Submit;

	@FindBy(name="campaignname")
	private WebElement campaignName;
	
	@FindBy(name="search")
	private WebElement searchbutton;
	
	@FindBy(xpath=("//input[@class='crmButton small save']"))
	private WebElement SaveButton;
	
	 @FindBy(xpath=("//img[@src='themes/softed/images/user.PNG']"))
 	private WebElement adminLink;
     
     @FindBy(linkText="Sign Out")
 	private WebElement signOutLnk;
	
	 public WebElement getPlusImage()
	 {
		 return PlusImage;
	 }
	 
	 
	 public WebElement getCampaignName() {
		return campaignName;
	}
	 
	 
     public WebElement getSubmit() {
		return Submit;
	}
    public WebElement getsearchtextfield()
	 {
		 return searchtextfield;
	 }
	 public WebElement getsearchbutton()
	  {
		 return searchbutton;
	 }
	 public WebElement getSaveButton()
	 {
		 return  SaveButton;
	 }
	 
	 
	 
	 public WebElement getAdminLink() {
		return adminLink;
	}

     public WebElement getSignOutLnk() {
		return signOutLnk;
	}
     
     public void PlusImage()
	 
	 {
		 PlusImage.click();
	 }
	 public void campaignName(String data1)
	 {
		 campaignName.sendKeys(data1);
	 }
	 public void Submit()
	 {
		 Submit.click();
	 }
	 public void searchtextfield(String data1)
	 {
		 searchtextfield.sendKeys(data1);
	 }
	 public void searchbutton()
	 {
		 searchbutton.click();
	 }
	 public void SaveButton()
	 {
		 SaveButton.click();
	 }
	 public void adminLink() {
		 adminLink.click();
	 }
	 public void signOutLnk() {
		 signOutLnk.click();
	 }
}



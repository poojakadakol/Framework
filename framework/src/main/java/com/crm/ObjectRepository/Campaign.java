package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Campaign{
	public  Campaign(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
        @FindBy(xpath=("//img[@title='Create Campaign...']"))
        private WebElement createcampaign;
        
        @FindBy(name="campaignname")
        private WebElement campaigntextfield;
        
        @FindBy(xpath=("//input[@title='Save [Alt+S]']"))
        private WebElement savebutton;
        
        @FindBy(xpath=("//img[@src='themes/softed/images/user.PNG']"))
    	private WebElement adminLink;
        
        @FindBy(linkText="Sign Out")
    	private WebElement signOutLnk;
        
		public WebElement getCreatecampaign() {
			return createcampaign;
		}
		public WebElement getCampaigntextfield() {
			return campaigntextfield;
		}
		public WebElement getSavebutton() {
			return savebutton;
		}
		
		
        public WebElement getAdminLink() {
			return adminLink;
		}
		
		public WebElement getSignOutLnk() {
			return signOutLnk;
		}
		
		public void createcampaign()
        {
        	createcampaign.click();
        }
        public void campaigntextfield(String data1)
        {
        	campaigntextfield.sendKeys(data1);
        }
        public void savebutton()
        {
        	savebutton.click();
        }
        public void adminLink()
        {
        	adminLink.click();
        }
        public void signOutLnk()
        {
        	signOutLnk.click();
        }

}



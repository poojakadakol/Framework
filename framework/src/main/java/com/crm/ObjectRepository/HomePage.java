package com.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//Declaration
	@FindBy(linkText="Organizations")
	private WebElement OrganizationsLnk;
	
	@FindBy(linkText="Products")
	private WebElement ProductsLnk;
	
	@FindBy(xpath=("//img[@src='themes/softed/images/user.PNG']"))
	private WebElement adminLink;
	
    @FindBy(linkText="Sign Out")
	private WebElement signOutLnk;
    
    @FindBy(xpath="themes/softed/images/menuDnArrow.gif")
    private WebElement More;
    
    @FindBy(linkText="Campaigns")
	private WebElement CampaignsLnk;

	public WebElement getOrganizationsLnk() {
		return OrganizationsLnk;
	}

    public WebElement getProductsLnk() {
		return ProductsLnk;
	}
    public WebElement getAdminLink() {
		return adminLink;
	}
    
     

	public WebElement getMore() {
		return More;
	}

	

	public WebElement getCampaignsLnk() {
		return CampaignsLnk;
	}

	public WebElement getSignOutLnk() {
		return signOutLnk;
	}
	public void OrganizationsLnk()
	{
		OrganizationsLnk.click();
	}
    public void ProductsLnk()
    {
    	ProductsLnk.click();
    }
   
    public void adminLink()
    {
    	adminLink.click();
    }
    public void  More()
    {
    	 More.click();	
    }
    public void CampaignsLnk()
    {
    	CampaignsLnk.click();
    }
    public void signOutLnk()
    {
    	signOutLnk.click();
    }
	}


	
	

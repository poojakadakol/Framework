package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Products {
	
		//initialization
				public Products(WebDriver driver)
				{
					PageFactory.initElements(driver, this);
				}
		//declaration
				@FindBy(xpath=("//img[@alt='Create Product...']"))
				private WebElement creatProduct;
				
	            @FindBy(xpath=("//input[@title='Save [Alt+S]']"))
	        	private WebElement productSaveButton;
	            
	            @FindBy(name=("productname"))
	            private WebElement productName;
	            
	            @FindBy(xpath=("//img[@src='themes/softed/images/user.PNG']"))
	        	private WebElement adminLink;
	            
	            @FindBy(linkText="Sign Out")
	        	private WebElement signOutLnk;
	        	
	            
	            public WebElement getProductName() {
					return productName;
				}

			    public WebElement getcreatproduct() {
	            	return creatProduct;
	            }

             
                 public WebElement getAdminLink() {
					return adminLink;
				}
                 
                 public WebElement getSignOutLnk() {
					return signOutLnk;
				}

				public WebElement getProductSaveButton() {
					return productSaveButton;
				}


              public void  productName(String data1)
              {
            	 productName.sendKeys(data1);
              }
	            
	          public void ProductSaveButton()
	           {
	             productSaveButton.click();
	           }
	           public void creatProduct()
	           {
	        	   creatProduct.click();
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



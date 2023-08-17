package org.amazon;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class POMClass extends BaseClass {

	public POMClass() {
		
		PageFactory.initElements(driver, this);
	}
@FindBy(id="twotabsearchtextbox")
	private WebElement searchBox;
	public WebElement getSearchBox() {
		return searchBox;
	}
	@FindBy(id="nav-search-submit-button")
	private WebElement searchButton;
	public WebElement getSearchButton() {
		return searchButton;
	}
	
	@FindBy(xpath="//span[text()='Apple iPhone 14 Pro (128 GB) - Gold']")
	private WebElement iphone14ProGold;
	public WebElement getIphone14ProGold() {
		return iphone14ProGold;
	}
	@FindBy(id="add-to-cart-button")
	private WebElement addToCard;
	public WebElement getAddToCard() {
		return addToCard;
	}
	@FindBy(xpath="(//input[@type='submit'])[22]")
	private WebElement cartButton;
	public WebElement getCartButton() {
		return cartButton;

	}

	@FindBy(xpath="//input[@value='Delete']")
	private WebElement cancelOrder;
	public WebElement getCancelOrder() {
		return cancelOrder;
	}
	
	
	
}

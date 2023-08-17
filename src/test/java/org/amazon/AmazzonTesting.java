package org.amazon;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AmazzonTesting extends BaseClass {


	public static POMClass p;
	@Test(priority=1)
	public static void initializebrowser(){
		try {
			initiateBrowser("Chrome");
			getUrl("https://www.amazon.in/");
			System.out.println("Browser Launched Successfully");
		}

		catch (Exception e) {
			System.out.println("Browser Not initialized successfully");
		}
	}
	@Test(priority=2)
	public void searchProduct()  {
		try {
			p=new POMClass();
			WebElement searchBox = p.getSearchBox();
			p.enterText(searchBox," iphone");
			WebElement searchButton = p.getSearchButton();
			buttonClick(searchButton);

		} catch (Exception e) {
			System.out.println("Product not entered");
		} 
	}
	@Test(priority=3)
	public void phoneSearch() {
		try {
			Thread.sleep(3000);
			WebElement iphone14ProGold = p.getIphone14ProGold();
			buttonClick(iphone14ProGold);
		} catch (Exception e) {
			System.out.println("Phone not selected ");
		}

	}
	@Test(priority=4)
	public void switchingWindow() {
		try {
			allWindowId();
			switchtoChildWindowForMultiWindow(1);
			System.out.println("Successfully moved to add cart page");
		} catch (Exception e) {
			System.out.println("Switching window not successful");
		}
	}
	@Test(priority=5)
	public void addingToCart() {
		try {
			WebElement addToCard = p.getAddToCard();
			buttonClick(addToCard);
			System.out.println("Product Add To cart successfully");
			takesScreenshot("phones in cart");
		} catch (Exception e) {
			System.out.println("Product not added to cart");
		}
	}
	@Test(priority=6)
	
	public void cartbutton() {
		try {
			
			WebElement cartButton = p.getCartButton();
			buttonClick(cartButton);
			System.out.println("Cart Button clicked successfully");
			takesScreenshot("iphone14 pro");
		} catch (Exception e) {
			System.out.println("Cart button not clicked");
		}
		
	}

@Test(priority=7)
public void deleteOrder() {
	try {
		WebElement cancelOrder = p.getCancelOrder();
		buttonClick(cancelOrder);
		System.out.println("Order deleted successfully");
		takesScreenshot("Order delete confirmation");
	} catch (Exception e) {
		System.out.println("Order not deleted");
	}


}
}

package org.amazon;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class RunnerClass extends BaseClass {
	public static RunnerClass r;
	public static void main(String[] args) throws InterruptedException, IOException {
		r= new RunnerClass();
		initiateBrowser("Chrome");
		getUrl("https://www.amazon.in/");
		POMClass p= new POMClass();
		Thread.sleep(2000);
		WebElement searchBox = p.getSearchBox();
		Thread.sleep(3000);
		//searchBox.click();

		p.enterText(searchBox, "iphone");
		WebElement searchButton = p.getSearchButton();
		buttonClick(searchButton);
		WebElement iphone14StarLight = p.getIphone14ProGold();
		buttonClick(iphone14StarLight);
		allWindowId();
		switchtoChildWindowForMultiWindow(1);
		System.out.println("Switched to Add to cart page");
		WebElement addToCard = p.getAddToCard();
		buttonClick(addToCard);
		System.out.println("Product Add To cart successfully");

		Thread.sleep(6000);
		takesScreenshot("iphone");
		WebElement cartButton = p.getCartButton();
		cartButton.click();
		Thread.sleep(3000);
		WebElement cancelOrder = p.getCancelOrder();
		buttonClick(cancelOrder);
		Thread.sleep(2000);
		takesScreenshot("order canceled");
		System.out.println("Order cancelled Successfully");
	}


}






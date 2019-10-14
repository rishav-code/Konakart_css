package com.atmecs.validations;

import java.util.Properties;

import org.testng.Assert;

import com.atmecs.constants.FilePath;
import com.atmecs.helper.CommonUtlity;
import com.atmecs.testbase.TestBase;
import com.atmecs.util.ReadProp;

public class SearchProductValidation extends TestBase {
	Properties loc=ReadProp.loadProperty(FilePath.LOCATOR_FILE);

	public void SearchValidate(String expectedtext, String expectedprice) {
		String actualSearchText = CommonUtlity.getElement(loc.getProperty("loc.gametitle.text")).getText();
		System.out.println(actualSearchText);
		Assert.assertEquals(actualSearchText, expectedtext, "Search result avlidation failed");
		System.out.println("search result validation passed");
		String actualprice = CommonUtlity.getElement(loc.getProperty("loc.gameprice.txt")).getText();
		System.out.println(actualprice);
		Assert.assertEquals(actualprice, expectedprice, "Search result avlidation failed");
		System.out.println("search result validation passed");

	}

	public void negativesearchvalidate(String negexpectedtext) {
		String negactualSearchText = CommonUtlity.getElement(loc.getProperty("loc.error.txt")).getText();
		System.out.println(negactualSearchText);
		Assert.assertEquals(negactualSearchText, negexpectedtext, "Search result negvlidation failed");
		System.out.println("search result negvalidation passed");

	}

}

package com.atmecs.testscripts;

import org.testng.annotations.Test;

import com.atmecs.dataprovider.TestDataInputOne;
import com.atmecs.dataprovider.TestDataInputTwo;
import com.atmecs.pages.ProductSearch;
import com.atmecs.testbase.TestBase;
import com.atmecs.validations.SearchProductValidation;

public class ProductSearchTestScripts extends TestBase {
	ProductSearch search = new ProductSearch();
	SearchProductValidation Searchvalidate = new SearchProductValidation();

	@Test(priority = 1, dataProvider = "Dpdninput", dataProviderClass = TestDataInputOne.class)
	public void productSearchScript(String Data1, String text, String gametext, String price) {
		search.selectAndSearch(Data1, text);
		Searchvalidate.SearchValidate(gametext, price);

	}
	@Test(priority = 2, dataProvider = "Negatveinput", dataProviderClass = TestDataInputTwo.class)
    public void negativesearch(String negativeData1, String negativetext,String expnegativetext) {
		
		search.selectAndSearch(negativeData1, negativetext);
		Searchvalidate.negativesearchvalidate(expnegativetext);
		search.navigateback();
	}
	
	

}

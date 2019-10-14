package com.atmecs.pages;

import java.util.Properties;

import com.atmecs.constants.FilePath;
import com.atmecs.helper.CommonUtlity;
import com.atmecs.testbase.TestBase;
import com.atmecs.util.ReadProp;

public class ProductSearch extends TestBase {
	Properties loc=ReadProp.loadProperty(FilePath.LOCATOR_FILE);
	public void selectAndSearch(String Games, String text) {
		CommonUtlity.selectDropdown(loc.getProperty("loc.dpdn.click"), 30, Games);
		CommonUtlity.clickAndSendText(loc.getProperty("loc.search.txt"), 30, text);
		CommonUtlity.clickElement(loc.getProperty("loc.search.click"));

	}

	public void navigateback() {
		CommonUtlity.clickElement(loc.getProperty("loc.homepagecommon.click"));

	}

}

package com.atmecs.pages;

import java.util.Properties;

import com.atmecs.constants.FilePath;
import com.atmecs.helper.CommonUtlity;
import com.atmecs.util.ReadProp;

public class HeroImage {

	Properties loc=ReadProp.loadProperty(FilePath.LOCATOR_FILE);

	public void ProductDiscription() {
		CommonUtlity.clickElement(loc.getProperty("loc.heroimage.click"));
		CommonUtlity.clickElement(loc.getProperty("loc.productdiscription.click"));

	}

	public void ProductSpecification() {
		CommonUtlity.clickElement(loc.getProperty("loc.productspecification.click"));

	}

	public void customerReview() {

		CommonUtlity.clickElement(loc.getProperty("loc.customerreview.click"));
		CommonUtlity.scrollDownPage(300);
	}

	public void clickOncsdpdn(int dpdnindex) {

		CommonUtlity.selectDropdownByIndex(loc.getProperty("loc.customerreview.dpdn"), dpdnindex);
		CommonUtlity.scrollDownPage(300);
		

	}

}

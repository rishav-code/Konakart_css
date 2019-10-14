package com.atmecs.testscripts;

import org.testng.annotations.Test;

import com.atmecs.dataprovider.TestDataInputThree;
import com.atmecs.pages.HeroImage;
import com.atmecs.testbase.TestBase;
import com.atmecs.validations.HeroImageValidation;

public class SecondScenerio extends TestBase {
	HeroImage heroimage = new HeroImage();
	HeroImageValidation hiv = new HeroImageValidation();

	@Test(priority = 3, dataProvider = "content", dataProviderClass = TestDataInputThree.class)
	public void select(String ifexpectedkindle, String ifexpectedcoffe, String kindleproudctdesctext,
			String coffeproductdesctext, String kindledspecitext, String spectextcoffe,String hightolowdata, String lowtohighdata) throws InterruptedException {
		heroimage.ProductDiscription();
		hiv.productDescriptionValidation(ifexpectedkindle, ifexpectedcoffe, kindleproudctdesctext,coffeproductdesctext);
		heroimage.ProductSpecification();
		hiv.productSpecificationValidation(ifexpectedkindle, ifexpectedcoffe, kindledspecitext, spectextcoffe);
		heroimage.customerReview();
		heroimage.clickOncsdpdn(0);
		hiv.dateValidate(0);
		heroimage.clickOncsdpdn(1);
		hiv.dateValidate(1);
		heroimage.clickOncsdpdn(2);
		Thread.sleep(3000);
		hiv.ratingValidate(hightolowdata);
		heroimage.clickOncsdpdn(3);
		hiv.ratingValidate( lowtohighdata);

	}

	
	/*
	 * @Test(priority = 4, dataProvider = "starcontent", dataProviderClass =
	 * TestDataInputFour.class) public void date(String hightolowdata, String
	 * lowtohighdata) { System.out.println("hi");
	 * 
	 * heroimage.clickOncsdpdn(0); hiv.dateValidate(0); heroimage.clickOncsdpdn(1);
	 * hiv.dateValidate(1); heroimage.clickOncsdpdn(2);
	 * hiv.ratingValidate(hightolowdata, lowtohighdata); heroimage.clickOncsdpdn(3);
	 * hiv.ratingValidate(hightolowdata, lowtohighdata);
	 * 
	 * }
	 */
	 
}
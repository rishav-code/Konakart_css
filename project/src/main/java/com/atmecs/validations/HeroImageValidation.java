package com.atmecs.validations;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.atmecs.constants.FilePath;
import com.atmecs.helper.CommonUtlity;
import com.atmecs.util.ReadProp;

public class HeroImageValidation {
	Properties loc = ReadProp.loadProperty(FilePath.LOCATOR_FILE);
	String presenttext;

	public void productDescriptionValidation(String ifexpectedkindle, String ifexpectedcoffe,
			String kindleproudctdesctext, String coffeproductdesctext) {
		System.out.println("hi");
		presenttext = CommonUtlity.getElement(loc.getProperty("loc.kindlepagetitle.txt")).getText();
		if (presenttext.equalsIgnoreCase(ifexpectedkindle)) {
			String actualpdText = CommonUtlity.getElement(loc.getProperty("loc.gettextfor.text")).getText();

			Assert.assertTrue(actualpdText.contains(kindleproudctdesctext),
					"Search result vlidation for tab pd failed");

			System.out.println("search result validation fot tab pd passed");

		} else {
			String actualpdText2 = CommonUtlity.getElement(loc.getProperty("loc.gettextfor.text")).getText();

			Assert.assertTrue(actualpdText2.contains(coffeproductdesctext),
					"Search result vlidation for coffe pd failed");

			System.out.println("search result validation for coffe pd passed");

		}

	}

	public void productSpecificationValidation(String ifexpectedkindle, String ifexpectedcoffe, String kindledspecitext,
			String spectextcoffe) {
		if (presenttext.equalsIgnoreCase(ifexpectedkindle)) {
			String actualpsText = CommonUtlity.getElement(loc.getProperty("loc.spec.text")).getText();

			Assert.assertTrue(actualpsText.contains(kindledspecitext), "Search result vlidation for kindle ps failed");

			System.out.println("search result validation for kindle ps passed");

		} else {
			String actualpsText2 = CommonUtlity.getElement(loc.getProperty("loc.spec.text")).getText();

			Assert.assertTrue(actualpsText2.contains(spectextcoffe), "Search result vlidation failed");
			System.out.println("earch result validation for coffe ps passed");

		}

	}

	public void dateValidate(int dpdnindex) {
		System.out.println("hi");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.ENGLISH);
		System.out.println(loc.getProperty("loc.reviewall.slelct"));
		List<WebElement> allelements = CommonUtlity.getElementsList(loc.getProperty("loc.reviewall.slelct"));
		System.out.println(allelements.size());
		System.out.println("pass");
		int elementSize = allelements.size();
		for (int index = 1; index < elementSize; index++) {
			String string = CommonUtlity.getText(loc.getProperty("loc.datecommon.text").replace("index", index + ""));
			String split[] = string.split(" ", 2);
			System.out.println("split 1" + split[1].substring(1, 2));
			if (split[1].substring(1, 2).equals(" ")) {
				split[1] = "0" + split[1];
			}
			LocalDate localDate = LocalDate.parse(split[1], formatter);

			String string1 = CommonUtlity
					.getText(loc.getProperty("loc.datecommon.text").replace("index", (index + 1) + ""));
			String split1[] = string1.split(" ", 2);
			System.out.println(split1[1]);

			System.out.println("split 1" + split1[1].substring(1, 2));
			if (split1[1].substring(1, 2).equals(" ")) {
				split1[1] = "0" + split1[1];
			}
			System.out.println(split1[1]);

			LocalDate localDate1 = LocalDate.parse(split1[1], formatter);
			int difference = localDate.compareTo(localDate1);
			if (dpdnindex == 0) {
				Assert.assertTrue(difference >= 0);

			}
			if (dpdnindex == 1) {
				Assert.assertTrue(difference <= 0);

			}

		}
		System.out.println("Assertion completed for most recent and oldest first");

	}

	public void ratingValidate(String data) {
		List<WebElement> elements = CommonUtlity.getElementsList(loc.getProperty("loc.reviewall.slelct"));
		int elementSize = elements.size();
		for (int index2 = 1; index2 < elementSize; index2++) {
			int count1 = CommonUtlity
					.getElementsList(loc.getProperty("loc.starrating.sort").replace("index", index2 + "")).size();
			int count2 = CommonUtlity
					.getElementsList(loc.getProperty("loc.starrating.sort").replace("index", (index2 + 1) + "")).size();

			int difference = Integer.compare(count1, count2);
			System.out.println(difference);
			String hightolow = CommonUtlity.getElement(loc.getProperty("loc.hightolow.click")).getText();

			if (hightolow.equalsIgnoreCase(data)) {
				Assert.assertTrue(difference >= 0, "Assertion failed");
				System.out.println("Assertion passed");

			} else {
				Assert.assertTrue(difference <= 0, "Assertion failed");
				System.out.println("Assertion passed");

			}

		}
	}
}

package com.atmecs.dataprovider;

import org.testng.annotations.DataProvider;

import com.atmecs.constants.FilePath;
import com.atmecs.util.ProvideData;

public class TestDataInputTwo {
	@DataProvider(name = "Negatveinput")
	public Object[][] getData() {
		ProvideData provideData = new ProvideData(FilePath.TESTDATA_FILE, 1);
		Object[][] getData = provideData.provideData();
		return getData;
	}


}

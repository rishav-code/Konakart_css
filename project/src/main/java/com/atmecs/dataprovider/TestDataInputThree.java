package com.atmecs.dataprovider;

import org.testng.annotations.DataProvider;

import com.atmecs.constants.FilePath;
import com.atmecs.util.ProvideData;

public class TestDataInputThree {
	@DataProvider(name ="content")
	public Object[][] getData() {
		ProvideData provideData = new ProvideData(FilePath.TESTDATA_FILE, 2);
		Object[][] getData = provideData.provideData();
		return getData;
	}



}

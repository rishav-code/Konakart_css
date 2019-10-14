package it.pkg.dataprovider;

import org.testng.annotations.DataProvider;

import it.pkg.constants.FilePath;
import it.pkg.util.ProvideData;

public class TestDataInputOne {
	@DataProvider(name = "Dpdninput")
	public Object[][] getData() {
		ProvideData provideData = new ProvideData(FilePath.TESTDATA_FILE, 0);
		Object[][] getData = provideData.provideData();
		return getData;
	}


}

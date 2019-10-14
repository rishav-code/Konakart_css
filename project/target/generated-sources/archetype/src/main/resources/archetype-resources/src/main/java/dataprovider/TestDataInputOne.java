#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dataprovider;

import org.testng.annotations.DataProvider;

import ${package}.constants.FilePath;
import ${package}.util.ProvideData;

public class TestDataInputOne {
	@DataProvider(name = "Dpdninput")
	public Object[][] getData() {
		ProvideData provideData = new ProvideData(FilePath.TESTDATA_FILE, 0);
		Object[][] getData = provideData.provideData();
		return getData;
	}


}

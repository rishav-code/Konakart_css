#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.constants;

import java.io.IOException;
import java.util.Properties;

import ${package}.util.ReadProp;

public class Findloc {
	static Properties assessment;

	public Findloc() {
		try {
			assessment = ReadProp.loadProperty(FilePath.LOCATOR_FILE);
		} catch (IOException e) {
			e.getMessage();
		}
	}

	public String getlocator(String key) {
		String value = assessment.getProperty(key);
		return value;

	}

}

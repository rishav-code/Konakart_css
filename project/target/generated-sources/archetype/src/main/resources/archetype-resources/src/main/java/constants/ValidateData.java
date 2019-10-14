#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.constants;

import java.io.IOException;
import java.util.Properties;

import ${package}.util.ReadProp;

public class ValidateData {

	static Properties assessment;

	public ValidateData() {
		try {
			assessment = ReadProp.loadProperty(FilePath.VALIDATION_FILE);
		} catch (IOException e) {
			e.getMessage();
		}
	}

	public static String getData(String key) {
		String value = assessment.getProperty(key);
		return value;

	}

}

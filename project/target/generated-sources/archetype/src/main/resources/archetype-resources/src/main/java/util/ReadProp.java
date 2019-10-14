#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.util;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadProp {
	static Properties property;
	static File file;
	static FileReader reader;

	public static Properties loadProperty(String pathName) throws IOException {
		property = new Properties();
		file = new File(pathName);
		reader = new FileReader(file);
		property.load(reader);

		return property;

	}

}

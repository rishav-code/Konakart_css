package com.atmecs.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadProp {
	static Properties property;
	static File file;
	static FileReader reader;

	public static Properties loadProperty(String pathName)  {
		property = new Properties();
		file = new File(pathName);
		try {
			reader = new FileReader(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			property.load(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return property;

	}

}

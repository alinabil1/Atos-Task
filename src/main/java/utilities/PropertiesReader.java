package utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    private static FileReader reader = null;
    private static String propRoot = "src/main/Resources/";
    private static Properties p = new Properties();

    public static String getProperty(String propertyFileName, String propertyName) {
	String propPath = propRoot + propertyFileName;

	try {
	    reader = new FileReader(propPath);
	} catch (FileNotFoundException e) {
	    e.printStackTrace();
	}

	try {
	    p.load(reader);
	} catch (IOException e) {
	    e.printStackTrace();
	}

	return p.getProperty(propertyName);

    }

}

package WebAutomation.AutomationPractice.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.junit.Assert;

public class Common {

	public static Properties loadPropertiesFile(String filename) {
		Properties props = new Properties();
		InputStream input = null;
		try {
			input = new FileInputStream(filename);
			props.load(input);
		} catch (Exception ex) {
			Assert.fail(ex.getMessage());
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return props;
	}

	
	public static int getRandomNumber() {
		
		Random rand = new Random();
		int i = rand.nextInt(100000);
		return i;

	}
	
	public static String getRandomEmail() {
		
		Random rand = new Random();
		int i = rand.nextInt(100000);
		String email = "abctest" + i + "@test.com";
		return email;

	}

	public static List<String> convertStringToList(String str, String delim) {

		return Arrays.asList(str.split("\\s*" + delim + "\\s*"));

	}
	
	public static boolean isStringInt(String s)
	{
	    try
	    {
	        Integer.parseInt(s);
	        return true;
	    } catch (NumberFormatException ex)
	    {
	        return false;
	    }
	}

}
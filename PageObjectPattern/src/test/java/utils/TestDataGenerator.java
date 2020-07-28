package utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class TestDataGenerator {

	// Method to create random email address
	public String getRandomEmail() {
		String staticName = "ytestautomation@mailinator.com";
		Random rand = new Random();
		int rand_number = rand.nextInt(1000);
		String randomEmail = rand_number + staticName;
		return randomEmail;
	}
	// Method to save Email to file
		public  void saveEmail(String userEmail) throws IOException {
			String file = "src\\test\\resources\\testdata\\CreatedUserEmails";
			BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
			writer.write(userEmail);
			writer.append(",");
			writer.close();
		}
}
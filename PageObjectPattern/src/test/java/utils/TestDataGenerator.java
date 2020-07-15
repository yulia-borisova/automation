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
	public void saveEmail(String UserEmail) throws IOException {
		String file = "C:\\Users\\Yulia_Borisova\\Desktop\\Java_Study\\Projects\\Eclipse-Selenium\\PageObjectPattern\\src\\test\\resources\\testdata\\CreatedUserEmails";
		BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));

		writer.write(UserEmail);
		writer.append(",");
		writer.close();

	}

}

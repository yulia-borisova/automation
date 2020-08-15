package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class TestDataGenerator {

    // Method to create random email address
    public String getRandomEmail() throws IOException {
        String staticName = "ytestautomation@mailinator.com";
        Random rand = new Random();
        int rand_number = rand.nextInt(1000);
        String randomEmail = rand_number + staticName;
        this.saveEmail(randomEmail);
        return randomEmail;
    }

    // Method to save Email to file
    private void saveEmail(String userEmail) throws IOException {
        String file = "src\\test\\resources\\testdata\\CreatedUserEmails";
        BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
        writer.write(userEmail);
        writer.append(",");
        writer.close();
    }

    // Method to pick-up already created email from file to Login
    public String getCreatedEmail() {
        String filePath = "src\\test\\resources\\testdata\\CreatedUserEmails";
        int emailCount = 0;
        String line = "";
        String[] emails = null;
        int rand_number = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            while ((line = br.readLine()) != null) {
                emails = line.split(",");
                emailCount += emails.length; // to count total number of emails in the file
                Random rand = new Random();
                rand_number = rand.nextInt(emailCount); // getting random index
                br.close();
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return emails[rand_number];
    }
}
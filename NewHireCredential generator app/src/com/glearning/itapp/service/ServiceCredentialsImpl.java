package com.glearning.itapp.service;

import java.util.Random;

import com.glearning.itapp.model.Employee;

public class ServiceCredentialsImpl implements ServiceCredentials {

	@Override
	public String generateEmailAddress(String firstName, String lastName, String departName, String company) {
		String generatedEmail = firstName + lastName + "@" + departName +"."+ company + ".com";
		return generatedEmail;
	}

	private static final String CHAR_UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
	private static final String NUMBERS = "0123456789";
	private static final String SPECIAL_CHARS = "@!#$%^&*";
	private static final String PASSWORD_ALLOW_BASE = CHAR_UPPER + CHAR_LOWER + NUMBERS + SPECIAL_CHARS;
	private static final Random random = new Random();

	@Override
	public String generateCredentials(int maxLength) {

		StringBuilder passwordBuilder = new StringBuilder(maxLength);
		// atleast one lower case
		passwordBuilder.append(CHAR_LOWER.charAt(random.nextInt(CHAR_LOWER.length())));

		// atleast one upper case
		passwordBuilder.append(CHAR_UPPER.charAt(random.nextInt(CHAR_UPPER.length())));

		// atleast one number case
		passwordBuilder.append(NUMBERS.charAt(random.nextInt(NUMBERS.length())));

		// atleast one special character case
		passwordBuilder.append(SPECIAL_CHARS.charAt(random.nextInt(SPECIAL_CHARS.length())));

		// fill the rest of the password with random characters
		for (int i = 4; i < maxLength; i++) {
			passwordBuilder.append(PASSWORD_ALLOW_BASE.charAt(random.nextInt(PASSWORD_ALLOW_BASE.length())));
		}

		// shuffle the characters in the password
		char[] passwordChars = passwordBuilder.toString().toCharArray();
		for (int i = 0; i < passwordChars.length; i++) {
			// get a random char from the array
			int j = random.nextInt(passwordChars.length);
			// store the char in a random char variable
			char temp = passwordChars[j];
			// assign the char from the random number to the i variable of the array
			passwordChars[i] = passwordChars[j];
			// assign the temp char to the j variable
			passwordChars[j] = temp;

			return new String(passwordChars);
		}

		return null;
	}

	@Override
	public void displayCredentials(Employee employee) {
		System.out.println("Dear " + employee.getFirstName() + " your generated credentials are as follows ");
		System.out.println("Email\t\t" + employee.getEmail());
		System.out.println("Password\t" + employee.getPassword());

	}

}

package utilities;

import org.apache.commons.text.RandomStringGenerator;

public class StringCreator {

	public static void main(String[] args) {
		RandomStringGenerator generator = new RandomStringGenerator.Builder().withinRange('0','z')
				.filteredBy(Character::isLetterOrDigit).build();
		String email = generator.generate(8);
		System.out.println(email+"@gmail.com");
		

	}

}

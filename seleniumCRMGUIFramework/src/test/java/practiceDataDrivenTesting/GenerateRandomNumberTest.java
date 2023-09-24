package practiceDataDrivenTesting;

import java.util.Random;

public class GenerateRandomNumberTest {

	public static void main(String[] args) {
		Random random=new Random();
		
		//Set upper limit to 1000
		int randomInt=random.nextInt(1000);
	
		System.out.println(randomInt);
	}
}

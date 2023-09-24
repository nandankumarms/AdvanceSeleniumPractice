package practiceDataDrivenTesting;

public class GenerateAlphaNumericRandomData {
	public static void main(String[] args) {
		int n=20;
		
		
		//Choose a random character  from this String
		String alphaNumericString="ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz";
		
		//Create a StingBuilder size of alphaNumericString
		StringBuilder sb=new StringBuilder(n);
		
		for(int i=0;i<n;i++) {
			//Generate a random number between 0 to AlphaNumericString variable length
			int index=(int) (alphaNumericString.length()*Math.random());
			
			//Add character one by one in end of sb
			sb.append(alphaNumericString.charAt(index));
		}
		System.out.println(sb);
	}

}

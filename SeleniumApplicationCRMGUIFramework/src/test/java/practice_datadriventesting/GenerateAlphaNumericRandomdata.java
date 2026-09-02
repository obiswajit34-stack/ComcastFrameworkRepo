package practice_datadriventesting;

public class GenerateAlphaNumericRandomdata {

	public static void main(String[] args) {
		
		int n =20;
		
		//choose a character random from this String
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
		
		//Create StringBuffer size of AlphaNumericString
		StringBuilder sb = new StringBuilder(n);
		
		for(int i=0;i<n;i++) {
			
			//generate a random number between 0 to AlphaNumericString variable length
			int index =(int)(AlphaNumericString.length()* Math.random());
			
			
			//add Character one by one in end of sb
			sb.append(AlphaNumericString.charAt(index));
			
		}
		System.out.println(sb);
	}
}

package temp;

import java.util.Date;

public class GenerateEmail {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date date=new Date();
		String dateString=date.toString();
		String noSpaceString=dateString.replaceAll(" ","");
		String noColonString=noSpaceString.replaceAll(":", "");
		String emailWithTimeStamp=noColonString+"@gmail.com";
		System.out.println(emailWithTimeStamp);
		
		
	}

}

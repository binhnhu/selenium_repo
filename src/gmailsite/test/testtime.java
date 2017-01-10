package gmailsite.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class testtime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(Calendar.getInstance().getTime());
		String x = "Test " + timeStamp;
		System.out.println(x);
	}

}

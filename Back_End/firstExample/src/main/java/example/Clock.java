package example;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Clock {
	
	public String now() {
		Date nowDate = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy년 MM월 dd일  HH : mm : ss");
		return dateFormat.format(nowDate);
//		String formatClock = clockFormat.format(nowDate);
	}
}
package leetcode;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LeetCodeWeeklyTestWeek177Question5169 {
//	Example 1:
//
//		Input: date1 = "2019-06-29", date2 = "2019-06-30"
//		Output: 1
//	
//	Example 2:
//
//			Input: date1 = "2020-01-15", date2 = "2019-12-31"
//			Output: 15
//	
//	Constraints:
//			The given dates are valid dates between the years 1971 and 2100.

	public static void main(String[] args) {
		String date1 = "1971-06-29";
		String date2 = "2010-09-23";
		System.out.println(daysBetweenDates(date1, date2));
	}

	public static int daysBetweenDates(String date1, String date2) {
		try {
			Date data1 = new SimpleDateFormat("yyyy-MM-dd").parse(date1);
			Date data2 = new SimpleDateFormat("yyyy-MM-dd").parse(date2);
			long timeDiff = Math.abs(data1.getTime() - data2.getTime());
			System.out.println(timeDiff);
			long day = timeDiff / (24 * 1000 *3600);
			return (int)day;
		} catch (ParseException e) {
		
		}
		return 0;
	}
	
}

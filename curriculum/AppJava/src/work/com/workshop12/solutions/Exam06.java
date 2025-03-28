package work.com.workshop12.solutions;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Exam06 {

    public String convert(Date date, int type) {
        String result = "";
        SimpleDateFormat sdf;

        switch (type) {
            case 1:
                sdf = new SimpleDateFormat("yyyy-MM-dd");
                result = sdf.format(date);
                break;
            case 2:
                sdf = new SimpleDateFormat("yy년 M월 d일 E요일");
                result = sdf.format(date);
                break;
            case 3:
                sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss a", java.util.Locale.KOREA);
                result = sdf.format(date);
                break;
            default:
                result = "Invalid Type";
        }
        return result;
    }
    public static void main(String[] args) {
        // 2025년 8월 30일 토요일 21시 48분 10초 설정
        Calendar cal = Calendar.getInstance();
        cal.set(2025, Calendar.AUGUST, 30, 21, 48, 10);  // Month는 0부터 시작 (8월 → Calendar.AUGUST)
        Date date = cal.getTime();

        Exam06 converter = new Exam06();

        // Type별 출력
        System.out.println("1) " + converter.convert(date, 1));
        System.out.println("2) " + converter.convert(date, 2));
        System.out.println("3) " + converter.convert(date, 3));
    }
}

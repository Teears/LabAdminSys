package ltd.syskaoqin.springboot.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName isTimeRange
 * @Description TODO 常用的时间日期工具类
 * @createTime 2021年02月26日15:18
 */
public class TimeUtil {

    public static boolean isTimeRange(String now,String start,String end){
        String[] n = now.split(":");
        String[] s = start.split(":");
        String[] e = end.split(":");

        int nowHour = Integer.parseInt(n[0]);
        int startHour = Integer.parseInt(s[0]);
        int endHour = Integer.parseInt(e[0]);
        int nowMinute = Integer.parseInt(n[1]);
        int startMinute = Integer.parseInt(s[1]);
        int endMinute = Integer.parseInt(e[1]);
        int nowSecond = Integer.parseInt(n[2]);
        int startSecond = Integer.parseInt(s[2]);
        int endSecond = Integer.parseInt(e[2]);

        int intnow = nowSecond + 60*nowMinute + 60*60*nowHour;
        int intstart = startSecond + 60*startMinute + 60*60*startHour;
        int intend = endSecond + 60*endMinute + 60*60*endHour;
        if(intnow>=intstart && intnow<=intend){
            return true;
        }else {
            return false;
        }
    }

    public static String getNowDate(){
        Date day=new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.format(day);
    }

    public static String getNowTime(){
        Date day=new Date();
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
        return df.format(day);
    }

    public static int subNowDate(String str) throws ParseException {
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
        Date date1=sdf.parse(str);
        Calendar c1= Calendar.getInstance();
        c1.setTime(date1);


        Date date2=new Date();
        Calendar c2 = Calendar.getInstance();
        c2.setTime(date2);

        return c2.get(Calendar.DAY_OF_YEAR) - c1.get(Calendar.DAY_OF_YEAR);
    }

    public static String add0(String str){
        if(str.length()==1){
            return "0"+str;
        }else if(str.length() == 0){
            return "00";
        }else {
            return str;
        }
    }
}

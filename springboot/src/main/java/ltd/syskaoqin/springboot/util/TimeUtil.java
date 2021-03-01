package ltd.syskaoqin.springboot.util;

/**
 * @author Teears
 * @version 1.0.0
 * @ClassName isTimeRange
 * @Description TODO
 * @createTime 2021年02月26日15:18
 */
public class TimeUtil {

    public static boolean isTimeRange(String now,String start,String end){
        String[] n = now.split(":");
        String[] s = now.split(":");
        String[] e = now.split(":");

        int nowHour = Integer.parseInt(n[0]);
        int startHour = Integer.parseInt(s[0]);
        int endHour = Integer.parseInt(e[0]);
        if(nowHour<startHour || nowHour>endHour){
            return false;
        }
        int nowMinute = Integer.parseInt(n[1]);
        int startMinute = Integer.parseInt(s[1]);
        int endMinute = Integer.parseInt(e[1]);
        if(nowMinute<startMinute || nowMinute>endMinute){
            return false;
        }
        int nowSecond = Integer.parseInt(n[2]);
        int startSecond = Integer.parseInt(s[2]);
        int endSecond = Integer.parseInt(e[2]);
        return nowSecond >= startSecond && nowSecond <= endSecond;
    }
}

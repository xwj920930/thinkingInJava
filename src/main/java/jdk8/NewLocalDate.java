package jdk8;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * @Description 时间日期API，用于替代date和calendar，并且线程安全，
 *
 * @Author yuki
 * @Date 2019/3/22 16:44
 * @Version 1.0
 **/
public class NewLocalDate {
    public static void main(String[] args) {
//        Now的表示
        LocalDateTime t1=LocalDateTime.now();

//        自定义时间
        LocalDateTime t2=LocalDateTime.of(2000,1,1,19,0,0);
        LocalDateTime t3=LocalDateTime.parse("2007-12-03T10:15:30");
        LocalDateTime t4=LocalDateTime.parse("2001-04-23 12:30",DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        LocalDateTime t5=LocalDateTime.parse("2017-01-08 00:00:00",DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

//        时间的加减
        LocalDateTime t6=t2.plusDays(5).plusHours(3);
        LocalDateTime t7=t2.plusDays(-5).plusHours(-3);

//        算时间差
        Duration  d1= Duration.between(t6, t7);
        Duration  d2= Duration.between(t7, t6);

//        时间判等，千万不要用==
                LocalDateTime t8=LocalDateTime.of(2000,1,1,19,0,0);
        System.out.println(t2.isEqual(t8));

//        时间判大小
        System.out.println(t1.isAfter(t2));

//        转换成字符串
        System.out.println(t1);
//        用datetimeformatter代替simpledatetimeformatter
        System.out.println(t1.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }
}

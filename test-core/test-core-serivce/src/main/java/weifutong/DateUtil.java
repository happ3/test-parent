package weifutong;

import org.joda.time.DateTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 时间工具类
 * Created by csf on 2015/5/16.
 *
 * @author csf
 */
@SuppressWarnings(value = "unused")
public class DateUtil {
    private DateUtil() {

    }

    private final static String DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";

    /**
     * 格式化日期对象
     *
     * @param date   日期对象
     * @param format 日期格式
     * @return 当前日期字符串
     */
    public static String format(Date date, String format) {
        return new DateTime(date).toString(format);
    }

    /**
     * 格式化日期对象，格式为yyyy-MM-dd HH:mm:ss
     *
     * @param date 日期对象
     * @return 日期字符串
     */
    public static String format(Date date) {
        return new DateTime(date).toString(DEFAULT_FORMAT);
    }

    /**
     * 格式化日期对象，格式为yyyy-MM-dd HH:mm:ss
     *
     * @param mills 毫秒
     * @return 日期字符串
     */
    public static String format(Long mills) {
        return new DateTime(mills).toString(DEFAULT_FORMAT);
    }

    /**
     * 格式化日期对象
     *
     * @param mills   毫秒
     * @param pattern 格式
     * @return 日期字符串
     */
    public static String format(Long mills, String pattern) {
        return new DateTime(mills).toString(pattern);
    }
}

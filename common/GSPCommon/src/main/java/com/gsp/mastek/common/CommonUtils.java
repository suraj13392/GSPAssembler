package com.gsp.mastek.common;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

/**
 * @author shivkumarg
 *
 */

@Component
public class CommonUtils {

	private static final String ENVIRONMENT_NAME = "spring.profiles.active";

	

	public static String getEnvironmentName() {
		String env = System.getProperty(ENVIRONMENT_NAME);
		if (env == null || env.trim().length() == 0) {
			env = "local";
		}
		return env;
	}

	/**
	 * @param messageSource
	 * @param key
	 * @param args
	 * @return
	 */
	public static String getValueFromProperty(MessageSource messageSource, String key, Object... args) {

		Object[] arrayArguments = args;
		Locale currentLocale = LocaleContextHolder.getLocale();
		String value = messageSource.getMessage(key, arrayArguments, currentLocale);
		return value;
	}

	/**
	 * @param messageSource
	 * @param key
	 * @return
	 */
	public static String getValueFromProperty(MessageSource messageSource, String key) {

		Locale currentLocale = LocaleContextHolder.getLocale();
		String value = messageSource.getMessage(key, null, currentLocale);
		return value;
	}

	

	public static Date getLastDateOfMonth(Date input) {
		Calendar c = Calendar.getInstance();
		c.setTime(input);
		c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
		return c.getTime();
	}

	public static Date getFirstDateOfNextMonth(Date input) {
		Calendar c = Calendar.getInstance();
		c.setTime(input);
		c.add(Calendar.MONTH, 1);
		return c.getTime();
	}

	public static Date getFirstDayOfMonth(Date input) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(input);
		cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
		return cal.getTime();

	}

	public static String getMonthName(Date input) {
		Calendar c = Calendar.getInstance();
		c.setTime(input);
		return c.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
	}

	public static boolean isDateWithinRange(Date testDate, Date fromDate, Date toDate) {
		return !((fromDate != null && testDate.before(fromDate)) || (toDate != null && testDate.after(toDate)));
	}

	/**
	 * Add One Month and number of days to the currentDate
	 * 
	 * @param date
	 * @param days
	 * @return
	 */
	public static Date addMonthAndDays(Date date, int days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, 1);
		cal.add(Calendar.DATE, days);
		return cal.getTime();
	}

	public static Date addWeekAndDays(Date date, int days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.WEEK_OF_MONTH, 1);
		cal.add(Calendar.DATE, days);
		return cal.getTime();
	}

	public static Date addFornightAndDays(Date date, int days) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.WEEK_OF_MONTH, 2);
		cal.add(Calendar.DATE, days);
		return cal.getTime();
	}

	public static Date getStartOnDate(String stratOnDay) throws Exception {
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, 1);
		int month = cal.get(Calendar.MONTH);
		int year = cal.get(Calendar.YEAR);
		String stratOn = stratOnDay + "/" + month + "/" + year;
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date completeDateOfStartOn = formatter.parse(stratOn);
		return completeDateOfStartOn;
	}

	
	
	 public static Date zeroTime(Date date) {
		    if(date == null) {
		    	return null;
		    }
	        Calendar calendar = Calendar.getInstance();
	        calendar.setTime(date);
	        calendar.set(Calendar.MILLISECOND, 0);
	        calendar.set(Calendar.SECOND, 0);
	        calendar.set(Calendar.MINUTE, 0);
	        calendar.set(Calendar.HOUR_OF_DAY, 0);
	        return calendar.getTime();
	 }
}

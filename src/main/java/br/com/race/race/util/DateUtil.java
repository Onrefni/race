package br.com.race.race.util;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

public class DateUtil {

	/**
	 * Converte Datas do tipo {@link Date} para {@link LocalTime}
	 * @param dateToConvert
	 * @return Data convertida em {@link LocalTime}
	 */
	public static LocalTime converterDateParaLocalTime(Date dateToConvert) {
		return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
	}

}

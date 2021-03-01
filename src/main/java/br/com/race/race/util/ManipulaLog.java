package br.com.race.race.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.race.race.vo.v1.HeroVO;
import br.com.rbdf.race.vo.builder.HeroVOBuilder;

public class ManipulaLog {

	public static List<HeroVO> manipularRetornoArquivoLog(List<HeroVO> heroList, BufferedReader reader) throws ParseException, IOException {
		String line;
		List<String> lines = new ArrayList<>();
		while ((line = reader.readLine()) != null) {
			lines.add(line);
		}

		lines.remove(0);
		String[] splitted = lines.stream().map(String::trim).toArray(String[]::new);

		DateFormat dateFormat = new SimpleDateFormat("mm:ss.SSS");
		Calendar cal = Calendar.getInstance();

		for (String her : splitted) {
			String[] splitHero = her.split(";");

			cal.setTime(dateFormat.parse(splitHero[3]));
			String[] codeNmaeHero = splitHero[1].split("–");

			heroList.add(new HeroVOBuilder().setCodigoSuperHero(Integer.valueOf(codeNmaeHero[0]))
					.setNomeSuperHero(codeNmaeHero[1])

					.setPosicaoChegadaHero(Integer.valueOf(splitHero[2]))
					.setMelhorVoltaHero(DateUtil.converterDateParaLocalTime(cal.getTime()))
					.setQuantidadeVoltasCompletadasHero(Integer.valueOf(splitHero[2]))
					.setVelocidadeMediaHero(Double.valueOf(splitHero[4].replace(",", "."))).createHeroVO());
		}

		return heroList;
	}

}

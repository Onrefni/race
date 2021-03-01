package br.com.rbdf.race.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.race.race.util.ManipulaLog;
import br.com.race.race.util.RecursoUtil;
import br.com.race.race.vo.v1.HeroVO;
import br.com.rbdf.race.exception.AplicacaoException;
import br.com.rbdf.race.vo.builder.HeroVOBuilder;

/**
 * 
 * @author Rommel
 *
 */
@Service
public class RaceService extends StatusRace {

	protected List<HeroVO> recuperaDados() throws AplicacaoException {
		String fileName = "heros.log";
		InputStream is;
		List<HeroVO> heroList = Collections.emptyList();
		try {
			is = RecursoUtil.recuperarArquivoDoRecursoComoStream(getClass().getName(), fileName);

			heroList = new ArrayList<>();

			try (InputStreamReader streamReader = new InputStreamReader(is, StandardCharsets.UTF_8);

					BufferedReader reader = new BufferedReader(streamReader)) {

				ManipulaLog.manipularRetornoArquivoLog(heroList, reader);

			} catch (IOException | ParseException e) {
				throw new AplicacaoException("Problema em abrir e manipular o arquivo com os dados da corrida.");
			}
		} catch (ClassNotFoundException e1) {
			throw new AplicacaoException("Problema Interno.");
		}
		return heroList;
	}

	protected Set<HeroVO> melhorVoltaPorHeroi(List<HeroVO> heroList) {

		Comparator<HeroVO> salaryComparator = Comparator.comparing(HeroVO::getQuantidadeVoltasCompletadasHero);
		heroList.sort(salaryComparator.reversed());

		Map<Integer, List<HeroVO>> collect = heroList.stream()
				.collect(Collectors.groupingBy(HeroVO::getCodigoSuperHero, Collectors.toList()));

		Set<HeroVO> set = new HashSet<>();
		HeroVOBuilder builder;
		for (Entry<Integer, List<HeroVO>> entry : collect.entrySet()) {

			List<HeroVO> listaHerois = entry.getValue();
			builder = new HeroVOBuilder();

			builder.setCodigoSuperHero(entry.getKey())
					.setNomeSuperHero(listaHerois.stream().findFirst().get().getNomeSuperHero())
					.setMelhorVoltaHero(listaHerois.stream().map(m -> m.getMelhorVoltaHero())
							.max(Comparator.comparing(LocalTime::toNanoOfDay).reversed()).get())
					.setQuantidadeVoltasCompletadasHero(listaHerois.stream()
							.map(m -> m.getQuantidadeVoltasCompletadasHero()).max(Comparator.comparing(i -> i)).get())
					.setVelocidadeMediaHero(listaHerois.stream().map(m -> m.getVelocidadeMediaHero())
							.collect(Collectors.averagingDouble(d -> d)));

			set.add(builder.createHeroVO());

		}

		return set;
	}

	protected LocalTime melhorVoltaCorrida(List<HeroVO> heroList) {

		Comparator<HeroVO> salaryComparator = Comparator.comparing(HeroVO::getMelhorVoltaHero)
				.thenComparing(HeroVO::getQuantidadeVoltasCompletadasHero);
		heroList.sort(salaryComparator);

		return heroList.stream().findFirst().get().getMelhorVoltaHero();
	}

	/**
	 * Método para Calcular o tempo total da corrida. A corrida termina quando o
	 * primeiro colocado completa 4 voltas.
	 * 
	 * @param heroList - Lista contendo os tempos que será calculado
	 * @return A melhor volta da corrida.
	 */
	protected LocalTime tempoTotalCorrida(List<HeroVO> heroList) {
		Comparator<HeroVO> salaryComparator = Comparator.comparing(HeroVO::getMelhorVoltaHero)
				.thenComparing(HeroVO::getQuantidadeVoltasCompletadasHero);
		heroList.sort(salaryComparator);

		return heroList.stream().filter(f -> f.getQuantidadeVoltasCompletadasHero() > 3).findFirst().get()
				.getMelhorVoltaHero();
	}

}

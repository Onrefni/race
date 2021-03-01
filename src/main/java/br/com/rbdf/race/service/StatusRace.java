package br.com.rbdf.race.service;

import java.time.LocalTime;
import java.util.List;
import java.util.Set;

import br.com.race.race.vo.v1.HeroVO;
import br.com.race.race.vo.v1.RaceVO;
import br.com.rbdf.race.exception.AplicacaoException;
import br.com.rbdf.race.vo.builder.RaceVOBuilder;

/**
 * Classe Abstrata que define um o comportamento em comum para o retorno do
 * Status da corrida. Delegando a forma que como trata e recupera os dados.
 * 
 * @author Rommel
 *
 */
public abstract class StatusRace {

	/**
	 * Retorna o Status da Corrida, como o melhor tempo e o tempo total. Como os
	 * dados do Heroi;
	 * 
	 * @return Status da corrida.
	 * @throws AplicacaoException Problema na recuperação dos da corrida.
	 */
	public RaceVO retornaStatus() throws AplicacaoException {

		List<HeroVO> heroList = recuperaDados();

		LocalTime melhorTempoCorrida = melhorVoltaCorrida(heroList);
		LocalTime tempoTotalCorrida = tempoTotalCorrida(heroList);
		return new RaceVOBuilder().setHero(melhorVoltaPorHeroi(heroList)).setMelhorVoltaRace(melhorTempoCorrida)
				.setTempoTotalRace(tempoTotalCorrida).createRaceVO();

	}

	/**
	 * @return Lista com todas os dados do heroi na corrida.
	 * @throws AplicacaoException Excessão quando tenta recuperar os dados.
	 */
	protected abstract List<HeroVO> recuperaDados() throws AplicacaoException;

	/**
	 * Calcula a melhor volta de cada heroi.
	 * 
	 * @param heroList - Lista com os tempos dos Herois.
	 * @return Lista com o melhor tempo de cada herois.
	 */
	protected abstract Set<HeroVO> melhorVoltaPorHeroi(List<HeroVO> heroList);

	/**
	 * Calcula a melhor volta da corrida.
	 * 
	 * @param heroList - Lista com os tempos dos Herois.
	 * @return Melhor tempo da coirrida.
	 */
	protected abstract LocalTime melhorVoltaCorrida(List<HeroVO> heroList);

	/**
	 * Calcula o tempo total da corrida.
	 * 
	 * @param heroList - Lista contendo os tempos que será calculado
	 * @return A melhor volta da corrida.
	 */
	protected abstract LocalTime tempoTotalCorrida(List<HeroVO> heroList);

}

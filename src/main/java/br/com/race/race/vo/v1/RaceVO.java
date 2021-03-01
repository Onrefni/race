package br.com.race.race.vo.v1;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Set;

public class RaceVO implements Serializable {

	private static final long serialVersionUID = 4453279633422506071L;

	private LocalTime melhorVoltaRace;
	private LocalTime tempoTotalRace;

	private Set<HeroVO> hero;

	public RaceVO(LocalTime melhorVoltaRace, LocalTime tempoTotalRace, Set<HeroVO> hero2) {
		this.melhorVoltaRace = melhorVoltaRace;
		this.tempoTotalRace = tempoTotalRace;
		this.hero = hero2;
	}

	public LocalTime getMelhorVoltaRace() {
		return melhorVoltaRace;
	}

	public void setMelhorVoltaRace(LocalTime melhorVoltaRace) {
		this.melhorVoltaRace = melhorVoltaRace;
	}

	public LocalTime getTempoTotalRace() {
		return tempoTotalRace;
	}

	public void setTempoTotalRace(LocalTime tempoTotalRace) {
		this.tempoTotalRace = tempoTotalRace;
	}

	public Set<HeroVO> getHero() {
		return hero;
	}

	public void setHero(Set<HeroVO> hero) {
		this.hero = hero;
	}
}

package br.com.rbdf.race.vo.builder;

import java.time.LocalTime;
import java.util.Set;

import br.com.race.race.vo.v1.HeroVO;
import br.com.race.race.vo.v1.RaceVO;

public class RaceVOBuilder {
    private LocalTime melhorVoltaRace;
    private LocalTime tempoTotalRace;
    private Set<HeroVO> hero;

    public RaceVOBuilder setMelhorVoltaRace(LocalTime melhorTempoCorrida) {
        this.melhorVoltaRace = melhorTempoCorrida;
        return this;
    }

    public RaceVOBuilder setTempoTotalRace(LocalTime tempoTotalRace) {
        this.tempoTotalRace = tempoTotalRace;
        return this;
    }

	public RaceVOBuilder setHero(Set<HeroVO> heroList) {
        this.hero = heroList;
        return this;
    }

    public RaceVO createRaceVO() {
        return new RaceVO(melhorVoltaRace, tempoTotalRace, hero);
    }
}
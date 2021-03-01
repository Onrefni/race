package br.com.rbdf.race.vo.builder;

import java.time.LocalTime;

import br.com.race.race.vo.v1.HeroVO;

public class HeroVOBuilder {
	
    private Integer codigoSuperHero;
    private String nomeSuperHero;
    private Integer quantidadeVoltasCompletadasHero;
    private Integer posicaoChegadaHero;
    private Double velocidadeMediaHero;
    private LocalTime melhorVoltaHero;

    public HeroVOBuilder setCodigoSuperHero(Integer codigoSuperHero) {
        this.codigoSuperHero = codigoSuperHero;
        return this;
    }

    public HeroVOBuilder setNomeSuperHero(String nomeSuperHero) {
        this.nomeSuperHero = nomeSuperHero;
        return this;
    }

    public HeroVOBuilder setQuantidadeVoltasCompletadasHero(Integer quantidadeVoltasCompletadasHero) {
        this.quantidadeVoltasCompletadasHero = quantidadeVoltasCompletadasHero;
        return this;
    }

    public HeroVOBuilder setPosicaoChegadaHero(Integer posicaoChegadaHero) {
        this.posicaoChegadaHero = posicaoChegadaHero;
        return this;
    }

    public HeroVOBuilder setVelocidadeMediaHero(Double velocidadeMediaHero) {
        this.velocidadeMediaHero = velocidadeMediaHero;
        return this;
    }

    public HeroVOBuilder setMelhorVoltaHero(LocalTime melhorVoltaHero) {
        this.melhorVoltaHero = melhorVoltaHero;
        return this;
    }

    public HeroVO createHeroVO() {
        return new HeroVO(codigoSuperHero, nomeSuperHero, quantidadeVoltasCompletadasHero, posicaoChegadaHero, velocidadeMediaHero, melhorVoltaHero);
    }
}
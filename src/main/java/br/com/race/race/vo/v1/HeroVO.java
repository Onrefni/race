package br.com.race.race.vo.v1;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Objects;

public class HeroVO implements Serializable {

	private static final long serialVersionUID = 138127088323311509L;

	private Integer codigoSuperHero;
	private String nomeSuperHero;
	private Integer quantidadeVoltasCompletadasHero;
	private Integer posicaoChegadaHero;
	private Double velocidadeMediaHero;
	private LocalTime melhorVoltaHero;

	public HeroVO(Integer codigoSuperHero, String nomeSuperHero, Integer quantidadeVoltasCompletadasHero,
			Integer posicaoChegadaHero, Double velocidadeMediaHero, LocalTime melhorVoltaHero) {
		super();
		this.codigoSuperHero = codigoSuperHero;
		this.nomeSuperHero = nomeSuperHero;
		this.quantidadeVoltasCompletadasHero = quantidadeVoltasCompletadasHero;
		this.posicaoChegadaHero = posicaoChegadaHero;
		this.velocidadeMediaHero = velocidadeMediaHero;
		this.melhorVoltaHero = melhorVoltaHero;
	}

	public Integer getCodigoSuperHero() {
		return codigoSuperHero;
	}

	public void setCodigoSuperHero(Integer codigoSuperHero) {
		this.codigoSuperHero = codigoSuperHero;
	}

	public String getNomeSuperHero() {
		return nomeSuperHero;
	}

	public void setNomeSuperHero(String nomeSuperHero) {
		this.nomeSuperHero = nomeSuperHero;
	}

	public Integer getQuantidadeVoltasCompletadasHero() {
		return quantidadeVoltasCompletadasHero;
	}

	public void setQuantidadeVoltasCompletadasHero(Integer quantidadeVoltasCompletadasHero) {
		this.quantidadeVoltasCompletadasHero = quantidadeVoltasCompletadasHero;
	}

	public Integer getPosicaoChegadaHero() {
		return posicaoChegadaHero;
	}

	public void setPosicaoChegadaHero(Integer posicaoChegadaHero) {
		this.posicaoChegadaHero = posicaoChegadaHero;
	}

	public Double getVelocidadeMediaHero() {
		return velocidadeMediaHero;
	}

	public void setVelocidadeMediaHero(Double velocidadeMediaHero) {
		this.velocidadeMediaHero = velocidadeMediaHero;
	}

	public LocalTime getMelhorVoltaHero() {
		return melhorVoltaHero;
	}

	public void setMelhorVoltaHero(LocalTime melhorVoltaHero) {
		this.melhorVoltaHero = melhorVoltaHero;
	}

	@Override
	public String toString() {
		return "HeroVO{" + "codigoSuperHero=" + codigoSuperHero + ", nomeSuperHero='" + nomeSuperHero + '\''
				+ ", quantidadeVoltasCompletadasHero=" + quantidadeVoltasCompletadasHero + ", posicaoChegadaHero="
				+ posicaoChegadaHero + ", velocidadeMediaHero=" + velocidadeMediaHero + ", melhorVoltaHero="
				+ melhorVoltaHero + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		HeroVO heroVO = (HeroVO) o;
		return getCodigoSuperHero().equals(heroVO.getCodigoSuperHero());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getCodigoSuperHero());
	}

}

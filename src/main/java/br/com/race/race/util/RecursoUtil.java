package br.com.race.race.util;

import java.io.InputStream;

public class RecursoUtil {

	/**
	 * Retorna o arquivo que se encontra no Resource.
	 * 
	 * @param nameClass Nome da classe
	 * @param fileName Nome do arquivo
	 * @return Stream do arquivo recuperado.
	 * @throws ClassNotFoundException quano não encontra a classe fornecida.
	 */
	public static InputStream recuperarArquivoDoRecursoComoStream(String nameClass, String fileName)
			throws ClassNotFoundException {

		ClassLoader classLoader = Class.forName(nameClass).getClassLoader();
		InputStream inputStream = classLoader.getResourceAsStream(fileName);

		if (inputStream == null) {
			throw new IllegalArgumentException("Arquivo não encontrado! " + fileName);
		} else {
			return inputStream;
		}

	}
}

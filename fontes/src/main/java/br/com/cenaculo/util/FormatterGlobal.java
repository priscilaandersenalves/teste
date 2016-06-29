/**
 * 
 */
package br.com.cenaculo.util;

import java.text.DateFormat;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Priscila.Andersen
 *
 */
public class FormatterGlobal {

	@Autowired
	private static Locale brasil = new Locale("pt", "BR");

	/**
	 * formata o valor apresentado
	 * 
	 * @param valor
	 * @return
	 */
	public static String convertValor(Double valor) {
		if (valor != null) {
			return String.format(brasil, "%,.2f", valor);
		} else {
			return String.format(brasil, "%,.2f", 0d);
		}

	}
	/**
	 * Converte uma String para um objeto Date. Caso a String seja vazia ou
	 * nula, retorna null - para facilitar em casos onde formulários podem ter
	 * campos de datas vazios.
	 * 
	 * @param data
	 *            String no formato dd/MM/yyyy a ser formatada
	 * @return Date Objeto Date ou null caso receba uma String vazia ou nula
	 * @throws Exception
	 *             Caso a String esteja no formato errado
	 */
	public static Date formataDataView(String data) throws Exception {
		if (data == null || data.equals(""))
			return null;
		Date date = null;
		try {
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			date = formatter.parse(data);
		} catch (ParseException e) {
			throw e;
		}
		return date;
	}

	/**
	 * Primeiro converte de String para Date
	 * 
	 * @param dataString
	 * @return
	 */
	public static Date converterUS(String dataString) {
		DateFormat formatUS = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = formatUS.parse(dataString);
		} catch (ParseException e) {
			System.out.println(e);
		}
		return date;
	}

	public static String converterBR(Date data) {
		// Depois formata data
		DateFormat formatBR = new SimpleDateFormat("dd/MM/yyyy");
		String dateFormated = formatBR.format(data);
		return dateFormated;
	}

	public static String removerAcentos(String str) {
		return Normalizer.normalize(str, Normalizer.Form.NFD)
				.replaceAll("[^\\p{ASCII}]", "");
	}

}

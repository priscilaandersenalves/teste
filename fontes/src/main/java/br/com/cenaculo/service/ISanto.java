/**
 * 
 */
package br.com.cenaculo.service;

import java.util.List;

import br.com.cenaculo.model.Santo;

/**
 * @author prisc
 *
 */
public interface ISanto {
	
	String addSanto(String santo);
	Santo searchSantobyDay(String dia);
	
	List<Santo> searchSantoAll();
	
	String updateSanto(Santo santo);

	void deleteSanto(Santo santo);
}

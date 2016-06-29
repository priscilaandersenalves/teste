/**
 * 
 */
package br.com.cenaculo.service;

import java.util.List;

import br.com.cenaculo.model.Aparicao;

/**
 * @author prisc
 *
 */
public interface IAparicao {
	
	String addAparicao(String santo);
	Aparicao searchAparicaobyDay(String dia);
	
	List<Aparicao> searchAparicaoAll();
	
	String updateAparicao(Aparicao aparicao);

	void deleteAparicao(Aparicao aparicao);
}

package br.com.cenaculo.dao;

import java.util.List;

import br.com.cenaculo.model.Aparicao;

public interface IAparicao {
	
	 void addAparicao(Aparicao aparicao);

	 Aparicao searchAparicaobyDay(String dia);
	 
	 List<Aparicao> searchAparicaoAll() ;
	 
	 void updateAparicao(Aparicao aparicao) ;

	 void deleteAparicao(Aparicao aparicao) ;
}

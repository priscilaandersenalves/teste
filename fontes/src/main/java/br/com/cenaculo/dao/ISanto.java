package br.com.cenaculo.dao;

import java.util.List;

import br.com.cenaculo.model.Santo;

public interface ISanto {
	public void addSanto(Santo santo);
	
	Santo searchSantobyDay(String dia);
	
	List<Santo> searchSantoAll();
	
	void updateSanto(Santo santo);

	void deleteSanto(Santo santo);
}

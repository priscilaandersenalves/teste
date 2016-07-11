/**
 * 
 */
package br.com.cenaculo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import br.com.cenaculo.dao.SantoDao;
import br.com.cenaculo.model.Santo;

/**
 * @author prisc
 *
 */
public class SantoService implements ISanto {
	
	@Autowired
	private SantoDao santoDao ;
	
	/**
	 * 
	 */
	public SantoService() {
		super();
	}

	@Override
	public String addSanto(String santoNovo) {
		
		santoDao = new SantoDao();
		Santo santo = null;
		Gson gson = new Gson();
		try {
			santo = gson.fromJson(santoNovo, Santo.class);
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		}
		santoDao.addSanto(santo);
		
		return "Cadastrado";
		
	}

	
	public Santo searchSantobyDay(String dia) {
		santoDao = new SantoDao();
		Santo santo = santoDao.searchSantobyDay(dia);
		return santo;
	}

	@Override
	public List<Santo> searchSantoAll() {
		
	
		
		santoDao = new SantoDao();
	
		List<Santo> santos = santoDao.searchSantoAll();
		
		return santos;
		
		
	}

	@Override
	public String updateSanto(Santo santoAtualiza) {
		santoDao = new SantoDao();
		santoDao.updateSanto(santoAtualiza);
		return "Atualizado";
	}

	@Override
	public void deleteSanto(Santo santo) {
		santoDao = new SantoDao();
		santoDao.deleteSanto(santo);
	}

}

/**
 * 
 */
package br.com.cenaculo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import br.com.cenaculo.dao.AparicaoDao;
import br.com.cenaculo.model.Aparicao;

/**
 * @author prisc
 *
 */
public class AparicaoService implements IAparicao {
	
	@Autowired
	private AparicaoDao aparicaoDao ;
	
	/**
	 * 
	 */
	public AparicaoService() {
		super();
	}

	@Override
	public String addAparicao(String aparicaoNovo) {
		
		aparicaoDao = new AparicaoDao();
		Aparicao aparicao = null;
		Gson gson = new Gson();
		try {
			aparicao = gson.fromJson(aparicaoNovo, Aparicao.class);
			aparicao.setStatus("A");
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
		}
		aparicaoDao.addAparicao(aparicao);
		
		return "Cadastrado";
	}

	
	public Aparicao searchAparicaobyDay(String dia) {

		aparicaoDao = new AparicaoDao();
		
		Aparicao aparicao = aparicaoDao.searchAparicaobyDay(dia);
		
		return aparicao;
	}

	@Override
	public List<Aparicao> searchAparicaoAll() {
		aparicaoDao = new AparicaoDao();
	
		List<Aparicao> aparicao = aparicaoDao.searchAparicaoAll();
		
		return aparicao;
	}

	@Override
	public String updateAparicao(Aparicao aparicao) {
		aparicaoDao = new AparicaoDao();
		aparicaoDao.updateAparicao(aparicao);
		return "Atualizado";
	}

	@Override
	public void deleteAparicao(Aparicao aparicao) {
		aparicaoDao = new AparicaoDao();
		aparicaoDao.deleteAparicao(aparicao);
	}

}

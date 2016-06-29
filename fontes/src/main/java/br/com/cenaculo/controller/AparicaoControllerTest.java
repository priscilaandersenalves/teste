package br.com.cenaculo.controller;

import static org.junit.Assert.*;

import org.junit.Test;

public class AparicaoControllerTest {

	@Test
	public void testAddAparicao() {
		AparicaoController controller = new AparicaoController();
		String jsonEntrada = "{	\'nome\': \'teste1\',\'descricao\': \'Test4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdg\',"
				+ "\'dia\': 1,\'mes\':1,	\'foto\': \'foto0102.jpg\' }";

		String resposta = controller.addAparicao(jsonEntrada);
		assertTrue("teste", resposta.contains("Cadastrado"));
	}

	@Test
	public void testSearchAparicao() {
		AparicaoController controller = new AparicaoController();

		String resposta = controller.searchAparicao();
		assertTrue(resposta.contains("aparicaoId"));
	}

	@Test
	public void testSearchAparicaobyDay() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateAparicao() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteAparicao() {
		fail("Not yet implemented");
	}

}

package br.com.cenaculo.controller;

public class SantoControllerTest {
/*
	@Test
	public void testAdd() {
		SantoController controller = new SantoController();
		String jsonEntrada = "{	\'nome\': \'teste1\',\'descricao\': \'Test4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdgTest4 tefrtetgfgffdgdgdg\',"
				+ "\'dia\': 1,\'mes\':1,	\'foto\': \'foto0102.jpg\' }";
		
		String resposta = controller.addSanto(jsonEntrada);
		assertTrue("teste", resposta.contains("Cadastrado"));
	}

	
	@Test
	public void testAllSantos() {
		SantoController controller = new SantoController();
		
		String resposta = controller.searchSanto();
		assertTrue("teste",resposta.length()>0);
	}
	
	
	@Test
	public void testSantobyDay() {
		SantoController controller = new SantoController();
		
		String resposta = controller.searchSantobyDay("0101");
		assertTrue("teste",resposta.length()>0);
	}
	
	
	@Test
	public void testAtualizaSantobyDay() throws SQLDataException {
		SantoController controller = new SantoController();
		String jsonEntrada = "{	\'nome\': \'altera nome\',\'descricao\': \'teste teste santo 1teste teste santo 1teste teste santo 1teste teste santo 1teste teste santo 1teste teste santo 1teste teste santo 1<br> teste teste santo 1teste teste santo 1teste teste santo 1teste teste santo 1teste teste santo 1teste teste santo 1teste teste santo 1<br> teste teste santo 1teste teste santo 1teste teste santo 1teste teste santo 1teste teste santo 1teste teste santo 1teste teste santo 1<br> teste teste santo 1teste teste santo 1teste teste santo 1teste teste santo 1teste teste santo 1teste teste santo 1teste teste santo 1<br> teste teste santo 1teste teste santo 1teste teste santo 1teste teste santo 1teste teste santo 1teste teste santo 1teste teste santo 1<br> teste teste santo 1teste teste santo 1teste teste santo 1teste teste santo 1teste teste santo 1teste teste santo 1teste teste santo 1<br> teste teste santo 1teste teste santo 1teste teste santo 1teste teste santo 1teste teste santo 1teste teste santo 1teste teste santo 1<br> teste teste santo 1teste teste santo 1teste teste santo 1teste teste santo 1teste teste santo 1teste teste santo 1teste teste santo 1<br> teste teste santo 1teste teste santo 1teste teste santo 1teste teste santo 1teste teste santo 1teste teste santo 1teste teste santo 1<br> \',"
				+ "\'dia\': 1,\'mes\':1,	\'foto\': \'foto0102.jpg\' }";
		
		String resposta = controller.updatePayment("0101", jsonEntrada);
		
		assertTrue("teste", resposta.contains("Atualizado"));
	}
	
	@Test
	public void testDeleteSanto() throws SQLDataException{
		SantoController controller = new SantoController();
		String resposta = controller.deleteSanto("0101");
		
		assertTrue("teste", resposta.contains("deletedo"));
		
	}
	*/
}

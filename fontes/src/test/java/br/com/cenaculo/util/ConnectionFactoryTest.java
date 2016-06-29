package br.com.cenaculo.util;

import org.junit.Assert;
import org.junit.Test;

public class ConnectionFactoryTest {

	@Test
	public void testGetConnection() {
		ConnectionFactory con = new ConnectionFactory();
		con.getConnection();
		Assert.assertTrue("Conexao Ativa", con != null ? true : false);
	}

	@Test
	public void testConectarSQL() {
		ConnectionFactory con = new ConnectionFactory();
		con.conectarSQL();
		Assert.assertTrue("Conexao Ativa", con != null ? true : false);
	}

}

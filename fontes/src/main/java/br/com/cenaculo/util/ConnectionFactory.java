
package br.com.cenaculo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Priscila.Andersen
 *
 */
public class ConnectionFactory {
	

	public Connection conectarSQL() {
		Connection conn = null;
		try {

			String host = "localhost";
			String user = "root";
			String pass = "";
			String database = "cenaculo";
			String portNumber = "3306";

			String url = "jdbc:mysql://" + host + ":" + portNumber	+ "/" + database;
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (InstantiationException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return conn;
	}
}

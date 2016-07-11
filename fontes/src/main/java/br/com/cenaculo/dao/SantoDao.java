/**
 * 
 */
package br.com.cenaculo.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.cenaculo.model.Santo;
import br.com.cenaculo.util.ConnectionFactory;

/**
 * @author prisc
 *
 */
public class SantoDao implements ISanto {
	private ConnectionFactory con = new ConnectionFactory();

	/**
	 * 
	 */
	public SantoDao() {
		super();
	}

	public void addSanto(Santo santo) {

		Connection dbConnection = null;
		Statement statement = null;

		String insertTableSQL = "INSERT INTO santodia (Nome, Historia, Dia, Mes, Foto) VALUES ('"
				+ santo.getNomeSanto() + "','" + santo.getDescricao() + "'," + santo.getDia() + "," + santo.getMes()
				+ ",'" + santo.getFoto() + "')";

		try {
			dbConnection = con.conectarSQL();
			statement = dbConnection.createStatement();

			System.out.println(insertTableSQL);

			// execute insert SQL stetement
			statement.executeUpdate(insertTableSQL);

			System.out.println("Record is inserted into DBUSER table!");

		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			if (statement != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

	}

	@Override
	public Santo searchSantobyDay(String dia) {
		Santo santo = null;
		Connection conn = con.conectarSQL();
		ResultSet rs;
		Statement stmt = null;

		String diaSanto = dia.substring(0, 2);
		String mesSanto = dia.substring(2, 4);
		System.out.println(diaSanto + " " + mesSanto);
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(
					"SELECT id, Nome, Historia, Dia, Mes, Foto FROM santodia  where Dia = "
							+ diaSanto + " and Mes = " + mesSanto);

			while (rs.next()) {
				santo = new Santo();
				santo.setSantoId(rs.getInt("id"));
				santo.setNomeSanto(rs.getString("Nome"));
				santo.setDescricao(rs.getString("Historia"));
				santo.setDia(rs.getInt("Dia"));
				santo.setMes(rs.getInt("Mes"));
				santo.setFoto(rs.getString("Foto"));
				
			}
		} catch (SQLException e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		} finally {
			if (stmt != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return santo;
	}

	public List<Santo> searchSantoAll() {
		List<Santo> listSantos = new ArrayList<Santo>();

		Connection conn = con.conectarSQL();
		ResultSet rs;
		Statement stmt = null;

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT id, Nome, Historia, Dia, Mes, Foto FROM santodia ");

			while (rs.next()) {
				Santo santo = new Santo();
				santo.setSantoId(rs.getInt("id"));
				santo.setNomeSanto(rs.getString("Nome"));
				santo.setDescricao(rs.getString("Historia"));
				santo.setDia(rs.getInt("Dia"));
				santo.setMes(rs.getInt("Mes"));
				santo.setFoto(rs.getString("Foto"));

				listSantos.add(santo);
			}
		} catch (SQLException e) {
			System.err.println("Got an exception! ");
			System.err.println(e.getMessage());
		} finally {
			if (stmt != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return listSantos;
	}

	@Override
	public void updateSanto(Santo santo) {
		Connection dbConnection = null;
		Statement statement = null;

		
		try {
			dbConnection = con.conectarSQL();
			statement = dbConnection.createStatement();
			
			String sql = "UPDATE santodia SET  Nome = '" + santo.getNomeSanto() + "', Historia = '"
					+ santo.getDescricao() + "', Dia = " + santo.getDia() + ", Mes = " + santo.getMes() + ", Foto = '"
					+ santo.getFoto() + "'  WHERE id = " + santo.getSantoId();
			
			System.out.println(sql);

			// execute update SQL stetement
			statement.executeUpdate(sql);

			System.out.println("Record is updated into table!");

		} catch (SQLException e) {
			System.out.println(e.getMessage());

		} finally {

			if (statement != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

	}

	@Override
	public void deleteSanto(Santo santo) {
		Connection dbConnection = null;
		Statement statement = null;
		
		try {
			dbConnection = con.conectarSQL();
			statement = dbConnection.createStatement();
			
			String sql = "DELETE FROM santodia WHERE id = " + santo.getSantoId();
			
			System.out.println(sql);

			// execute update SQL stetement
			statement.executeUpdate(sql);

			System.out.println("Record is deleted into table!");

		} catch (SQLException e) {
			System.out.println(e.getMessage());

		} finally {

			if (statement != null) {
				try {
					dbConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}

	}


	

}

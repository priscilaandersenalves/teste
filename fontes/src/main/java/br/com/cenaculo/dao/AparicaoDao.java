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

import br.com.cenaculo.model.Aparicao;
import br.com.cenaculo.util.ConnectionFactory;

/**
 * @author prisc
 *
 */
public class AparicaoDao implements IAparicao {
	private ConnectionFactory con = new ConnectionFactory();

	/**
	 * 
	 */
	public AparicaoDao() {
		super();
	}

	@Override
	public void addAparicao(Aparicao aparicao) {

		Connection dbConnection = null;
		Statement statement = null;

		String insertTableSQL = "INSERT INTO aparicao (nome, descricao, dia, mes, foto, status) VALUES ('"
				+ aparicao.getNome() + "','" + aparicao.getDescricao() + "'," + aparicao.getDia() + "," + aparicao.getMes()
				+ ",'" + aparicao.getFoto() + "','" + aparicao.getStatus() + "')";

		try {
			dbConnection = con.conectarSQL();
			statement = dbConnection.createStatement();

			System.out.println(insertTableSQL);

			// execute insert SQL stetement
			statement.executeUpdate(insertTableSQL);

			System.out.println("Record is inserted into table!");

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
	public Aparicao searchAparicaobyDay(String dia) {
		Aparicao aparicao = null;
		Connection conn = con.conectarSQL();
		ResultSet rs;
		Statement stmt = null;

		String diaSanto = dia.substring(0, 2);
		String mesSanto = dia.substring(2, 4);
		System.out.println(diaSanto + " " + mesSanto);
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(
					"SELECT idaparicao, nome, descricao, dia, mes, foto, status FROM cenaculo.aparicao  where dia = "
							+ diaSanto + " and mes = " + mesSanto);

			while (rs.next()) {
				aparicao = new Aparicao();
				aparicao.setIdaparicao(rs.getInt("idaparicao"));
				aparicao.setNome(rs.getString("nome"));
				aparicao.setDescricao(rs.getString("descricao"));
				aparicao.setDia(rs.getInt("dia"));
				aparicao.setMes(rs.getInt("mes"));
				aparicao.setFoto(rs.getString("foto"));
				aparicao.setStatus(rs.getString("status"));
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
		return aparicao;
	}

	public List<Aparicao> searchAparicaoAll() {
		List<Aparicao> listAparicao = new ArrayList<Aparicao>();

		Connection conn = con.conectarSQL();
		ResultSet rs;
		Statement stmt = null;

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT idaparicao, nome, descricao, dia, mes, foto, status FROM cenaculo.Aparicao");

			while (rs.next()) {
				Aparicao aparicao = new Aparicao();
				aparicao.setIdaparicao(rs.getInt("idaparicao"));
				aparicao.setNome(rs.getString("nome"));
				aparicao.setDescricao(rs.getString("descricao"));
				aparicao.setDia(rs.getInt("dia"));
				aparicao.setMes(rs.getInt("mes"));
				aparicao.setFoto(rs.getString("foto"));
				aparicao.setStatus(rs.getString("status"));

				listAparicao.add(aparicao);
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
		return listAparicao;
	}

	@Override
	public void updateAparicao(Aparicao aparicao) {
		Connection dbConnection = null;
		Statement statement = null;
		try {
			dbConnection = con.conectarSQL();
			statement = dbConnection.createStatement();
			
			String sql = "UPDATE Aparicao SET  nome = '" + aparicao.getNome() + "', descricao = '"
					+ aparicao.getDescricao() + "', dia = " + aparicao.getDia() + ", mes = " + aparicao.getMes() + ", foto = '"
					+ aparicao.getFoto() + "', status = '" + aparicao.getStatus() + "' WHERE idaparicao = " + aparicao.getIdaparicao();
			
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
	public void deleteAparicao(Aparicao aparicao) {
		Connection dbConnection = null;
		Statement statement = null;
		
		try {
			dbConnection = con.conectarSQL();
			statement = dbConnection.createStatement();
			
			String sql = "DELETE FROM aparicao WHERE idaparicao = " + aparicao.getIdaparicao();
			
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

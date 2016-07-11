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

		String insertTableSQL = "INSERT INTO aparicaomaria (nome, descricao, dia, mes, ano,  foto) VALUES ('"
				+ aparicao.getNome() + "','" + aparicao.getDescricao() + "'," + aparicao.getDia() + ","
				+ aparicao.getMes() + "," + aparicao.getAno() + ",'" + aparicao.getFoto() + "')";

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
	public Aparicao searchAparicaobyDay(String data) {
		Aparicao aparicao = null;
		Connection conn = con.conectarSQL();
		ResultSet rs;
		Statement stmt = null;
		String diaSanto, mesSanto, anoSanto = null;
		if (data.length() == 8) {
			diaSanto = data.substring(0, 2);
			mesSanto = data.substring(2, 4);
			anoSanto = data.substring(4, 8);
		} else {
			diaSanto = data.substring(0, 2);
			mesSanto = data.substring(2, 4);
			anoSanto = data.substring(4, 6);
		}

		System.out.println(diaSanto + "/" + mesSanto + "/" + anoSanto);
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT id, nome, descricao, dia, mes,ano,  foto FROM aparicaomaria  where dia = "
					+ diaSanto + " and mes = " + mesSanto + " and ano = " + anoSanto);

			while (rs.next()) {
				aparicao = new Aparicao();
				aparicao.setIdaparicao(rs.getInt("id"));
				aparicao.setNome(rs.getString("nome"));
				aparicao.setDescricao(rs.getString("descricao"));
				aparicao.setDia(rs.getInt("dia"));
				aparicao.setMes(rs.getInt("mes"));
				aparicao.setAno(rs.getInt("ano"));
				aparicao.setFoto(rs.getString("foto"));
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
			rs = stmt.executeQuery("SELECT id, nome, descricao, dia, mes, ano, foto FROM aparicaomaria");

			while (rs.next()) {
				Aparicao aparicao = new Aparicao();
				aparicao.setIdaparicao(rs.getInt("id"));
				aparicao.setNome(rs.getString("nome"));
				aparicao.setDescricao(rs.getString("descricao"));
				aparicao.setDia(rs.getInt("dia"));
				aparicao.setMes(rs.getInt("mes"));
				aparicao.setAno(rs.getInt("ano"));
				aparicao.setFoto(rs.getString("foto"));

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

			String sql = "UPDATE aparicaomaria SET  nome = '" + aparicao.getNome() + "', descricao = '"
					+ aparicao.getDescricao() + "', dia = " + aparicao.getDia() + ", mes = " + aparicao.getMes()
					+ ",  ano = " + aparicao.getAno() + ", foto = '" + aparicao.getFoto() + "' WHERE id = "
					+ aparicao.getIdaparicao();

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

			String sql = "DELETE FROM aparicaomaria WHERE id = " + aparicao.getIdaparicao();

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

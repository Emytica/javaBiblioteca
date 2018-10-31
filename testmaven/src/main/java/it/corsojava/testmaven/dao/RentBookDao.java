package it.corsojava.testmaven.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import it.corsojava.testmaven.vo.LibriVo;
import it.corsojava.testmaven.vo.UtenteVo;

public class RentBookDao {

	public void initDbNoleggio(UtenteVo utente, LibriVo libro) {
		int risultato = 0;
		Connection conn = null;
		try {
			conn = ServerManager.getInstance().connection();
			conn.setAutoCommit(false);
			String query = "insert into noleggio (idutente,idlibro)values(?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, utente.getId());
			ps.setInt(2, libro.getId());
			risultato = ps.executeUpdate();
			String queryLibro = "update libro set disponibilita = ? where id = ?";
			ps = conn.prepareStatement(queryLibro);
			ps.setString(1, "no");
			ps.setInt(2, libro.getId());
			risultato = ps.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			if (conn != null)
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
		} finally {

			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
}

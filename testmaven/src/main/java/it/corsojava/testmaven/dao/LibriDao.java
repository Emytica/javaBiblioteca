package it.corsojava.testmaven.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import it.corsojava.testmaven.vo.LibriVo;

public class LibriDao {

	public void insertLibro(LibriVo libro) {
		Connection connect = null;
		int inserisci = 0;
		try {
			connect = ServerManager.getInstance().connection();
			String query = "insert into libro (nome,autore,isbn,disponibilita) values (?,?,?,?)";
			PreparedStatement pr = connect.prepareStatement(query);
			pr.setString(1, libro.getNome());
			pr.setString(2, libro.getAutore());
			pr.setString(3, libro.getIsbn());
			pr.setString(4, libro.getDisponibilita());
			inserisci = pr.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connect.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public List<LibriVo> sfogliaLibri() {
		List<LibriVo> libri = new ArrayList<>();
		Connection conn = null;
		try {
			conn = ServerManager.getInstance().connection();
			String query = "select * from libro";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				int id = rs.getInt("idlibro");
				String nome = rs.getString("nome");
				String autore = rs.getString("autore");
				String isbn = rs.getString("isbn");
				String disponibilita = rs.getString("disponibilita");
				LibriVo libro = new LibriVo();
				libro.setId(id);
				libro.setNome(nome);
				libro.setAutore(autore);
				libro.setIsbn(isbn);
				libro.setDisponibilita(disponibilita);

				libri.add(libro);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return libri;

	}

}

package it.corsojava.testmaven.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.corsojava.testmaven.vo.UtenteVo;

public class SecurityDao {

	public UtenteVo autenticationUsernameAndPassword(String username, String password) {
		UtenteVo retUser = null;
		Connection connect = null;
		try {
			connect = ServerManager.getInstance().connection();
			String query = "select * from utente where username= ? and password= ?";
			PreparedStatement pS = connect.prepareStatement(query);
			pS.setString(1, username);
			pS.setString(2, password);

			ResultSet rS = pS.executeQuery();

			while (rS.next()) {
				int id = rS.getInt("idutente");
				String nome = rS.getString("nome");
				String cognome = rS.getString("cognome");
				String user = rS.getString("username");
				String pwd = rS.getString("password");
				String cf = rS.getString("cf");
				retUser = new UtenteVo();
				retUser.setId(id);
				retUser.setUsername(user);
				retUser.setPassword(pwd);
				retUser.setNome(nome);
				retUser.setCognome(cognome);
				retUser.setCf(cf);
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connect.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return retUser;
	}

}

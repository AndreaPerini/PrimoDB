package it.gov.itisfeltrinelli.PrimoDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {

	public static void main(String[] args) {
//		String DBurl = "jdbc:mysql://localhost:3306/perinialves";
		String DBurl = "jdbc:mysql://localhost:3306/dizionario";
		try {
			Connection c = DriverManager.getConnection(DBurl, "root", "");
			String stmt = " SELECT * FROM parola WHERE nome='v%';";
			Statement s = c.createStatement();
			ResultSet r = s.executeQuery(stmt);
			while (r.next()) {
//				System.out.format("Nome: \"%s\" Cognome \"%s\" Eta %d anni \n", r.getString("NOME"),
//						r.getString("COGNOME"), r.getInt("ETA"));
				System.out.format("ID: %d \"%s\" \n", r.getInt("ID"), r.getString("NOME"));

			}
			if (null != r)
				r.close();
			if (null != s)
				s.close();
			c.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}

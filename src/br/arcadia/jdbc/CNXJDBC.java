package br.arcadia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CNXJDBC {

	private String usuario = "SA";
	private String senha = "";
	private String PathBase = "C:\\Users\\978907\\workspace\\ConexaoJDBC\\base\\exemplotexte";
	private String URL = "jdbc:hsqldb:file:" + PathBase + ";";

	public Connection conectar() {
		try {
			return DriverManager.getConnection(URL, usuario, senha);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}

}

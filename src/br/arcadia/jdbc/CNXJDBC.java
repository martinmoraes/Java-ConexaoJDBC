package br.arcadia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CNXJDBC {

	private static final String DRIVER_CLASS = "org.hsqldb.jdbcDriver";
	private static Connection cnx = null;
	private static String usuario = "SA";
	private static String senha = "";
	private static String PathBase = "C:\\Users\\Martin\\workspace\\ConectandoDB\\base\\exemplotexte";
	private static final String URL = "jdbc:hsqldb:file:" + PathBase;

	public static Connection conectar() {
		if(cnx == null){
			try {
				Class.forName(DRIVER_CLASS);
				// Estabelecendo conexão
				cnx = DriverManager.getConnection(URL, usuario, senha);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return cnx;
	}

}

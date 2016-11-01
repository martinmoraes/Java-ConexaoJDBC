package br.arcadia.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CNXJDBC {

	private final String DRIVER_CLASS = "org.hsqldb.jdbcDriver";
	private static Connection cnx = null;
	private static String usuario = "SA";
	private static String senha = "";
	private static String PathBase = "C:\\Users\\978907\\workspace\\ConexaoJDBC\\base\\exemplotexte";
	//C:\Users\978907\workspace\ConexaoJDBC\base
	private static final String URL = "jdbc:hsqldb:file:" + PathBase + ";shutdown=true;";

	public static Connection conectar() {
		/*if(cnx == null){
			try {
				Class.forName(DRIVER_CLASS);
				cnx = DriverManager.getConnection(URL, usuario, senha);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cnx;*/
		try {
			return DriverManager.getConnection(URL, usuario, senha);
		} catch (SQLException e) {
			throw new RuntimeException();
		}
	}
	
	public static void fecharCNX(){
		try {
			cnx.close();
			cnx = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

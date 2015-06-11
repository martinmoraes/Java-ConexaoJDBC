package teste;

import java.sql.Connection;

import br.arcadia.jdbc.CNXJDBC;

public class Principal {

	public static void main(String[] args) {
		
		Connection c = CNXJDBC.conectar();
		
		if(c==null)
			System.out.println("Não conectou!!!");
		else
			System.out.println("Conectou");
	}

}

package teste;

import java.sql.Connection;
import java.util.ArrayList;

import br.arcadia.dao.UsuarioDAO;
import br.arcadia.entidade.Usuario;
import br.arcadia.jdbc.CNXJDBC;

public class Principal {

	public static void main(String[] args) {
		UsuarioDAO usrDAO = new UsuarioDAO();
		Usuario umUsr = new Usuario();
		
		umUsr.setNome("TESTE NOVO");
		umUsr.setEMail("teste_novo@tr.tr");
		
		usrDAO.inserirUsuario(umUsr);
		
		ArrayList<Usuario> listUsuarios = usrDAO.listarTodosUsuarios();
		for(Usuario umUsuario : listUsuarios)
			System.out.println(umUsuario.toString());
		
		
	}

}

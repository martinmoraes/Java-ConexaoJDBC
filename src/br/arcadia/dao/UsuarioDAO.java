package br.arcadia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.arcadia.entidade.Usuario;
import br.arcadia.jdbc.CNXJDBC;



public class UsuarioDAO {
	private final String SQL_INSERE_USUARIO= "INSERT INTO PUBLIC.USUARIOS (NOME, EMAIL ) VALUES ( ?, ?);";
	private final String SQL_ALTERA_USUARIO= "UPDATE PUBLIC.USUARIOS SET NOME=?, EMAIL=? WHERE ID=?;";
	private final String SQL_EXCLUI_USUARIO= "DELETE FROM PUBLIC.USUARIOS WHERE ID=?";
	private final String SQL_SELECIONA_USUARIO= "SELECT * FROM PUBLIC.USUARIOS";
	
	
	private Connection conn = CNXJDBC.conectar();
	private PreparedStatement pst = null;
	
	public ArrayList<Usuario> listarTodosUsuarios(){
		ArrayList<Usuario> listaDeUsuarios = new ArrayList<Usuario>();
		
		Usuario umUsuario;
		try{
			pst = conn.prepareStatement(SQL_SELECIONA_USUARIO);
			ResultSet rs = pst.executeQuery();
			while(rs.next()){
				umUsuario = new Usuario();
				umUsuario.setCodigo(rs.getInt("ID"));
				umUsuario.setNome(rs.getString("NOME"));
				umUsuario.setEMail(rs.getString("EMAIL"));
				listaDeUsuarios.add(umUsuario);		
			}
			rs.close();
			pst.close();
		}catch (SQLException e){
			System.out.println("Erro ao executar o Statement"+ e.toString());
		}
		
		return listaDeUsuarios;
	}
	
	public boolean inserirUsuario(Usuario umUsuario){
		boolean ret = false;
		try{
			pst = conn.prepareStatement(SQL_INSERE_USUARIO);
			pst.setString(1, umUsuario.getNome());
			pst.setString(2, umUsuario.getEMail());
			ret = pst.execute();
			pst.close();
		}catch (SQLException e){
			System.out.println("Erro ao executar o Statment "+e.toString());
		}
		
		return ret;
	}
	
	public boolean alterarUsuario(Usuario umUsuario){
		boolean ret = false;
		try{
			pst = conn.prepareStatement(SQL_ALTERA_USUARIO);
			pst.setString(1,umUsuario.getNome());
			pst.setString(2, umUsuario.getEMail());
			pst.setInt(3, umUsuario.getCodigo());
			ret = pst.execute();
			pst.close();
		}catch (SQLException e){
			System.out.println("Erro ao executar o Statment "+e.toString());
		}
		return ret;
	}
	
	public boolean excluiUsuario(Usuario umUsuario){
		boolean ret = false;
		try{
			pst = conn.prepareStatement(SQL_EXCLUI_USUARIO);
			pst.setInt(1, umUsuario.getCodigo());
			ret = pst.execute();
			pst.close();
		}catch (SQLException e){
			System.out.println("Erro ao executar o Statment "+e.toString());
		}
		return ret;
	}
}

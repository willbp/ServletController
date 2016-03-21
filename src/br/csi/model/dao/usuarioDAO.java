package br.csi.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.csi.model.Usuario;
import br.csi.model.util.ConectaBDPostgres;
/**
 * 
 * 
 * create table usuario(
 *id serial, login varchar(10) not null, senha varchar(10) not null, primary key(id))
 *
 *select * from usuario
 *
 *insert into usuario(login, senha) values ('william','123')
 *
 */
public class usuarioDAO {
	
	public static void main(String[] args) {
		
		Usuario u = new Usuario();
		u.setLogin("");
		u.setSenha("");
		
		try {
			System.out.println("autenticado? "
					+ ""+new usuarioDAO().autenticado(u));
			new usuarioDAO().autenticado(u);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	
	public boolean autenticado(Usuario u) throws SQLException{
		boolean autenticado=false;
		
		Connection c = ConectaBDPostgres.getConexao();
		Statement stmt = c.createStatement();
		String sql = "select * from usuario "
				+"where login = '"+u.getLogin()+"'"
				+" and senha = '"+u.getSenha()+"';";
		
		System.out.println(sql);
		
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()){
			long id = rs.getLong("id");
			String login = rs.getString("login");
			String senha = rs.getString("senha");
			autenticado = true;
			
		}
		
		return autenticado;
		
	}
}

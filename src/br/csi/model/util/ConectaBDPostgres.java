package br.csi.model.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConectaBDPostgres {

	
	public static void main (String args[]){
		ConectaBDPostgres.getConexao();
		System.out.println("conex�o aberta!");
	}
		public static Connection getConexao(){
			
			Connection c = null;
			
			try {
				Class.forName("org.postgresql.Driver");
				String url="jdbc:postgresql://localhost:5432/internetb";
				String user = "postgres";
				String password= "1234";
				c = DriverManager.getConnection(url, user, password);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			return c;
			
		}
	
}

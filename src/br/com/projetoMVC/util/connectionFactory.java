package br.com.projetoMVC.util;

import java.sql.Statement;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class connectionFactory {
	
	public static final String PATH = "jdbc:postgresql://localhost:5432/turmajava";
	public static final String USER = "postgres";
	public static final String PASSWORD = "postgres";
	
	// Método que retorna a conexão estabelecida 
	public static Connection getConnection() throws Exception{
		try {
			// Carregar o driver do postgresql
			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection(PATH, USER, PASSWORD);
		} catch (Exception e) {
			// Mostra uma mensagem de erro caso a conexão falhar
			throw new Exception(e.getMessage());
		}
	}
	
	public static void closeConnection(Connection conn, Statement stmt, ResultSet rs) throws Exception {
		close(conn, stmt, rs);
	}
	
	public static void closeConnection(Connection conn, Statement stmt) throws Exception {
		close(conn, stmt, null);
	}
	
	public static void closeConnection(Connection conn) throws Exception {	
		close(conn, null, null);
	}
	
	private static void close(Connection conn, Statement stmt, ResultSet rs) throws Exception {
		try {
			if (rs != null) 
				rs.close();
			
			if (stmt != null) 
				stmt.close();
				
			if (conn != null) 
				conn.close();
			 
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	

}
package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Model {

	private static Connection conn;
	private static Statement stm;
	
	public Model(){
		initConnection();
	}
	
	public static Connection getConection(){
		return Model.conn;
	}
	
	
	public static Statement getStatement(){
		return stm;
	}
	
	
	public void initConnection(){
		
		try{
			//Tenta carregar o driver para o banco de dados
			Class.forName("org.hsqldb.jdbcDriver");
			
			//Inicia conexão
			conn = DriverManager.getConnection("jdbc:hsqldb:file:/temp/apsdb", "sa", "");
		}
		
		catch(ClassNotFoundException e){
			System.out.println(e.getMessage());
		} 
		
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
}

package Models;

import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Entidades.Cliente;

public class ClienteModel extends Model {

	Statement stm;
	ResultSet rs;

	public ClienteModel() {
		super();
	}

	
	
	public Cliente getClienteById(String id) throws SQLException{
		Cliente cliente = new Cliente();
		
		stm = Model.getConection().createStatement();
		rs  = stm.executeQuery("SELECT * FROM clientes WHERE id = " + id);
		
		cliente.nome  = rs.getString("nome");
		cliente.email = rs.getString("email");
		
		return cliente;
		
	}

	
	public int verifyClienteExists(String column, String value){
		
		int ret = 1;
		
		try {
			stm = Model.getConection().createStatement();
			rs  = stm.executeQuery("SELECT COUNT(id) AS cont from clientes WHERE "+column+" = '"+value+"'");
			rs.next();
			
			if(rs.getString("cont").equals("0")){
				ret = 0;
			}
		} 
		
		catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			ret = 1;
		}
		return ret;
	}
	
	
	public void addCliente(Cliente c){
		
		try {
			stm = Model.getConection().createStatement();
			rs  = stm.executeQuery("INSERT INTO clientes (nome,email,cpf) VALUES ('"+c.nome+"','"+c.email+"','"+c.cpf+"')");
			stm.execute("SHUTDOWN");
		}
		
		catch(SQLException e){
			System.out.print(e.getMessage());
		}
	}
	
	
	
	public ArrayList<Cliente> getClientes() {
	
		ArrayList <Cliente> clientes = new ArrayList <Cliente>();
		
		try {
			stm = Model.getConection().createStatement();
			rs  = stm.executeQuery("SELECT * FROM clientes");
			
		    while(rs.next()){
		        
		    	Cliente c 	= new Cliente();
		    	c.nome  	= rs.getString("nome");
		    	c.email 	= rs.getString("email");
		    	c.cpf   	= rs.getString("cpf");
		    	c.telefone	= rs.getString("telefone");
		    	
		    	clientes.add(c);
		    }
		    
		    //stm.execute("SHUTDOWN");
	        
		} 
		
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return clientes;
		
	}// end getClientes

}

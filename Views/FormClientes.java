package Views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import Entidades.Cliente;
import Listeners.NovoClienteListener;
import Models.ClienteModel;

public class FormClientes extends JFrame {

	private static JPanel mainPanel, menuPanel;
	private static JButton btnNovoCliente, btnDelCliente, btnEditCliente;
	private static JTable table;
	public static DefaultTableModel modelClientes;
	
	
	public FormClientes(){
			super("Clientes");
			this.setVisible(true);
			this.setSize(800, 600);			
			inicializaComponentes();
	}
	
	public static DefaultTableModel getModel(){
		return modelClientes;
	}
	
	
	private void inicializaComponentes(){
		
		mainPanel	=	new JPanel( new BorderLayout());
		menuPanel	=	new JPanel( new FlowLayout( FlowLayout.LEFT));
		
		btnNovoCliente	= new JButton("Novo Cliente");
		btnDelCliente	= new JButton("Remover Cliente");
		btnEditCliente	= new JButton("Editar Ciente");
		
		btnNovoCliente.addActionListener(new NovoClienteListener());
		
		menuPanel.add(btnNovoCliente);
		menuPanel.add(btnDelCliente);
		menuPanel.add(btnEditCliente);
		
		String[] colunas = new String[]{"Nome", "Email", "CPF", "Telefone", "Celular", "Telefone Recado", "Endereco", "Bairro", "Cidade", "UF","CEP"};
		
		modelClientes	= new DefaultTableModel(null,colunas);
		populaTabela();
		
		table  			= new JTable( modelClientes );
		
		JScrollPane scroll = new JScrollPane( table );
		
		mainPanel.add(menuPanel, BorderLayout.NORTH);
		mainPanel.add(scroll, BorderLayout.CENTER);
		
		this.getContentPane().add(mainPanel);
	}
	
	
	private void populaTabela(){
		
		ClienteModel model_cliente = new ClienteModel();
		ArrayList<Cliente> clientes = model_cliente.getClientes();
		
		for(Cliente cliente:clientes){
			modelClientes.addRow(new String[]{cliente.nome, cliente.email, cliente.cpf, cliente.telefone, cliente.celular, cliente.telRecado, cliente.logradouro, cliente.bairro, cliente.cidade, cliente.uf, cliente.cep});
		}
		
	}
	
}

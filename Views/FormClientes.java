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
import Listeners.*;
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
		btnDelCliente.addActionListener(new DeletaClienteListener());
		
		menuPanel.add(btnNovoCliente);
		menuPanel.add(btnDelCliente);
		menuPanel.add(btnEditCliente);
		
		String[] colunas = new String[]{"COD", "Nome", "Email", "CPF", "Telefone", "Celular", "Telefone Recado", "Endereco", "Bairro", "Cidade", "UF","CEP"};
		
		modelClientes	= new DefaultTableModel(null,colunas);
		populaTabela();
		
		table  			= new JTable( modelClientes );
		
		JScrollPane scroll = new JScrollPane( table );
		
		mainPanel.add(menuPanel, BorderLayout.NORTH);
		mainPanel.add(scroll, BorderLayout.CENTER);
		
		this.getContentPane().add(mainPanel);
	}
	
	
	private void populaTabela(){

		//Obtem os cliente cadastrados no banco de dados
		ClienteModel model_cliente = new ClienteModel();
		
		//Monta um array de objetos do tipo Cliente
		ArrayList<Cliente> clientes = model_cliente.getClientes();
		
		for(Cliente cliente:clientes){
			//Adiciona Clientes na tabela do formulario
			modelClientes.addRow(new String[]{cliente.cod, cliente.nome, cliente.email, cliente.cpf, cliente.telefone, cliente.celular, cliente.telRecado, cliente.logradouro, cliente.bairro, cliente.cidade, cliente.uf, cliente.cep});
		}
		
	}
	
	
	public static void removeLinha(int linha){
		modelClientes.removeRow(linha);
	}
	
	
	
	public static int getSelectedCliente(){
		return table.getSelectedRow();
	}
	
	public static String getCod(int linha){
		return (String) modelClientes.getValueAt(linha, 0);
	}
	
	public static String getCPF(int linha){
		String cpf = (String) modelClientes.getValueAt(linha, 3);
		return cpf;
	}
	
	
	public static String getNome(int linha){
		return (String) modelClientes.getValueAt(linha, 1);
	}
	
	
}

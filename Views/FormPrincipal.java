package Views;

import javax.swing.*;

import java.awt.*;
import Listeners.*;

public class FormPrincipal extends JFrame {
	
	private static JMenuBar mainMenu;
	private static JPanel mainPanel;
	private static JMenu menuClientes, menuCarros;
	private static JMenuItem subNovoCliente, subExibeCliente;
	
	public FormPrincipal(){
		this.setSize(800, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		inicializaComponentes();
		this.setVisible(true);
	}
	
	
	
	private void inicializaComponentes(){
		
		mainPanel = new JPanel(new BorderLayout() );
		this.getContentPane().add(mainPanel);
		
		mainMenu = new JMenuBar();
		menuClientes	=	new JMenu("Clientes");
		menuCarros		=	new JMenu("Carros");
		
		subNovoCliente	=	new JMenuItem("Cadastrar novo cliente");
		subNovoCliente.setIcon(new ImageIcon(getClass().getResource("/resources/icons/user_add_16.png")));
		subNovoCliente.addActionListener(new NovoClienteListener());
		
		subExibeCliente	=	new JMenuItem("Exibir clientes cadastrados");
		subExibeCliente.setIcon(new ImageIcon(getClass().getResource("/resources/icons/user_16.png")));
		subExibeCliente.addActionListener( new ExibeClientesListener());
		
		menuClientes.add(subNovoCliente);
		menuClientes.add(subExibeCliente);
		
		mainMenu.add( menuClientes );
		mainMenu.add( menuCarros );
		
		
		mainPanel.add(mainMenu, BorderLayout.NORTH);
		
	}
	
}

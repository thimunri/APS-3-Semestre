package Views;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import Listeners.NovoClienteListener;
import Listeners.SalvaClienteListener;

import java.awt.*;
import java.text.ParseException;

import Entidades.Cliente;

public class FormNovoCliente extends JFrame{
	
	private static JPanel mainPanel, formPanel;
	public static JTextField	txtNome, txtEmail, txtCpf, txtEndereco, txtNumero, txtBairro, txtUf, txtCidade, txtCep, txtTelefone, txtCelular, txtTelRecado;
	private static JComboBox comboUf;
	private static JButton btnSalvar, btnCancelar;
	
	
	public FormNovoCliente() {
		this.setSize(600, 400);
		
		JPanel formPanel= new JPanel(new GridBagLayout());
		 
		GridBagConstraints cons = new GridBagConstraints();
		
		cons.gridx = 0;
		cons.gridy = 0;
		cons.insets= new Insets(5,5,5,5);
		cons.anchor = cons.EAST;
		formPanel.add(new JLabel("Nome: "),cons);
			
		cons.gridx   = 1;
		cons.gridy 	 = 0;
		cons.anchor = cons.WEST;
		txtNome = new JTextField(15);
		formPanel.add( txtNome, cons);
		
		cons.gridx = 0;
		cons.gridy = 1;
		cons.anchor = cons.EAST;
		formPanel.add(new JLabel("Email: "),cons);
		
		cons.gridx = 1;
		cons.gridy = 1;
		txtEmail = new JTextField(15);
		formPanel.add( txtEmail , cons);
		
		cons.gridx = 0;
		cons.gridy = 2;
		cons.anchor = cons.EAST;
		formPanel.add(new JLabel("CPF: "), cons);
		
		cons.gridx = 1;
		cons.gridy = 2;
		txtCpf		= new JTextField(15);
		formPanel.add( txtCpf , cons);
		
		cons.gridx = 0;
		cons.gridy = 3;
		cons.anchor = cons.EAST;
		formPanel.add(new JLabel("Endere�o: "), cons);
		
		cons.gridx = 1;
		cons.gridy = 3;
		txtEndereco = new JTextField(15);
		formPanel.add( txtEndereco, cons);
		
		cons.gridx = 2;
		cons.anchor = cons.EAST;
		formPanel.add(new JLabel("N�mero: "), cons);
		
		cons.gridx = 3;
		txtNumero  = new JTextField(5);
		cons.anchor = cons.WEST;
		formPanel.add( txtNumero, cons);
		
		cons.gridx = 0;
		cons.gridy = 4;
		cons.anchor = cons.EAST;
		formPanel.add(new JLabel("Bairro:"),cons);
		
		cons.gridx = 1;
		txtBairro  = new JTextField(15);
		formPanel.add( txtBairro , cons);
		
		cons.gridx = 2;
		formPanel.add(new JLabel("UF:"), cons);
		
		cons.gridx = 3;
		String[] ufs = new String[]{"Acre - AC","Alagoas - AL","Amap� - AP","Amazonas - AM","Bahia  - BA","Cear� - CE","Distrito Federal  - DF",
		"Esp�rito Santo - ES","Goi�s - GO","Maranh�o - MA","Mato Grosso - MT","Mato Grosso do Sul - MS","Minas Gerais - MG","Par� - PA",
		"Para�ba - PB","Paran� - PR","Pernambuco - PE","Piau� - PI","Rio de Janeiro - RJ","Rio Grande do Norte - RN","Rio Grande do Sul - RS",
		"Rond�nia - RO","Roraima - RR","Santa Catarina - SC","S�o Paulo - SP","Sergipe - SE","Tocantins - TO"};
		
		comboUf	=	new JComboBox(ufs);
		comboUf.setSelectedIndex(24);
		formPanel.add( comboUf ,cons);
		
		cons.gridx = 0;
		cons.gridy = 5;
		formPanel.add(new JLabel("Cidade: "), cons);
		
		cons.gridx = 1;
		txtCidade  = new JTextField(15);
		formPanel.add( txtCidade , cons);
		
		cons.gridx = 2;
		cons.gridy = 5;
		cons.anchor = cons.EAST;
		formPanel.add(new JLabel("CEP:"),cons);
		
		cons.gridx = 3;
		txtCep     = new JTextField(10);
		cons.anchor = cons.WEST;
		formPanel.add( txtCep , cons);

		cons.gridx = 0;
		cons.gridy = 6;
		cons.anchor = cons.EAST;
		formPanel.add(new JLabel("Telefone:"),cons);
		
		cons.gridx 		= 1;
		txtTelefone     = new JTextField(15);
		cons.anchor = cons.EAST;
		formPanel.add( txtTelefone , cons);


		cons.gridx = 2;
		cons.gridy = 6;
		formPanel.add(new JLabel("Celular:"),cons);		
		
		cons.gridx = 3;
		cons.gridy = 6;
		txtCelular     = new JTextField(15);
		formPanel.add( txtCelular , cons);

		cons.gridx = 0;
		cons.gridy = 7;
		formPanel.add(new JLabel("Tel Recado:"),cons);		
		
		cons.gridx = 1;
		txtTelRecado     = new JTextField(15);
		formPanel.add( txtTelRecado , cons);		
		
				
		
		formPanel.setBorder(new TitledBorder("Informa��es Pessoais"));
		
		JPanel panel = new JPanel(new BorderLayout());
		
		JPanel panelTitulo	= new JPanel( new FlowLayout(FlowLayout.LEFT));
		JPanel panelRodape	= new JPanel( new FlowLayout(FlowLayout.RIGHT));
		
		JLabel lblTitulo   = new JLabel("Cadastrar Novo Cliente");
		lblTitulo.setIcon( new ImageIcon( getClass().getResource("/resources/icons/user_add_32.png")));
		lblTitulo.setFont(new Font("Arial Narrow", Font.BOLD, 24));
		
		
		panelTitulo.add(lblTitulo);
		panelTitulo.setBackground( new Color(255,255,255));
	
		btnSalvar 	= new JButton("Salvar");
		btnCancelar	= new JButton("Cancelar");
		
		btnSalvar.addActionListener(new SalvaClienteListener());
		
		panelRodape.add( btnSalvar );
		panelRodape.add( btnCancelar );
		
		
		panel.add(panelTitulo, BorderLayout.NORTH);
		panel.add(formPanel, BorderLayout.CENTER);
		panel.add(panelRodape, BorderLayout.SOUTH);
		
		add(panel);
		this.setVisible(true);
		
	}
	
	
	public static Cliente getCliente(){		
		
		Cliente novoCliente = new Cliente();
		
		novoCliente.nome     	= txtNome.getText();
		novoCliente.email    	= txtEmail.getText();
		novoCliente.cpf		 	= txtCpf.getText();
		novoCliente.telefone 	= txtTelefone.getText();
		novoCliente.celular		= txtCelular.getText();
		novoCliente.telRecado	= txtTelRecado.getText();
		novoCliente.cep 	 	= txtCep.getText();
		novoCliente.logradouro	= txtEndereco.getText();
		novoCliente.bairro	 	= txtBairro.getText();
		novoCliente.cidade   	= txtCidade.getText();
		novoCliente.uf       	= (String) comboUf.getSelectedItem();
		
		return novoCliente;
	}
	
	
	public void inicializaComponentes(){
		mainPanel = new JPanel( new BorderLayout());
		formPanel = new JPanel();
		
		formPanel.setLayout(new GridLayout(5,5));
		
		formPanel.add(new JLabel("Nome"));
		formPanel.add(new JTextField());
		mainPanel.add(formPanel,BorderLayout.CENTER);
		
		this.getContentPane().add(mainPanel);
	}
	
	
}

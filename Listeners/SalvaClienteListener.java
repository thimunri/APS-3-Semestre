package Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import Views.FormNovoCliente;
import Views.FormClientes;
import Entidades.Cliente;
import Models.ClienteModel;

public class SalvaClienteListener implements ActionListener {
	
		public void actionPerformed(ActionEvent e){
				
				ClienteModel modelo_cliente = new ClienteModel();
				Cliente novoCliente = FormNovoCliente.getCliente();
				
				
				if( novoCliente.email.equals("")){
					JOptionPane.showMessageDialog(null,"Você precisa informar o nome do cliente","Alerta",JOptionPane.INFORMATION_MESSAGE);
				}
				
				else if(novoCliente.cpf.equals("")){
					JOptionPane.showMessageDialog(null,"Você precisa informar o CPF do cliente","Alerta",JOptionPane.INFORMATION_MESSAGE);
				}
				
				else if(modelo_cliente.verifyClienteExists("cpf", novoCliente.cpf) > 0){
					JOptionPane.showMessageDialog(null,"Este CPF já está cadastrado no sistema","Alerta",JOptionPane.INFORMATION_MESSAGE);
				}
				
				else { 
												
						modelo_cliente.addCliente(novoCliente);
						JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso");
						
				}
		}
}

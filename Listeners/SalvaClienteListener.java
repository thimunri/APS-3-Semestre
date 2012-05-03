package Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import Views.FormNovoCliente;
import Views.FormClientes;
import Entidades.Cliente;
import Models.ClienteModel;

import Util.Cpf;

public class SalvaClienteListener implements ActionListener {
	
		public void actionPerformed(ActionEvent e){
				
				ClienteModel modelo_cliente = new ClienteModel();
				Cliente novoCliente = FormNovoCliente.getCliente();
				
				
				if(novoCliente.nome.equals("")){
					JOptionPane.showMessageDialog(null, "Voce precisa informar o nome do cliente");
				}
				
				else if( novoCliente.email.equals("")){
					JOptionPane.showMessageDialog(null,"Voc� precisa informar o email do cliente","Alerta",JOptionPane.INFORMATION_MESSAGE);
				}
				
				else if(novoCliente.cpf.equals("")){
					JOptionPane.showMessageDialog(null,"Voc� precisa informar o CPF do cliente","Alerta",JOptionPane.INFORMATION_MESSAGE);
				}
				
				else if(!Cpf.validaCPF(novoCliente.cpf)){
					JOptionPane.showMessageDialog(null, "O CPF informado nao é valido!");
				}
				
				else if(modelo_cliente.verifyClienteExists("cpf", novoCliente.cpf) > 0){
					JOptionPane.showMessageDialog(null,"Este CPF j� est� cadastrado no sistema","Alerta",JOptionPane.INFORMATION_MESSAGE);
				}
				
				else { 
												
						modelo_cliente.addCliente(novoCliente);
						JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso");
						
				}
		}
}

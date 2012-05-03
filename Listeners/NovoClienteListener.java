package Listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Views.FormNovoCliente;



public class NovoClienteListener implements ActionListener {
	public void actionPerformed(ActionEvent arg0) {
		new FormNovoCliente();
	}
}

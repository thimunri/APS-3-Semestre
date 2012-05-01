package Listeners;

import java.awt.event.*;
import Views.FormClientes;

public class ExibeClientesListener implements ActionListener {
	public void actionPerformed( ActionEvent e ){
		new FormClientes();
	}
}

package control;

import java.util.ArrayList;
import java.util.HashMap;

import entity.Cliente;

public class GestionCliente {

	public GestionCliente(){

	}

	public void crearClientes(HashMap<Long, Cliente> listaClientes){

		Cliente cliente1 = new Cliente(1111, 123456789, "Pedro Antonio", "Ramirez Mesa", "Cr100", 3005963);
		Cliente cliente2 = new Cliente(2222, 123453457, "Luz Maria", "Jimenez Blanco", "Cr200", 3005642);
		Cliente cliente3 = new Cliente(3333, 123451363, "Joel", "Fernandez Hernandez", "Cr50", 3008514);

		listaClientes.put(Long.parseLong("" + 123456789), cliente1);
		listaClientes.put(Long.parseLong("" + 123453457), cliente2);
		listaClientes.put(Long.parseLong("" + 123451363), cliente3);
	}
}
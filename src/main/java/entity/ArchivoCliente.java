package entity;

import java.util.HashMap;

import javax.xml.bind.annotation.XmlElement;

public class ArchivoCliente {

	@XmlElement(name = "cliente")
	private HashMap<Long, Cliente> clientes;
	
	public ArchivoCliente (HashMap<Long, Cliente> clientes) {
		this.clientes = clientes;
	}
	public ArchivoCliente() {
		
	}
	
	public HashMap<Long, Cliente> getClientes(){
		return clientes;
	}
}

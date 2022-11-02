package entity;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

public class ArchivoCompra {

	@XmlElement(name = "compra")
	private ArrayList<Compra> compras;
	
	public ArchivoCompra (ArrayList<Compra> compras) {
		this.compras = compras;
	}
	public ArchivoCompra() {
		
	}
	
	public ArrayList<Compra> getCompras(){
		return compras;
	}
}

package entity;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

public class ArchivoEscultura {

	@XmlElement(name = "escultura")
	private ArrayList<Escultura> esculturas;
	
	public ArchivoEscultura (ArrayList<Escultura> esculturas) {
		this.esculturas = esculturas;
	}
	public ArchivoEscultura() {
		
	}
	
	public ArrayList<Escultura> getEsculturas(){
		return esculturas;
	}
}

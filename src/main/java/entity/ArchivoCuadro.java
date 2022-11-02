package entity;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

public class ArchivoCuadro {
	
	@XmlElement(name = "cuadro")
	private ArrayList<Cuadro> cuadros;
	
	public ArchivoCuadro (ArrayList<Cuadro> cuadros) {
		this.cuadros = cuadros;
	}
	public ArchivoCuadro() {
		
	}
	
	public ArrayList<Cuadro> getCuadros(){
		return cuadros;
	}
}

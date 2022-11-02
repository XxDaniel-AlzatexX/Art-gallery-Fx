package entity;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlElement;

public class ArchivoInstalacion {
	
	@XmlElement(name = "instalacion")
	private ArrayList<Instalacion> instalaciones;
	
	public ArchivoInstalacion (ArrayList<Instalacion> instalaciones) {
		this.instalaciones = instalaciones;
	}
	public ArchivoInstalacion() {
		
	}
	
	public ArrayList<Instalacion> getInstalaciones(){
		return instalaciones;
	}
}

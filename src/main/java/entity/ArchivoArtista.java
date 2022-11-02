package entity;

import java.util.HashMap;

import javax.xml.bind.annotation.XmlElement;

public class ArchivoArtista {
	
	@XmlElement(name = "artista")
	private HashMap<Long, Artista> artistas;
	
	public ArchivoArtista (HashMap<Long, Artista> artistas) {
		this.artistas = artistas;
	}
	public ArchivoArtista() {
		
	}
	
	public HashMap<Long, Artista> getArtistas(){
		return artistas;
	}

}

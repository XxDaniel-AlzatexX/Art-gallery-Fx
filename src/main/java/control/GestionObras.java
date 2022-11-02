package control;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

import entity.Artista;
import entity.Clasificacion;
import entity.Cuadro;
import entity.Escultura;
import entity.Instalacion;
import entity.Material;
import entity.Obra;

public class GestionObras {

	public GestionObras(){

	}

	public void crearListas(HashMap<Long, Artista> listaArtistas, ArrayList<Obra> listaObras){
		
		Obra obra1 = new Cuadro(1234567, "Ojos de fuego", new GregorianCalendar(1950, 10 -1, 4), 48000, "15 x 20", "Tema1", "Tecnica1", Clasificacion.OBRA_REPRESENTATIVA );
		Obra obra2 = new Instalacion(2345678, "El principito",  new GregorianCalendar(1925, 1 -1, 28), 70000, "20 x 24", "Descripcion1");
		Obra obra3 = new Escultura(3456789, "Escuadron",  new GregorianCalendar(1988, 5 -1, 17), 50000, "12 x 28", new Material("Material1", "Descripcion"), 50);

		Artista artista1 = new Artista(1234, 123456789, "Daniel Felipe", "Alzate Mateus",  new GregorianCalendar(1900, 12, 1), 314123545);
		Artista artista2 = new Artista(2345, 123456723, "Juan David", "Robledo Garzon",  new GregorianCalendar(1904, 5, 18), 314112235);
		Artista artista3 = new Artista(3456, 123456356, "Tania Lorena", "Granados Romero",  new GregorianCalendar(1910, 7, 4), 314134556);
		Artista artista4 = new Artista(4567, 123423457, "Martin", "Chafloque Mesia",  new GregorianCalendar(1905, 10, 4), 314124546);

		artista1.agregarObra(obra1);
		artista1.agregarObra(obra2);
		artista2.agregarObra(obra3);
		artista3.agregarObra(obra1);
		artista3.agregarObra(obra2);
		artista3.agregarObra(obra3);
		artista4.agregarObra(obra2);
		
		obra1.agregarArtista(artista1);
		obra1.agregarArtista(artista3);
		obra2.agregarArtista(artista1);
		obra2.agregarArtista(artista3);
		obra2.agregarArtista(artista4);
		obra3.agregarArtista(artista2);
		obra3.agregarArtista(artista3);
				
		listaArtistas.put(Long.parseLong("" + 123456789), artista1);
		listaArtistas.put(Long.parseLong("" + 123456723), artista2);
		listaArtistas.put(Long.parseLong("" + 123456356), artista3);
		listaArtistas.put(Long.parseLong("" + 123423457), artista4);
		
		listaObras.add(obra1);
		listaObras.add(obra2);
		listaObras.add(obra3);

	}
}
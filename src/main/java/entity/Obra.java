package entity;

import java.util.ArrayList;
import java.util.Calendar;

public abstract class Obra {

	protected long pid;
	protected String titulo;
	protected Calendar fecha;
	protected double precioRef;
	protected String dimensiones;
	protected ArrayList<Artista> artistas = new ArrayList<>();

	public Obra(long pid, String titulo, Calendar fecha, double precioRef, String dimensiones) {
		this.pid = pid;
		this.titulo = titulo;
		this.fecha = fecha;
		this.precioRef = precioRef;
		this.dimensiones = dimensiones;
	}

	public Obra() {

	}
	
	public abstract double calcularPrecio();

	@Override
	public String toString() {
		return "Obra{" + "titulo=" + titulo + ", fecha=" + fecha.getTime() + ", precioRef=" + precioRef + ", dimensiones=" + dimensiones + '}';
	}

	public long getPid() {
		return pid;
	}

	public void setPid(long pid) {
		this.pid = pid;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Calendar getFecha() {
		return fecha;
	}

	public void setFecha(Calendar fecha) {
		this.fecha = fecha;
	}

	public double getPrecioRef() {
		return precioRef;
	}

	public void setPrecioRef(double precioRef) {
		this.precioRef = precioRef;
	}

	public String getDimensiones() {
		return dimensiones;
	}

	public void setDimensiones(String dimensiones) {
		this.dimensiones = dimensiones;
	}

	public ArrayList<Artista> getArtistas() {
		return artistas;
	}

	public void agregarArtista(Artista artista){
		this.artistas.add(artista);
	}
}
package entity;

import java.util.ArrayList;
import java.util.Calendar;

public class Instalacion extends Obra {
	
	private String descripcion;
	
	private ArrayList<Material> materiales = new ArrayList<Material>();

	public Instalacion(long pid, String titulo, Calendar fecha, double precioRef, String dimensiones,
			String descripcion) {
		super(pid, titulo, fecha, precioRef, dimensiones);
		this.descripcion = descripcion;
	}
	
	public Instalacion() {
		
	}

	@Override
	public double calcularPrecio() {
		return this.precioRef + ((this.materiales.size() * 1.05));
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public ArrayList<Material> getMateriales() {
		return materiales;
	}

	public void setMateriales(ArrayList<Material> materiales) {
		this.materiales = materiales;
	}

	@Override
	public String toString() {
		return "Instalacion [descripcion=" + descripcion + ", materiales=" + materiales + ", pid=" + pid + ", titulo="
				+ titulo + ", fecha=" + fecha.getTime() + ", precioRef=" + precioRef + ", dimensiones=" + dimensiones
				+ ", artistas=" + artistas + "]";
	}
}
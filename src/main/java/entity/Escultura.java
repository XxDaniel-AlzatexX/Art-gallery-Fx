package entity;

import java.util.Calendar;

public class Escultura extends Obra {
	
	private Material material;
	
	private double peso;

	public Escultura(long pid, String titulo, Calendar fecha, double precioRef, String dimensiones, Material material,
			double peso) {
		super(pid, titulo, fecha, precioRef, dimensiones);
		this.material = material;
		this.peso = peso;
	}
	public Escultura() {
		
	}

	@Override
	public double calcularPrecio() {
		if(this.peso < 10) {
			return this.precioRef;
		}
		else {
			return this.precioRef + ((this.peso - 10) * 1.01);
		}
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "Escultura [material=" + material.getNombre() + ", peso=" + peso + ", pid=" + pid + ", titulo=" + titulo + ", fecha="
				+ fecha.getTime() + ", precioRef=" + precioRef + ", dimensiones=" + dimensiones + ", artistas=" + artistas + "]";
	}
}
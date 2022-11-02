package entity;

import java.util.Calendar;

public class Cuadro extends Obra {
	
	private String tema;
	
	private String tecnica;
	
	private Clasificacion clasificacion;

	public Cuadro(long pid, String titulo, Calendar fecha, double precioRef, String dimensiones, String tema,
			String tecnica, Clasificacion clasificacion) {
		super(pid, titulo, fecha, precioRef, dimensiones);
		this.tema = tema;
		this.tecnica = tecnica;
		this.clasificacion = clasificacion;
	}
	
	public Cuadro() {
		
	}

	@Override
	public double calcularPrecio() {
		if(this.clasificacion.equals(Clasificacion.OBRA_MAESTRA)) {
			return this.precioRef * 1.05;
		}
		else {
			return this.precioRef * 1.03;
		}
		
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public String getTecnica() {
		return tecnica;
	}

	public void setTecnica(String tecnica) {
		this.tecnica = tecnica;
	}

	public Clasificacion getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(Clasificacion clasificacion) {
		this.clasificacion = clasificacion;
	}

	@Override
	public String toString() {
		return "Cuadro [tema=" + tema + ", tecnica=" + tecnica + ", clasificacion=" + clasificacion + ", pid=" + pid
				+ ", titulo=" + titulo + ", fecha=" + fecha.getTime() + ", precioRef=" + precioRef + ", dimensiones="
				+ dimensiones + ", artistas=" + artistas + "]";
	}
}
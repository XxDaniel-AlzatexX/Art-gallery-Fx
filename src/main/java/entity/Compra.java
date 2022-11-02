package entity;

import java.util.Calendar;

public class Compra {

	private long numeroPedido;
	private Calendar fechaRecibido;
	private boolean pagado;
	private String nombreRepartidor;
	private Cliente compraCliente;
	private Obra compraObra;
	private static int CONSECUTIVO = 1000; 

	public Compra(Calendar fechaRecibido, boolean pagado, String nombreRepartidor) {
		this.numeroPedido = ++CONSECUTIVO;
		this.fechaRecibido = fechaRecibido;
		this.pagado = pagado;
		this.nombreRepartidor = nombreRepartidor;
	}

	public Compra(Calendar fechaRecibido, boolean pagado, String nombreRepartidor, Cliente compraCliente, Obra compraObra) {
		this.numeroPedido = ++CONSECUTIVO;
		this.fechaRecibido = fechaRecibido;
		this.pagado = pagado;
		this.nombreRepartidor = nombreRepartidor;
		this.compraCliente = compraCliente;
		this.compraObra = compraObra;
	}

	public boolean vincularPagoACompra(){
		return false;
	}

	public long getNumeroPedido() {
		return numeroPedido;
	}

	public void setNumeroPedido(long numeroPedido) {
		this.numeroPedido = numeroPedido;
	}

	public Calendar getFechaRecibido() {
		return fechaRecibido;
	}

	public void setFechaRecibido(Calendar fechaRecibido) {
		this.fechaRecibido = fechaRecibido;
	}

	public boolean isPagado() {
		return pagado;
	}

	public void setPagado(boolean pagado) {
		this.pagado = pagado;
	}

	public String getNombreRepartidor() {
		return nombreRepartidor;
	}

	public void setNombreRepartidor(String nombreRepartidor) {
		this.nombreRepartidor = nombreRepartidor;
	}

	public Cliente getCompraCliente() {
		return compraCliente;
	}

	public void setCompraCliente(Cliente compraCliente) {
		this.compraCliente = compraCliente;
	}

	public Obra getCompraObra() {
		return compraObra;
	}

	public void setCompraObra(Obra compraObra) {
		this.compraObra = compraObra;
	}

	@Override
	public String toString() {
		return "Compra [fechaRecibido=" + fechaRecibido.getTime()  + ", compraCliente=" + compraCliente + ", compraObra="
				+ compraObra + "]";
	}
}
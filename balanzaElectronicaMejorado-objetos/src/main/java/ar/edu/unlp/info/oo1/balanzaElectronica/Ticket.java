package ar.edu.unlp.info.oo1.balanzaElectronica;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Ticket {
	private LocalDate fecha;
	private int cantidadDeProductos;
	private double pesoTotal;
	private double precioTotal;
	private List<Producto> productos;
	
	public Ticket (int cantidadDeProductos, double pesoTotal, double precioTotal, List<Producto> productos) {
		this.fecha = LocalDate.now();
		this.cantidadDeProductos = cantidadDeProductos;
		this.pesoTotal = pesoTotal;
		this.precioTotal = precioTotal;
		this.productos = productos;
	}
	
	public LocalDate getFecha() {
		return this.fecha;
	}

	public int getCantidadDeProductos() {
		return this.cantidadDeProductos;
	}

	public double getPesoTotal() {
		return this.pesoTotal;
	}

	public double getPrecioTotal() {
		return this.precioTotal;
	}

	public double impuesto() {
		return this.precioTotal * 0.21;
	}
	
	public List<Producto> getProductos(){
		return new ArrayList<Producto>(productos);
	}

}

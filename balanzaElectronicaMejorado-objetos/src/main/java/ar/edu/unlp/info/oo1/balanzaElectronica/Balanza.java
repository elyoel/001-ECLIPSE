package ar.edu.unlp.info.oo1.balanzaElectronica;
import java.util.List;
import java.util.ArrayList;


public class Balanza {
	private int cantidadDeProductos;
	private double precioTotal;
	private double pesoTotal;
	private List<Producto> productos; 
	
	public Balanza () {
		cantidadDeProductos = 0;
		precioTotal = 0.0;
		pesoTotal = 0.0;
		productos = new ArrayList<>();
	}
	
	public int getCantidadDeProductos() {
		return cantidadDeProductos;
	}

	public double getPrecioTotal() {
		return precioTotal;
	}

	public double getPesoTotal() {
		return pesoTotal;
	}

	public void ponerEnCero() {
		pesoTotal = 0.0;
		precioTotal = 0.0;
		cantidadDeProductos = 0;
		productos.clear();
	}
	
	public void agregarProducto (Producto producto) {
		cantidadDeProductos++;
		precioTotal += producto.getPrecio();
		pesoTotal += producto.getPeso();
		productos.add(producto);
	}
	
	public List<Producto> getProductos(){
		return new ArrayList<Producto>(productos);
	}

	
	public Ticket emitirTicket () {
		Ticket ticket = new Ticket(
				cantidadDeProductos,
				pesoTotal,
				precioTotal,
				getProductos()
				);
		
		return ticket;
	}
}


package ar.edu.unlp.info.oo1.Presupuesto;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Presupuesto {
	private LocalDate fecha;
	private String cliente;
	private List<Item> items;
	
	public Presupuesto(String cliente) {
		this.fecha = LocalDate.now();
		this.cliente = cliente;
		this.items = new ArrayList<>();
	}
	
	public void agregarItem(Item item) {
		items.add(item);
	}
	
	public double calcularTotal() {
		double total = 0;
		for (Item i: items) {
			total += i.costo();
		}
		return total;
	}
	
	public LocalDate getFecha() {
		return fecha;
	}
	
	public String getCliente() {
		return cliente;
	}
	
}

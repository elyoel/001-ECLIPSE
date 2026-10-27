package io.github.unlp_oo.clienteDeCorreo;

import java.util.ArrayList;
import java.util.List;

public class ClienteDeCorreo {

	private Carpeta imbox;
	private List<Carpeta> carpetas;

	public ClienteDeCorreo() {
		imbox = new Carpeta("imbox");
		carpetas = new ArrayList<>();
		carpetas.add(imbox);
	}
	
	public void recibir(Email email) {
		imbox.agregarMail(email);
	}
	
	public Email buscarTexto(String texto) {
		return carpetas.stream()
			.map(c -> c.buscar(texto))
			.filter(m -> m != null)
			.findFirst()
			.orElse(null);
	}
	
	public int espacioOcupado() {
		return carpetas.stream()
			.mapToInt(c -> c.tamaño())
			.sum();
	}
	
	public void agregarCarpeta(Carpeta carpeta) {
		this.carpetas.add(carpeta);
	}
}

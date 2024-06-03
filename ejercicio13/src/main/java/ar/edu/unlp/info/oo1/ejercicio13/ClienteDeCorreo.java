package ar.edu.unlp.info.oo1.ejercicio13;

import java.util.ArrayList;
import java.util.List;

public class ClienteDeCorreo {
	private Carpeta inbox;
	private List<Carpeta> carpetas;
	
	public ClienteDeCorreo(Carpeta inbox) {
		this.inbox=inbox;
		this.carpetas = new ArrayList<Carpeta>();
	}
	
	public void recibirMail(Email email){
		this.inbox.recibirMail(email);
	}
	
	public void mover(Email email , Carpeta origen , Carpeta destino) {
		origen.eliminarMail(email);
		destino.recibirMail(email);
	}
	
	public Email buscar(String texto) {
		if (this.inbox.buscar(texto) != null) {
			return this.inbox.buscar(texto);
		}
		else {
			return this.carpetas.stream().map(Carpeta -> Carpeta.buscar(texto))
			.filter(Email -> Email != null).findFirst().orElse(null);
		}
	}
	
	public int espacioOcupado() {
		return (int) (this.inbox.espacioOcupado() + 
				this.carpetas.stream().mapToDouble(carpetas -> carpetas.espacioOcupado()).sum());
	}
}

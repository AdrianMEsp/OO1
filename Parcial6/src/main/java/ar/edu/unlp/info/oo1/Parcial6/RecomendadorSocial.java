package ar.edu.unlp.info.oo1.Parcial6;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RecomendadorSocial implements Recomendador{

	public List<Publicacion> obtenerPublicaciones(Usuario user){
		return user.getSeguidos().stream().flatMap(seguido -> seguido.getPublicaciones().stream())
				.sorted(Comparator.comparing(Publicacion::getFecha).reversed())
				.collect(Collectors.toList());
	}
	
}
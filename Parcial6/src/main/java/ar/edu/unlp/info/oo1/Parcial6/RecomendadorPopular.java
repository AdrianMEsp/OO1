package ar.edu.unlp.info.oo1.Parcial6;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RecomendadorPopular implements Recomendador{

	public List<Publicacion> obtenerPublicaciones(Usuario user){
		return user.getDebate().obtenerTodasLasPublicaciones().stream()
				.sorted(Comparator.comparing(Publicacion::getLike).reversed())
				.collect(Collectors.toList());
	}
	
}

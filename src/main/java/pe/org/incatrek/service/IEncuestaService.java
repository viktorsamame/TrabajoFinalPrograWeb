package pe.org.incatrek.service;

import java.util.List;
import java.util.Optional;
import pe.org.incatrek.model.Encuesta;

public interface IEncuestaService {
	public boolean insertar(Encuesta encuesta);
	public boolean modificar(Encuesta encuesta);
	public void eliminar(int idEncuesta);
	List<Encuesta> listar();	
	public Optional<Encuesta> listarId(int idEncuesta);
	List<Encuesta> buscarPorId(int idEncuesta);
	public List<Encuesta> buscarTurista(String nombreTurista);
}

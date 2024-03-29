package pe.org.incatrek.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import pe.org.incatrek.model.Paquete;

public interface IPaqueteService {
	public boolean insertar(Paquete paquete);
	public boolean modificar(Paquete paquete);
	public void eliminar(int idPaquete);
	List<Paquete> listar();
	List<Paquete> buscarPorNombre(String nombrePaquete);
	List<Paquete> buscarPorFecha(Date fechaPaquete);
	public Optional<Paquete> listarId(int idPaquete);
}

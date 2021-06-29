package pe.org.incatrek.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.org.incatrek.model.Encuesta;
import pe.org.incatrek.repository.IEncuestaRepository;
import pe.org.incatrek.service.IEncuestaService;

@Service
public class EncuestaServiceImpl implements IEncuestaService {

	@Autowired
	private IEncuestaRepository eR;
	
	@Override
	@Transactional
	public boolean insertar(Encuesta encuesta) {
		Encuesta objEncuesta= eR.save(encuesta);
		if	(objEncuesta !=null)
			return true;
		else
			return false;
	}
	

	@Override
	@Transactional
	public boolean modificar(Encuesta encuesta) {
		return true;
	}

	@Override
	@Transactional
	public void eliminar(int idEncuesta) {
		eR.deleteById(idEncuesta);
		
	}

	@Override
	@Transactional(readOnly = true)
	public List<Encuesta> listar() {
		return eR.findAll();
	}

	@Override
	@Transactional
	public List<Encuesta> buscarTurista(String nombreTurista) {
		return eR.buscarTurista(nombreTurista);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Encuesta> listarId(int idEncuesta) {
		return eR.findById(idEncuesta);
	}
	
	@Transactional
	@Override
	public List<Encuesta> buscarPorId(int idEncuesta) {
		return eR.buscarPorId(idEncuesta);
	}

}

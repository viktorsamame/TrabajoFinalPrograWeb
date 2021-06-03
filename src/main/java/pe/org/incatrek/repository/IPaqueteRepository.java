package pe.org.incatrek.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.org.incatrek.model.Paquete;

@Repository
public interface IPaqueteRepository extends JpaRepository<Paquete, Integer>{	
	@Query("from Paquete p where p.nombrePaquete like %:nombrePaquete%")
	List<Paquete> buscarPorNombre(@Param("nombrePaquete") String nombrePaquete);
	
	@Query("from Paquete p where p.fechaPaquete like %:fechaPaquete%")
	List<Paquete> buscarPorFecha(@Param("fechaPaquete") Date fechaPaquete);
}

package pe.org.incatrek.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.org.incatrek.model.Guia;

@Repository
public interface IGuiaRepository extends JpaRepository<Guia, Integer>{	
	@Query("from Guia g where g.nombreGuia like %:nombreGuia%")
	List<Guia> buscarPorNombre(@Param("nombreGuia") String nombreGuia);
	
	@Query("from Guia g where g.dniGuia like %:dniGuia%")
	List<Guia> buscarPorDNI(@Param("dniGuia") String dniGuia);
}

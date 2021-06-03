package pe.org.incatrek.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.org.incatrek.model.Proveedor;

@Repository
public interface IProveedorRepository extends JpaRepository<Proveedor, Integer>{	
	@Query("from Proveedor p where p.nombreProveedor like %:nombreProveedor%")
	List<Proveedor> buscarPorNombre(@Param("nombreProveedor") String nombreProveedor);
	
	@Query("from Proveedor p where p.rucProveedor like %:rucProveedor%")
	List<Proveedor> buscarPorRUC(@Param("rucProveedor") String rucProveedor);
}

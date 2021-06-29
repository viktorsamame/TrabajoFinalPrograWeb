package pe.org.incatrek.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Encuesta")
public class Encuesta implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEncuesta;
	
	private String nombreEncuesta;
	
	@OneToOne
	@JoinColumn(name="idTurista", nullable=false)
	private Turista turista;
	
	private int satisfaccion;
	
	private String comentario;
	
	public Encuesta() {
		super();
	}

	public Encuesta(int idEncuesta, Turista turista, int satisfaccion, String nombreEncuesta, String comentario) {
		super();
		this.idEncuesta = idEncuesta;
		this.turista = turista;
		this.satisfaccion = satisfaccion;
		this.nombreEncuesta = nombreEncuesta;
		this.comentario=comentario;
	}

	public int getIdEncuesta() {
		return idEncuesta;
	}

	public void setIdEncuesta(int idEncuesta) {
		this.idEncuesta = idEncuesta;
	}

	public Turista getTurista() {
		return turista;
	}

	public void setTurista(Turista turista) {
		this.turista = turista;
	}

	public int getSatisfaccion() {
		return satisfaccion;
	}

	public void setSatisfaccion(int satisfaccion) {
		this.satisfaccion = satisfaccion;
	}

	public String getNombreEncuesta() {
		return nombreEncuesta;
	}

	public void setNombreEncuesta(String nombreEncuesta) {
		this.nombreEncuesta = nombreEncuesta;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
}

	
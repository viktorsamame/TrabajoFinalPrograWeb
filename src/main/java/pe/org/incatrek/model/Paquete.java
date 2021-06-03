package pe.org.incatrek.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Paquete")
public class Paquete implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPaquete;
	
	@Column(name = "nombrePaquete", nullable = false, length = 30)
	private String nombrePaquete;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat (pattern="yyyy-MM-dd")
	private Date fechaPaquete;
	
	@Column(name = "precioPaquete", nullable = false, length = 5)
	private float precioPaquete;
	
	@Column(name = "numCupos", nullable = false, length = 2)
	private int numCupos;
	
	@Column(name = "lugarOrigen", nullable = false, length = 20)
	private String lugarOrigen;
	
	@Column(name = "lugarDestino", nullable = false, length = 20)
	private String lugarDestino;

	public Paquete() {
		super();
	}

	public Paquete(int idPaquete, String nombrePaquete, Date fechaPaquete, float precioPaquete, int numCupos,
			String lugarOrigen, String lugarDestino) {
		super();
		this.idPaquete = idPaquete;
		this.nombrePaquete = nombrePaquete;
		this.fechaPaquete = fechaPaquete;
		this.precioPaquete = precioPaquete;
		this.numCupos = numCupos;
		this.lugarOrigen = lugarOrigen;
		this.lugarDestino = lugarDestino;
	}

	public int getIdPaquete() {
		return idPaquete;
	}

	public void setIdPaquete(int idPaquete) {
		this.idPaquete = idPaquete;
	}

	public String getNombrePaquete() {
		return nombrePaquete;
	}

	public void setNombrePaquete(String nombrePaquete) {
		this.nombrePaquete = nombrePaquete;
	}

	public Date getFechaPaquete() {
		return fechaPaquete;
	}

	public void setFechaPaquete(Date fechaPaquete) {
		this.fechaPaquete = fechaPaquete;
	}

	public float getPrecioPaquete() {
		return precioPaquete;
	}

	public void setPrecioPaquete(float precioPaquete) {
		this.precioPaquete = precioPaquete;
	}

	public int getNumCupos() {
		return numCupos;
	}

	public void setNumCupos(int numCupos) {
		this.numCupos = numCupos;
	}

	public String getLugarOrigen() {
		return lugarOrigen;
	}

	public void setLugarOrigen(String lugarOrigen) {
		this.lugarOrigen = lugarOrigen;
	}

	public String getLugarDestino() {
		return lugarDestino;
	}

	public void setLugarDestino(String lugarDestino) {
		this.lugarDestino = lugarDestino;
	}

}

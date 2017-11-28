package net.itinajero.app.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Banners")
public class Banner {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	private String titulo;
	private Date fecha;
	private String archivo;
	private String estatus;
	

	public Banner(){		
		this.fecha = new Date();
		this.estatus="Activo";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getArchivo() {
		return archivo;
	}

	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}

	public String getEstatus() {
		return estatus;
	}

	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	@Override
	public String toString() {
		return "Banner [id=" + id + ", titulo=" + titulo + ", fecha=" + fecha + ", archivo=" + archivo + ", estatus="
				+ estatus + "]";
	}	
		
}

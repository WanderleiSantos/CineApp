package net.itinajero.app.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Horarios")
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private Date fecha;
	private String hora;
	private String sala;
	private double precio;

    @ManyToOne
    @JoinColumn(name = "idPelicula")
	private Pelicula pelicula;

	public Horario() { }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}

	@Override
	public String toString() {
		return "Horario{" +
				"id=" + id +
				", hora='" + hora + '\'' +
				", sala='" + sala + '\'' +
				", precio=" + precio +
				", pelicula=" + pelicula +
				'}';
	}
}

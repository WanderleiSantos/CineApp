package net.itinajero.app.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Peliculas")
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String titulo;
    private int duracion;
    private String clasificacion;
    private String genero;

    @Column(name = "imagen")
    private String imagem = "cinema.png";

    private Date fechaEstreno;
    private String estatus="Activa";

    @OneToOne
    @JoinColumn(name = "idDetalle")
    private Detalhe detalhe;

    @OneToMany(mappedBy = "pelicula", fetch = FetchType.EAGER)
    private List<Horario> horarios;

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

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Date getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(Date fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public Detalhe getDetalhe() {
        return detalhe;
    }

    public void setDetalhe(Detalhe detalhe) {
        this.detalhe = detalhe;
    }

    public List<Horario> getHorarios() {
        return horarios;
    }

    public void setHorarios(List<Horario> horarios) {
        this.horarios = horarios;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", duracion=" + duracion +
                ", clasificacion='" + clasificacion + '\'' +
                ", genero='" + genero + '\'' +
                ", imagem='" + imagem + '\'' +
                ", fechaEstreno=" + fechaEstreno +
                ", estatus='" + estatus + '\'' +
                ", detalhe=" + detalhe +
                ", horarios=" + horarios +
                '}';
    }
}

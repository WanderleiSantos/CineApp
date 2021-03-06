package net.itinajero.app.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Noticias")
public class Noticia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String titulo;

    private Date fecha;

    @Column(name = "detalle")
    private String detalhe;

    @Column(name = "estatus")
    private String status;

    public Noticia() {
        this.fecha = new Date();
        this.status = "Activa";
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

    public String getDetalhe() {
        return detalhe;
    }

    public void setDetalhe(String detalhe) {
        this.detalhe = detalhe;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Noticia{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", fecha=" + fecha +
                ", detalhe='" + detalhe + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

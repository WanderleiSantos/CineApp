package net.itinajero.app.model;


import java.util.Arrays;
import java.util.List;

public class Contato {

    private int id;
    private String nome;
    private String email;
    private int rating;
    private String[] generos;
    private List<String> notificaciones;
    private String comentarios;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String[] getGeneros() {
        return generos;
    }

    public void setGeneros(String[] generos) {
        this.generos = generos;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public void setNotificaciones(List<String> notificaciones) {
        this.notificaciones = notificaciones;
    }

    public List<String> getNotificaciones() {
        return notificaciones;
    }

    @Override
    public String toString() {
        return "Contato{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", rating=" + rating +
                ", generos=" + Arrays.toString(generos) +
                ", notificaciones=" + notificaciones +
                ", comentarios='" + comentarios + '\'' +
                '}';
    }
}

package uni.innovadores.uniservicesonline.models;

/**
 * Created by javier on 02-03-17.
 */


public class Notify {
    private String titulo, fecha, imagen, texto, hora;

    public Notify() {
    }

    public Notify(String titulo, String fecha, String hora, String imagen, String texto) {
        this.titulo = titulo;
        this.fecha = fecha;
        this.hora = hora;
        this.imagen = imagen;
        this.texto = texto;

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {

        this.titulo = titulo;
    }

    public String getFecha() {

        return fecha;
    }

    public void setFecha(String fecha) {

        this.fecha = fecha;
    }

    public String getHora() {

        return hora;
    }

    public void setHora(String hora) {

        this.hora = hora;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {

        this.imagen = imagen;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {

        this.texto = texto;
    }

}
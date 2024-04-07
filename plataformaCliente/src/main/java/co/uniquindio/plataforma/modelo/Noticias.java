package co.uniquindio.plataforma.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
public class Noticias {

    private String titulo;
    private String contenido;
    private String autor;
    private LocalDate fecha;
    @Override
    public String toString() {
        return "Noticia{" +
                ", titulo='" + titulo + '\'' +
                ", autor=" + autor +
                ", fecha='" + fecha + '\'' +
                ", contenido='" + contenido + '\'' +
                '}';
    }

}

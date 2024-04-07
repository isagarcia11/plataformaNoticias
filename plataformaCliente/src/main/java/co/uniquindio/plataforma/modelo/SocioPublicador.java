package co.uniquindio.plataforma.modelo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SocioPublicador {
    private String nombre;
    private String identificacion;
    private ArrayList<String> noticias;
}

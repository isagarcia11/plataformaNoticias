package co.uniquindio.plataforma.modelo;

import co.uniquindio.plataforma.app.PlataformaApp1;
import co.uniquindio.plataforma.excepciones.AtributoVacioException;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Objects;

public class PlataformaCliente {
    private static final String HOST = "localhost";
    private static final int PUERTO = 1000;

    private static PlataformaCliente plataformaCliente;
    public static PlataformaCliente getInstance() {
        if(plataformaCliente == null){
            plataformaCliente= new PlataformaCliente();
        }

        return plataformaCliente;
    }
    public void loadStage(String url, Event event){

        try {
            ((Node)(event.getSource())).getScene().getWindow().hide();

            Parent root = FXMLLoader.load(Objects.requireNonNull(PlataformaApp1.class.getResource(url)));
            Scene scene = new Scene(root);
            Stage newStage = new Stage();
            newStage.setScene(scene);
            newStage.setTitle("Plataforma de Noticias");
            newStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

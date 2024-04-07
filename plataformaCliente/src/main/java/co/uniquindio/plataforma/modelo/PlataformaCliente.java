package co.uniquindio.plataforma.modelo;

import co.uniquindio.plataforma.app.PlataformaApp1;
import co.uniquindio.plataforma.excepciones.AtributoVacioException;
import co.uniquindio.plataforma.socket.Mensaje;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.extern.java.Log;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Objects;

public class PlataformaCliente {
    private static final String HOST = "localhost";
    private static final int PUERTO = 1000;

    private static PlataformaCliente plataformaCliente;

    public static PlataformaCliente getInstance() {
        if (plataformaCliente == null) {
            plataformaCliente = new PlataformaCliente();
        }

        return plataformaCliente;
    }

    public void loadStage(String url, Event event) {

        try {
            ((Node) (event.getSource())).getScene().getWindow().hide();

            Parent root = FXMLLoader.load(Objects.requireNonNull(PlataformaApp1.class.getResource(url)));
            Scene scene = new Scene(root);
            Stage newStage = new Stage();
            newStage.setScene(scene);
            newStage.setTitle("Plataforma de Noticias");
            newStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }git
    }

    public ArrayList<Noticias> listarNoticias() throws RuntimeException {

        //Se intenta abrir una conexión a un servidor remoto usando un objeto Socket
        try (Socket socket = new Socket(HOST, PUERTO)) {

            //Se crean flujos de datos de entrada y salida para comunicarse a través del socket
            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());

            //Se envía un mensaje al servidor con los datos de la petición
            out.writeObject(Mensaje.builder()
                    .tipo("listarClientes").build());

            //Obtenemos la respuesta del servidor
            Object respuesta = in.readObject();

            //Se hace un casting de la respuesta Object a un ArrayList<Cliente>
            ArrayList<Noticias> list = (ArrayList<Noticias>) respuesta;

            //Se cierran los flujos de entrada y de salida para liberar los recursos
            in.close();
            out.close();

            //Se retorna a lista de clientes
            return list;
        } catch (Exception e) {
            e.printStackTrace();


        }

        return null;
    }
}

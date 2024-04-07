package co.uniquindio.plataforma.controladores;

import co.uniquindio.plataforma.modelo.PlataformaCliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class inicioSocioPublicadorControlador {
    @FXML
    private ComboBox comboIdiomas;
    @FXML
    private Button btnCargar;
    @FXML
    private TextArea textArea;

    private Stage stage;

    private final PlataformaCliente plataformaCliente = new PlataformaCliente();
    @FXML
    public void initialize() {
        // Asignar un evento al botón
        btnCargar.setOnAction(event -> cargarContenido());
    }

    @FXML
    private void cargarContenido() {
        // Crear un FileChooser
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleccionar archivo");

        // Mostrar el diálogo para seleccionar un archivo
        File selectedFile = fileChooser.showOpenDialog(stage);

        // Si un archivo es seleccionado, hacer algo con él
        if (selectedFile != null) {
            try {
                // Leer el contenido del archivo
                String content = new String(Files.readAllBytes(selectedFile.toPath()));
                // Mostrar el contenido en el TextArea
                textArea.setText(content);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("Ningún archivo seleccionado.");
        }
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}

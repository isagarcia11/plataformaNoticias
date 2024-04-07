package co.uniquindio.plataforma.controladores;

import co.uniquindio.plataforma.modelo.PlataformaCliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import lombok.Getter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class inicioSocioPublicadorControlador {
    @FXML
    private ComboBox comboIdiomas;
    @FXML
    private Button btnCargar,btnAnadido;
    @FXML
    private TextArea textArea;

    private Stage stage;

    @Getter
    private List<String> fileData = new ArrayList<>();

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
                List<String> lines = Files.readAllLines(selectedFile.toPath());
                fileData.addAll(lines);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("Ningún archivo seleccionado.");
        }
    }


    public void irAnadido(ActionEvent event){
        textArea.setText(fileData.get(0));
        }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}


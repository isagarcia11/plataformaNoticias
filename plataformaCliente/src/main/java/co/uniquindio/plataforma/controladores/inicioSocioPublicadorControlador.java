package co.uniquindio.plataforma.controladores;

import co.uniquindio.plataforma.modelo.Noticias;
import co.uniquindio.plataforma.modelo.PlataformaCliente;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import lombok.Getter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class inicioSocioPublicadorControlador {

    private TableView<Noticias> noticiasTableView;
    private TableColumn<Noticias, String> titulo;
    private TableColumn<Noticias, String> autor;
    private TableColumn<Noticias, String> contenido;
    private TableColumn<Noticias, String> fecha;
    private TextArea textArea;

    @FXML
    private Button btnAtras;
    @FXML
    private Button btnCargar,btnAnadido,btnXML;

    @FXML
    private TextField txtArea;
    private Stage stage;



    @Getter
    private List<String> noticiasCargadas = new ArrayList<>();

    private final PlataformaCliente plataformaCliente = new PlataformaCliente();
    @FXML
    public void initialize() {
        // Asignar un evento al botón
        btnCargar.setOnAction(event -> cargarContenido());
        titulo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTitulo()));
        autor.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAutor()));
        contenido.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getContenido()));
        fecha.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFecha().toString()));

        noticiasTableView.setItems(FXCollections.observableArrayList(plataformaCliente.listarNoticias()));

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
            //                List<String> lines = Files.readAllLines(selectedFile.toPath());
//                fileData.addAll(lines);
            Noticias noticia = leerNoticiaDesdeXML(selectedFile.getPath());
            noticiasCargadas.add(String.valueOf(noticia));
        }else {
            System.out.println("Ningún archivo seleccionado.");
        }
    }
    public static Noticias leerNoticiaDesdeXML(String rutaArchivo) {
        try {
            File archivoXML = new File(rutaArchivo);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(archivoXML);

            doc.getDocumentElement().normalize();

            NodeList nodoNoticias = doc.getElementsByTagName("noticia");

            if (nodoNoticias.getLength() > 0) {
                Element elementoNoticia = (Element) nodoNoticias.item(0);

                String titulo = elementoNoticia.getElementsByTagName("titulo").item(0).getTextContent();
                String contenido = elementoNoticia.getElementsByTagName("contenido").item(0).getTextContent();
                String autor = elementoNoticia.getElementsByTagName("autor").item(0).getTextContent();
                LocalDate fecha = LocalDate.parse(elementoNoticia.getElementsByTagName("fecha").item(0).getTextContent());

                return new Noticias(titulo, contenido, autor, fecha);
            }
        } catch (ParserConfigurationException | IOException | org.xml.sax.SAXException e) {
            e.printStackTrace();
        }

        return null;
    }


    public void irAnadido(ActionEvent event){

}


    public void atras(ActionEvent event) {
        Object evt = event.getSource();
        if (evt.equals(btnAtras)) {
            plataformaCliente.loadStage("/ventanas/login.fxml", event);
        }
    }

    public void setStage(Stage stage) {
        this.stage =stage;
}
}
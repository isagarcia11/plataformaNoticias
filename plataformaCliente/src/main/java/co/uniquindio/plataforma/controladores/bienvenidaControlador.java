package co.uniquindio.plataforma.controladores;

import co.uniquindio.plataforma.modelo.PlataformaCliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class bienvenidaControlador {
    @FXML
    private Button btnEnvio,btnProcesamiento,btnSocio,btnAdmin;
    private final PlataformaCliente plataformaCliente = new PlataformaCliente();
    public void irEnvio(ActionEvent event) {
        Object evt = event.getSource();
        if (evt.equals(btnEnvio)) {
            plataformaCliente.loadStage("/ventanas/login2.fxml", event);
        }
    }
    public void irAdmin(ActionEvent event) {
        Object evt = event.getSource();
        if (evt.equals(btnAdmin)) {
            plataformaCliente.loadStage("/ventanas/login.fxml", event);
        }
    }
        public void irProcesamiento(ActionEvent event) {
            Object evt = event.getSource();
            if (evt.equals(btnProcesamiento)) {
                plataformaCliente.loadStage("/ventanas/login3.fxml", event);
            }
        }
    public void irSocio(ActionEvent event) {
        Object evt = event.getSource();
        if (evt.equals(btnSocio)) {
            plataformaCliente.loadStage("/ventanas/login4.fxml", event);
        }
    }
    }




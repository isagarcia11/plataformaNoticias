package co.uniquindio.plataforma.socket;

import co.uniquindio.plataforma.app.PlataformaServidor;

import java.net.Socket;

public class HiloCliente implements Runnable {
    private final Socket socket;
    private final PlataformaServidor plataforma;


    public HiloCliente(Socket socket, PlataformaServidor plataforma) {
        this.socket = socket;
        this.plataforma = plataforma;
    }

    @Override
    public void run() {

    }
}
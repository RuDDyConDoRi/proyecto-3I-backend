package com.ctr.iii.servicio.web.dto;

public class ErrorDatoDTO {

    private String campo;

    private String descripcionMensaje;

    public ErrorDatoDTO(String campo, String descripcionMensaje) {
        this.campo = campo;
        this.descripcionMensaje = descripcionMensaje;
    }

    public String getCampo() {
        return campo;
    }

    public String getDescripcionMensaje() {
        return descripcionMensaje;
    }
}

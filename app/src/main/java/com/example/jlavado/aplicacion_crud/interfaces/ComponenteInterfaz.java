package com.example.jlavado.aplicacion_crud.interfaces;

/**
 * Created by dmorales on 26/02/2018.
 */

public interface ComponenteInterfaz {
    public void inhabilitar();
    public void habilitar();
    public void guardarDatos();
    public boolean validarDatos();
    public boolean estaHabilitado();
    public String getIdTabla();
    public void cargarDatos();
    public void llenarVista();
}

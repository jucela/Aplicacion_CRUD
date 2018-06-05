package com.example.jlavado.aplicacion_crud.pojos;

/**
 * Created by jlavado on 5/06/2018.
 */

public class ItemUsuario {
     private String id;
     private String nombre;
     private String apellido;
     private String user;
     private String password;

    public ItemUsuario(String id, String nombre, String apellido, String user, String password) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.user = user;
        this.password = password;
    }

    public ItemUsuario() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

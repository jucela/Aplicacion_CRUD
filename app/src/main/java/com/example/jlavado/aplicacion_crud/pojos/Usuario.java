package com.example.jlavado.aplicacion_crud.pojos;

import android.content.ContentValues;

import com.example.jlavado.aplicacion_crud.modelo.SQLConstantes;

/**
 * Created by jlavado on 29/05/2018.
 */

public class Usuario {
    private  String id;
    private  String user;
    private  String password;
    private  String nombre;
    private  String apellido;

    public Usuario() {
        this.id ="";
        this.user ="";
        this.password ="";
        this.nombre ="";
        this.apellido ="";

    }


    public Usuario(String id, String user, String password, String nombre, String apellido) {
        this.id = id;
        this.user = user;
        this.password = password;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public ContentValues toValues(){
        ContentValues contentValues = new ContentValues(5);
        contentValues.put(SQLConstantes.id,id);
        contentValues.put(SQLConstantes.user,user);
        contentValues.put(SQLConstantes.password,password);
        contentValues.put(SQLConstantes.nombre,nombre);
        contentValues.put(SQLConstantes.apellido,apellido);
        return contentValues;
    }
}

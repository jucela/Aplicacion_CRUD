package com.example.jlavado.aplicacion_crud.modelo;

/**
 * Created by jlavado on 29/05/2018.
 */

public class SQLConstantes {

    public static final String DB="prueba.db";
    public static final String tbusuario="tbusuario";

    public static final String id="id";
    public static final String user="user";
    public static final String password="password";
    public static final String nombre="nombre";
    public static final String apellido="apellido";


    public static final String SQL_CREAR_TBUSUARIOS =
            "CREATE TABLE "+tbusuario+"("+
                    id+" TEXT PRIMARY KEY, "+
                    user+" TEXT, "+
                    password+" TEXT, "+
                    nombre+" TEXT, "+
                    apellido+" TEXT"+");"

            ;
     public static  final String SQL_ELIMINAR_TBUSUARIOS="DROP TABLE"+ tbusuario;

     public static  final String SQL_WHERE_ID="id=?";


     public static  final String[] COLUMNAS_USUARIOS={
             id,user,password,nombre,apellido
     };


}

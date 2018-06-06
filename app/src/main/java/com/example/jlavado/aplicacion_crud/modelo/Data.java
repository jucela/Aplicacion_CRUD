package com.example.jlavado.aplicacion_crud.modelo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.jlavado.aplicacion_crud.pojos.Usuario;

import java.util.ArrayList;

/**
 * Created by jlavado on 29/05/2018.
 */

public class Data {
    Context contexto;
    SQLiteOpenHelper sqLiteOpenHelper;
    SQLiteDatabase sqLiteDatabase;

    public Data(Context contexto){
        this.contexto = contexto;
        sqLiteOpenHelper = new DBHelper(contexto);
        sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();
    }

    public void open(){
        sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();
    }
     public void close(){
        sqLiteOpenHelper.close();
     }


     //----OBTENER USUARIO
     public Usuario getUsuario(String id){
         Usuario usuario= new Usuario();
         String[] whereArgs = new String[]{id};
         Cursor cursor = null;

         try {
             cursor = sqLiteDatabase.query(SQLConstantes.tbusuario,SQLConstantes.COLUMNAS_USUARIOS,SQLConstantes.SQL_WHERE_ID,whereArgs,null,null,null);

             if(cursor.getCount() ==1){
                cursor.moveToFirst();
                usuario.setId(cursor.getString(cursor.getColumnIndex(SQLConstantes.id)));
                usuario.setNombre(cursor.getString(cursor.getColumnIndex(SQLConstantes.id)));
                usuario.setApellido(cursor.getString(cursor.getColumnIndex(SQLConstantes.id)));
                usuario.setUser(cursor.getString(cursor.getColumnIndex(SQLConstantes.id)));
                usuario.setPassword(cursor.getString(cursor.getColumnIndex(SQLConstantes.id)));
             }
         }finally {
             if(cursor != null) cursor.close();
         }
         return usuario;
     }

     //----VERIFICA SI EXISTE USUARIO
     public boolean ExisteUsuario(String id)  {
      boolean encontrado = false;
      String [] whereArgs = new String[]{id};
      Cursor cursor = null;
      try {
          cursor = sqLiteDatabase.query(SQLConstantes.tbusuario,SQLConstantes.COLUMNAS_USUARIOS,SQLConstantes.SQL_WHERE_ID,whereArgs,null,null,null);
          if(cursor.getCount()==1) encontrado= true;
          }finally {
          if (cursor != null)cursor.close();
      }
      return encontrado;
     }

     //----INSERTAR USUARIO
     public  void insertarUsuario(Usuario usuario){
        ContentValues contentValues = usuario.toValues();
        sqLiteDatabase.insert(SQLConstantes.tbusuario,null,contentValues);

    }

     //----ACTUALIZAR USUARIO
     public  void ActualizarUsuario(String id,ContentValues contentValues){
         String [] whereArgs =  new String[]{id};
         sqLiteDatabase.update(SQLConstantes.tbusuario,contentValues,SQLConstantes.SQL_WHERE_ID,whereArgs);
     }

    public ArrayList<Usuario> ObtenerUsuarios() {
        ArrayList<Usuario> datos= new ArrayList<Usuario>();
        String[] whereArgs = new String[]{};
        Cursor cursor =null;
        try {
            cursor = sqLiteDatabase.query(SQLConstantes.tbusuario, SQLConstantes.COLUMNAS_USUARIOS,null, whereArgs, null, null, null);
            while (cursor.moveToNext())
            {   Usuario usuario = new Usuario();
                usuario.setId(cursor.getString(cursor.getColumnIndex(SQLConstantes.id)));
                usuario.setUser(cursor.getString(cursor.getColumnIndex(SQLConstantes.user)));
                usuario.setPassword(cursor.getString(cursor.getColumnIndex(SQLConstantes.password)));
                usuario.setNombre(cursor.getString(cursor.getColumnIndex(SQLConstantes.nombre)));
                usuario.setApellido(cursor.getString(cursor.getColumnIndex(SQLConstantes.apellido)));
                datos.add(usuario);
            }

        }finally{
            if(cursor!=null) cursor.close();
        }

        return datos;
    }

}

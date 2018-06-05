package com.example.jlavado.aplicacion_crud.modelo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jlavado on 29/05/2018.
 */

public class DBHelper extends SQLiteOpenHelper {
    public  static final int DB_VERSION=1;
   // private Context context;
    public DBHelper(Context context){
        super(context,SQLConstantes.DB,null,DB_VERSION);
       // this.context=context;


    }

    @Override
    public  void  onCreate (SQLiteDatabase sqLiteDatabase){
        sqLiteDatabase.execSQL(SQLConstantes.SQL_CREAR_TBUSUARIOS);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int il) {
        sqLiteDatabase.execSQL(SQLConstantes.SQL_ELIMINAR_TBUSUARIOS);
        onCreate(sqLiteDatabase);
    }

}

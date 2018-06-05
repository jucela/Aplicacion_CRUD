package com.example.jlavado.aplicacion_crud;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.jlavado.aplicacion_crud.fragments.ComponenteFragment;
import com.example.jlavado.aplicacion_crud.modelo.Data;
import com.example.jlavado.aplicacion_crud.modelo.SQLConstantes;
import com.example.jlavado.aplicacion_crud.pojos.Usuario;

import java.util.ArrayList;

/**
 * Created by jlavado on 29/05/2018.
 */

public class ingreso_usuario extends AppCompatActivity {

    private Button btn_ingresar;
    private TextView LinkRegresar;
    private Data data;
    private Context context;

    private String id;
    private String nombre;
    private String apellido;
    private String user;
    private String password;

    private Usuario usuario;

    private EditText edt_id;
    private EditText edt_nombre;
    private EditText edt_apellido;
    private EditText edt_usuario;
    private EditText edt_password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ingreso_usuario);
        edt_id = (EditText) findViewById(R.id.edt_id);
        edt_nombre= (EditText) findViewById(R.id.edt_nombre);
        edt_apellido= (EditText) findViewById(R.id.edt_apellido);
        edt_usuario= (EditText) findViewById(R.id.edt_usuario);
        edt_password= (EditText) findViewById(R.id.edt_password);
        btn_ingresar=(Button) findViewById(R.id.boton_guardar);
        LinkRegresar=(TextView) findViewById(R.id.link_regresar);

        //cargarVariables();
        //CargarDatos();

         btn_ingresar.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
              cargarVariables();
              guardarDatos();
              edt_id.setText("");
              edt_nombre.setText("");
              edt_apellido.setText("");
              edt_usuario.setText("");
              edt_password.setText("");
             }
         });

         LinkRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.push_rigth_in, R.anim.push_rigth_out);

            }
        });

    }
     public void CargarDatos(){
         data = new Data(context);
         data.open();
          if(data.ExisteUsuario(id))
          {
              usuario = data.getUsuario(id);
              edt_id.setText(usuario.getId());
              edt_nombre.setText(usuario.getNombre());
              edt_apellido.setText(usuario.getApellido());
              edt_usuario.setText(usuario.getUser());
              edt_password.setText(usuario.getPassword());}

          }



     public void cargarVariables(){
        id = edt_id.getText().toString();
        nombre = edt_nombre.getText().toString();
        apellido = edt_apellido.getText().toString();
        user = edt_usuario.getText().toString();
        password = edt_password.getText().toString();
     }
     public void guardarDatos(){

        data = new Data(this);
        data.open();

            usuario = new Usuario();
            usuario.setId(id);
            usuario.setNombre(nombre);
            usuario.setApellido(apellido);
            usuario.setUser(user);
            usuario.setPassword(password);
            data.insertarUsuario(usuario);

        data.close();
     }

//    public void guardarPagina(int id) {
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        data = new Data(getApplicationContext());
//        data.open();
////        Pagina pagina = dataComponentes.getPagina(numeroPagina + "");
////        String[] ids = {pagina.getIDP1(), pagina.getIDP2(), pagina.getIDP3(), pagina.getIDP4(), pagina.getIDP5(),
////                pagina.getIDP6(), pagina.getIDP7(), pagina.getIDP8(), pagina.getIDP9(), pagina.getIDP10()};
////
//        ArrayList<Usuario> datos = data.ObtenerUsuario(id + "");
//        int indice = 0;
//        while (indice < datos.size()) {
//            ComponenteFragment componenteFragment = (ComponenteFragment) fragmentManager.findFragmentByTag(datos.get(indice).getId());
//            componenteFragment.guardarDatos();
//            indice++;
//        }
//        data.close();
//    }
}


package com.example.jlavado.aplicacion_crud;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
//import android.support.v7.app.AlertController;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.jlavado.aplicacion_crud.Adapter.UsuarioAdapter;
import com.example.jlavado.aplicacion_crud.modelo.Data;
import com.example.jlavado.aplicacion_crud.pojos.ItemUsuario;
import com.example.jlavado.aplicacion_crud.pojos.Usuario;

import java.util.ArrayList;

/**
 * Created by jlavado on 29/05/2018.
 */

public class listar_usuario extends AppCompatActivity {

    private Button btn_ingresar;
    private TextView LinkRegresar;
    private RecyclerView recyclerView;
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


     private ArrayList<Usuario> datosUsuario;
     private  ArrayList<ItemUsuario> itemUsuario;

     private UsuarioAdapter usuarioAdapter;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listar_usuario);

     LinkRegresar = (TextView) findViewById(R.id.link_regresar2);
     recyclerView = (RecyclerView) findViewById(R.id.recycler_usuario);
     listarUsuario();




     LinkRegresar.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent intent = new Intent(getApplicationContext(),MainActivity.class);
             startActivity(intent);
             finish();
             overridePendingTransition(R.anim.push_rigth_in, R.anim.push_rigth_out);

         }
     });



    }
    public void listarUsuario(){
        itemUsuario = new  ArrayList<ItemUsuario>();
         for (Usuario usuario: datosUsuario){
             itemUsuario.add(new ItemUsuario(usuario.getId(),usuario.getNombre(),usuario.getApellido(),usuario.getUser(),usuario.getPassword()));
             }

        usuarioAdapter = new UsuarioAdapter(itemUsuario, new UsuarioAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                final CardView rootView = (CardView) v;
                final TextView txtTextView1 = (TextView) rootView.findViewById(R.id.usuario_item_id);
                final TextView txtTextView2 = (TextView) rootView.findViewById(R.id.usuario_item_nombres);
                final TextView txtTextView3 = (TextView) rootView.findViewById(R.id.usuario_item_apellidos);
                final TextView txtTextView4 = (TextView) rootView.findViewById(R.id.usuario_item_usuario);
                final TextView txtTextView5 = (TextView) rootView.findViewById(R.id.usuario_item_password);
            }
        });

        recyclerView.setAdapter(usuarioAdapter);

    }

}


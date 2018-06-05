package com.example.jlavado.aplicacion_crud;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jlavado.aplicacion_crud.fragments.ComponenteFragment;
import com.example.jlavado.aplicacion_crud.modelo.Data;
import com.example.jlavado.aplicacion_crud.pojos.Usuario;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView LinkRegistrar;
    private TextView LinkListar;
    private Button btn_ingresar;
    private Data data;
    private EditText edt_user;
    private EditText edt_pass;
    private Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
         LinkRegistrar = (TextView) findViewById(R.id.link_ingresar);
         LinkListar =(TextView) findViewById(R.id.link_listar);
         btn_ingresar  = (Button) findViewById(R.id.login_boton_ingresar);
         edt_user=(EditText) findViewById(R.id.login_input_usuario);
         edt_pass=(EditText) findViewById(R.id.login_input_password);
         data=new Data(this);



        LinkRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ingreso_usuario.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);

            }
        });

        LinkListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),listar_usuario.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.push_left_in,R.anim.push_left_out);
            }
        });

        btn_ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //Usuario usuario = new Usuario();
               data.open();
               usuario=data.getUsuario(edt_user.getText().toString());
               data.close();
               if((usuario.getUser().equals(edt_user.getText().toString())) && (usuario.getPassword().equals(edt_pass.getText().toString())))

               {Toast.makeText(MainActivity.this,"Datos Correctos",Toast.LENGTH_SHORT ).show();}

               else
               {Toast.makeText(MainActivity.this,"ERROR  EN DATOS",Toast.LENGTH_SHORT).show();}
             }
        });

    }




}

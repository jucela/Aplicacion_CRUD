package com.example.jlavado.aplicacion_crud;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by jlavado on 6/06/2018.
 */


public class actualizar_usuario extends AppCompatActivity {
     private TextView LinkRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actualizar_usuario);

        LinkRegresar= (TextView) findViewById(R.id.link_act_regresar);

        LinkRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.push_left_in,R.anim.push_rigth_out);

            }
        });



    }
}

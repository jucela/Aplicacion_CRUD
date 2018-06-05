package com.example.jlavado.aplicacion_crud.Adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.example.jlavado.aplicacion_crud.R;
import com.example.jlavado.aplicacion_crud.pojos.ItemUsuario;

import java.util.ArrayList;

/**
 * Created by jlavado on 5/06/2018.
 */

public class UsuarioAdapter extends RecyclerView.Adapter<UsuarioAdapter.ViewHolder> {
    ArrayList<ItemUsuario> usuarios;
    OnItemClickListener onItemClickListener;

     public  interface OnItemClickListener{
         public  void onItemClick(View view, int position);
     }

    public UsuarioAdapter(ArrayList<ItemUsuario> usuarios, OnItemClickListener onItemClickListener) {
        this.usuarios = usuarios;
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.usuario_item,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.txtId.setText(usuarios.get(position).getId());
        holder.txtNombre.setText(usuarios.get(position).getNombre());
        holder.txtApellido.setText(usuarios.get(position).getApellido());
        holder.txtUsuario.setText(usuarios.get(position).getUser());
        holder.txtPassword.setText(usuarios.get(position).getPassword());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClick(view,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return usuarios.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        TextView txtId;
        TextView txtNombre;
        TextView txtApellido;
        TextView txtUsuario;
        TextView txtPassword;
        public ViewHolder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.usuario_item_cardview);
            txtId = itemView.findViewById(R.id.usuario_item_id);
            txtNombre = itemView.findViewById(R.id.usuario_item_nombres);
            txtApellido = itemView.findViewById(R.id.usuario_item_apellidos);
            txtUsuario = itemView.findViewById(R.id.usuario_item_usuario);
            txtPassword = itemView.findViewById(R.id.usuario_item_password);
        }
    }


}

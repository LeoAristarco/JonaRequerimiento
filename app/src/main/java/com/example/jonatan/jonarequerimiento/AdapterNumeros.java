package com.example.jonatan.jonarequerimiento;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterNumeros extends RecyclerView.Adapter<AdapterNumeros.ViewHolderNumeros> implements View.OnClickListener  {

    ArrayList<String> listaDeNumeros;/** --> ArrayList<PersonajeVo> listaPersonajes */
    private View.OnClickListener listener;
    Context context;

    public AdapterNumeros(ArrayList<String> listaDeNumeros) {
        this.listaDeNumeros = new ArrayList<>();
        this.listaDeNumeros.addAll(listaDeNumeros);
    }

    @NonNull
    @Override
    public ViewHolderNumeros onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,null,false);
        context = parent.getContext();
        view.setOnClickListener(this);
        return new ViewHolderNumeros(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderNumeros holder, int position) {
        holder.cargarImagen(listaDeNumeros.get(position));
        /** seteo directamente aca los VO
         */

    }

    @Override
    public int getItemCount() {
        return listaDeNumeros.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }

    @Override
    public void onClick(View view) {
        if (listener!=null){
            listener.onClick(view);
        }

    }

    public class ViewHolderNumeros extends RecyclerView.ViewHolder {

        TextView dato;
        ImageView ivImagen;
        /** todos los demas atributos en caso de ser la lista VO (data class)
         */


        public ViewHolderNumeros(View itemView) {
            super(itemView);
            dato = itemView.findViewById(R.id.idDatos);
            ivImagen = itemView.findViewById(R.id.ivImagen);
            /** todos los demas atributos en caso de ser la lista VO (data class)
             */
        }

        /** este metodo no va para los VO, hay que setear los datos directamente en el onBindViewHolder
         */
        public void cargarImagen(String s) {
            Picasso.with(context)
                    .load(s)
                    .into(ivImagen);
        }


    }
}

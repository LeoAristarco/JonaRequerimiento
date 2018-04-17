package com.example.jonatan.jonarequerimiento;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class adapterNoticia extends RecyclerView.Adapter<adapterNoticia.ViewHolderNoticia> implements View.OnClickListener  {

    ArrayList<NoticiaVO> listaDeNoticias;/** --> ArrayList<PersonajeVo> listaPersonajes */
    private View.OnClickListener listener;
    Context context;

    public adapterNoticia(ArrayList<NoticiaVO> listaDeNoticias) {
        this.listaDeNoticias = new ArrayList<>();
        this.listaDeNoticias.addAll(listaDeNoticias);
    }

    @NonNull
    @Override
    public ViewHolderNoticia onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,null,false);
        context = parent.getContext();
        view.setOnClickListener(this);
        return new ViewHolderNoticia(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderNoticia holder, int position) {
        /** seteo directamente aca los VO
         */
        holder.cargarImagen(listaDeNoticias.get(position).getAvatarUrl());
        holder.userName.setText(listaDeNoticias.get(position).getUserName());
    }

    @Override
    public int getItemCount() {
        return listaDeNoticias.size();
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

    public class ViewHolderNoticia extends RecyclerView.ViewHolder {

        TextView userName;
        ImageView ivImagen;
        /** todos los demas atributos en caso de ser la lista VO (data class)
         */


        public ViewHolderNoticia(View itemView) {
            super(itemView);
            userName = itemView.findViewById(R.id.id_usuario);
            ivImagen = itemView.findViewById(R.id.ivImagen);
            /** todos los demas atributos en caso de ser la lista VO (data class)
             */
        }

        /** este metodo no va para los VO, hay que setear los datos directamente en el onBindViewHolder
         */
        public void cargarImagen(String urlDeImagen) {
            Picasso.with(context)
                    .load(urlDeImagen)
                    .into(ivImagen);
        }


    }
}

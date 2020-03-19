package com.example.applicationroulette.Class;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.applicationroulette.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    LayoutInflater inflater;
    ArrayList<Randonne> randonnes;


    public Adapter(Context ctx, List<Randonne> randonnes){
        this.inflater = LayoutInflater.from(ctx);
        this.randonnes = (ArrayList<Randonne>) randonnes;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    //Ici on créer la VieWHolder en fonction du conteXt
        View view = inflater.inflate(R.layout.lignerando,parent,false);
        ViewHolder obj = new ViewHolder(view);
        return obj;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //Ici en fonction de la position de lélément on vas afficher quelque chose
        holder.textView.setText(randonnes.get(position).getNomRando());
        holder.nbParticipant.setText(randonnes.get(position).getNbParticipant());
        Picasso.get().load(randonnes.get(position).getImage()).into(holder.coverImageId);


    }

    @Override
    public int getItemCount() {
        return randonnes.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView coverImageId;
        TextView textView;
        TextView nbParticipant;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            coverImageId = (ImageView) itemView.findViewById(R.id.coverImage);
            textView = (TextView) itemView.findViewById(R.id.txtNomRando);
            nbParticipant = (TextView) itemView.findViewById(R.id.txtNbParticipe);

        }
    }
}

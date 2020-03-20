package com.example.applicationroulette.Class;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.applicationroulette.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RandonneAdapter extends RecyclerView.Adapter<RandonneAdapter.ViewHolder> {

    private List<Randonne> randonnes;
    private Context ctx;


    public RandonneAdapter(List<Randonne> randonnes, Context ctx) {
        this.randonnes = randonnes;
        this.ctx = ctx;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.liste_rando,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        Randonne randonne = randonnes.get(position);

        Picasso.get().load(randonne.getImageUrl()).into(holder.imageUrlId);
        holder.NomRandoId.setText(randonne.getNom());
        //holder.NbParticipe.setText(randonne.getNbParticipant());
        holder.DescriptionId.setText(randonne.getDescription());
        holder.dateDebutId.setText(randonne.getDateDebut());
        //holder.DetailId.setText(randonne.getDetail());
        //holder.nbParticipeRequisId.setText(randonne.getNbParticipantRequis());
    }

    @Override
    public int getItemCount() {
        return randonnes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder  {
        private TextView NomRandoId, NbParticipe,DescriptionId,DetailId,nbParticipeRequisId,dateDebutId;
        private ImageView imageUrlId;


        public ViewHolder( View itemView) {
            super(itemView);

            NomRandoId = (TextView)itemView.findViewById(R.id.nomRando);
            NbParticipe = (TextView)itemView.findViewById(R.id.NbParticipe);
            imageUrlId = (ImageView)itemView.findViewById(R.id.imageView);
            DescriptionId = (TextView)itemView.findViewById(R.id.descriptionRando);
            DetailId = (TextView)itemView.findViewById(R.id.detailRando);
            nbParticipeRequisId = (TextView)itemView.findViewById(R.id.NbParticipeRequis);
            dateDebutId = (TextView)itemView.findViewById(R.id.dateDebutRando);


        }


    }


}

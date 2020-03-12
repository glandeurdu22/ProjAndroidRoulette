package com.example.applicationroulette;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterRando extends RecyclerView.Adapter<viewListeRando>{

    // FOR DATA
private List<Randon> lesRando;

    // CONSTRUCTOR
    public AdapterRando(List<Randon> rando) {
        this.lesRando = rando;
    }

    @Override
    public viewListeRando onCreateViewHolder(ViewGroup parent, int viewType) {
        // CREATE VIEW HOLDER AND INFLATING ITS XML LAYOUT
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.activity_home_membre, parent, false);

        return new viewListeRando(view);
    }

    // UPDATE VIEW HOLDER WITH A GITHUBUSER
    @Override
    public void onBindViewHolder(viewListeRando viewHolder, int position) {
        viewHolder.updateWithRando(this.lesRando.get(position));
    }

    // RETURN THE TOTAL COUNT OF ITEMS IN THE LIST
    @Override
    public int getItemCount() {
        return this.lesRando.size();
    }
}


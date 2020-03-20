package com.example.applicationroulette;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class viewListeRandoNonActive extends RecyclerView.ViewHolder {
    @BindView(R.id.RandoActive)
    TextView textView;

    public viewListeRandoNonActive(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void updateWithGithubUser(Randon rando){
        this.textView.setText(rando.getNomRando());
    }
}

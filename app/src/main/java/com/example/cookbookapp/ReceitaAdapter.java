package com.example.cookbookapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

public class ReceitaAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] nomes;
    private final int[] imagens;

    public ReceitaAdapter(Activity context, String[] nomes, int[] imagens) {
        super(context, R.layout.item_receita, nomes);
        this.context = context;
        this.nomes = nomes;
        this.imagens = imagens;
    }

    @Override
    public View getView(int pos, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.item_receita, null, true);

        TextView txtNome = rowView.findViewById(R.id.nomeReceita);
        ImageView img = rowView.findViewById(R.id.imagemReceita);

        txtNome.setText(nomes[pos]);
        img.setImageResource(imagens[pos]);

        return rowView;
    }
}
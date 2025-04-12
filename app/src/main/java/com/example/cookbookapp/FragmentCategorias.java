package com.example.cookbookapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class FragmentCategorias extends Fragment {
    private String[] receitas = {"Bolo de Chocolate", "Lasanha de Frango", "Suco Detox"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_categorias, container, false);

        ListView listView = view.findViewById(R.id.listReceitas);

        int[] imagens = { R.drawable.bolo, R.drawable.lasanha, R.drawable.suco };
        ReceitaAdapter adapter = new ReceitaAdapter(getActivity(), receitas, imagens);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, v, position, id) -> {
            String receita = receitas[position];
            Toast.makeText(getContext(), "Receita: " + receita, Toast.LENGTH_SHORT).show();
        });

        return view;
    }
}
package com.example.cookbookapp;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class FragmentGaleria extends Fragment {
    private int[] imagens = { R.drawable.bolo, R.drawable.lasanha, R.drawable.suco };
    private MediaPlayer mediaPlayer;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_galeria, container, false);

        GridView gridView = view.findViewById(R.id.gridGaleria);
        gridView.setAdapter(new ImageAdapter());

        mediaPlayer = MediaPlayer.create(getContext(), R.raw.cozinha);

        gridView.setOnItemClickListener((AdapterView<?> parent, View v, int position, long id) -> {
            Toast.makeText(getContext(), "Imagem selecionada", Toast.LENGTH_SHORT).show();
            mediaPlayer.start();
        });

        return view;
    }

    class ImageAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return imagens.length;
        }

        @Override
        public Object getItem(int i) {
            return imagens[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView(getContext());
            imageView.setImageResource(imagens[i]);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setLayoutParams(new GridView.LayoutParams(300, 300));
            return imageView;
        }
    }

    @Override
    public void onDestroy() {
        if (mediaPlayer != null) mediaPlayer.release();
        super.onDestroy();
    }
}
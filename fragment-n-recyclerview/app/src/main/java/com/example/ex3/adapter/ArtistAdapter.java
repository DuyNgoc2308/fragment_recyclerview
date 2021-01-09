package com.example.ex3.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ex3.Artist;
import com.example.ex3.R;

import java.util.List;

public class ArtistAdapter extends RecyclerView.Adapter<ArtistAdapter.ArtistViewHolder>{

    private List<Artist> mListArtist;

    public ArtistAdapter(List<Artist> mListArtist) {
        this.mListArtist = mListArtist;
    }

    @NonNull
    @Override
    public ArtistViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_yge, parent, false);
        return new ArtistViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArtistViewHolder holder, int position) {
        Artist artist = mListArtist.get(position);
        if ( artist == null) {
            return;
        }
        holder.imgArtist.setImageResource(artist.getImage());
        holder.txtArtist.setText(artist.getName());
    }

    @Override
    public int getItemCount() {
        if (mListArtist != null) {
            return mListArtist.size();
        }
        return 0;
    }

    public class ArtistViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgArtist;
        private TextView txtArtist;

        public ArtistViewHolder(@NonNull View itemView) {
            super(itemView);
            imgArtist = itemView.findViewById(R.id.img_yge);
            txtArtist = itemView.findViewById(R.id.txt_name);
        }
    }
}

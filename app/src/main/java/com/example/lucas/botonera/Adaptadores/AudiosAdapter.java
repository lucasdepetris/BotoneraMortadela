package com.example.lucas.botonera.Adaptadores;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lucas.botonera.Audio;
import com.example.lucas.botonera.MainActivity;
import com.example.lucas.botonera.R;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by lucas on 25/7/2017.
 */

public class AudiosAdapter extends RecyclerView.Adapter<AudiosAdapter.ViewHolder> {

    private List<Audio> audios = new ArrayList<Audio>();
    private Context mContext;
    private  MediaPlayer mp;

    public AudiosAdapter(List<Audio> sucursales, Context context) {
        this.mContext = context;
        this.audios = sucursales;
    }
    public List<Audio> getAudios(){return this.audios;}

    @Override
    public int getItemCount() {
        return audios.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.audios, null);
        return new AudiosAdapter.ViewHolder(itemLayoutView);
    }
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        final Audio aud = this.audios.get(position);

        holder.nombre.setText(aud.getNombre());
        holder.play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mContext instanceof MainActivity){

                    ((MainActivity)mContext).play(aud.getSoundId());
                }
              /*mp = MediaPlayer.create(mContext,aud.getSoundId());
              mp.start();*/
            }
        });
        holder.pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.pause();
                mp.release();
            }
        });
        holder.stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mContext instanceof MainActivity){

                    ((MainActivity)mContext).stop(aud.getSoundId());
                }
               /* mp.stop();
                mp.release();*/
            }
        });
    }
    public class ViewHolder extends RecyclerView.ViewHolder {

        private final View item;
        /* @OnClick(R.id.agregar)public void agregarProd(){

             }*/
        @BindView(R.id.descAudio)
        TextView nombre;
        @BindView(R.id.imgAudio)
        ImageView imgAudio;
        @BindView(R.id.play)
        ImageView play;
        @BindView(R.id.pause)
        ImageButton pause;
        @BindView(R.id.stop)
        ImageView stop;

        public ViewHolder(View itemView) {
            super(itemView);
            this.item = itemView;
            ButterKnife.bind(this, itemView);
        }

    }

}
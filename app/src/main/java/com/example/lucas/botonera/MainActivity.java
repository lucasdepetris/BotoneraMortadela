package com.example.lucas.botonera;

import android.content.Context;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.lucas.botonera.Adaptadores.AudiosAdapter;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.google.android.gms.ads.AdRequest.ERROR_CODE_INTERNAL_ERROR;
import static com.google.android.gms.ads.search.SearchAdRequest.ERROR_CODE_INVALID_REQUEST;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mp;
    private int audioSonando;
    private boolean paro = true;
    @BindView(R.id.reciclerView)
    RecyclerView recicler;
    private  ArrayList<Audio> audios;
    private Context ctx;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        MobileAds.initialize(getApplicationContext(),
                "ca-app-pub-1301135226655762~8602515967");

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        ctx = this;
        ArrayList<Audio> audiosPasar = new ArrayList<Audio>();
        audiosPasar.add(new Audio("Dale",R.raw.daale,1,"Pablo"));
        audiosPasar.add(new Audio("Te voy a matar",R.raw.tevoyamatar,1,"Pablo"));
        audiosPasar.add(new Audio("A mi me va bien",R.raw.mevabien,1,"Pablo"));
        audiosPasar.add(new Audio("Abri un reclamo",R.raw.reclamo,1,"Pablo"));
        audiosPasar.add(new Audio("Tenes Pruebas?",R.raw.tenespruebas,1,"Pablo"));
        audiosPasar.add(new Audio("Una mano en la cintura",R.raw.unamanoenlacintura,1,"Pablo"));
        audiosPasar.add(new Audio("Che pablo",R.raw.chepablo,2,"Chris"));
        audiosPasar.add(new Audio("Cuchame Pablito",R.raw.cuchamepablito,2,"Chris"));
        audiosPasar.add(new Audio("Che cuchame vol3",R.raw.chepablitocuchame2,2,"Chris"));
        audiosPasar.add(new Audio("Che cuchame vol4",R.raw.checuchamepablito3,2,"Chris"));
        audiosPasar.add(new Audio("No Comprende",R.raw.nocomprende,3,"Blue"));
        audiosPasar.add(new Audio("Oh my god",R.raw.ohmygodbeto,3,"Blue"));
        audiosPasar.add(new Audio("No puedo salvarlos en todas",R.raw.nopuedosalvarlos,4,"Beto"));
        audiosPasar.add(new Audio("Me entregaron",R.raw.meentregaron,4,"Beto"));
        audiosPasar.add(new Audio("Callate vos",R.raw.callatevos,5,"Rader"));
        audiosPasar.add(new Audio("Chupame el choto",R.raw.chupameelchoto,5,"Rader"));
        audiosPasar.add(new Audio("La que te pario",R.raw.laquetepario,5,"Rader"));
        audiosPasar.add(new Audio("Acepta Ya!",R.raw.aceptaya,5,"Rader"));
        audiosPasar.add(new Audio("La cago",R.raw.lacago,6,"Manu"));
        audiosPasar.add(new Audio("Risa malvada",R.raw.risamanu,6,"Manu"));
        audiosPasar.add(new Audio("Me Boto",R.raw.meboto,7,"Oswell"));
        audiosPasar.add(new Audio("La salvacion",R.raw.lasalvacion,8,"Depetris"));
        audiosPasar.add(new Audio("Desagradecidos",R.raw.desagradecidos,8,"Depetris"));
        audiosPasar.add(new Audio("Marcha funebre",R.raw.trompetafuneral,9,"Marcha"));
        audiosPasar.add(new Audio("Rajarse un tiro",R.raw.rajarseuntiro,10,"Luker"));
        audiosPasar.add(new Audio("Concentrense che",R.raw.vamoscheconcentrensen,10,"Luker"));
        audiosPasar.add(new Audio("Pablo eh eh eh",R.raw.pabloeheheh,2,"Chris"));
        audiosPasar.add(new Audio("Eh Juez!",R.raw.ehjuez,2,"Chris"));
        audiosPasar.add(new Audio("Felices con pablo",R.raw.felicesconpablo,2,"Chris"));
        audiosPasar.add(new Audio("Hay adela",R.raw.ayadela,2,"Chris"));
        audiosPasar.add(new Audio("Marica Beto",R.raw.maricabeto,2,"Chris"));
        audiosPasar.add(new Audio("Vamos Pablo",R.raw.vamospablo,2,"Chris"));
        audiosPasar.add(new Audio("Este le pega mal",R.raw.estelepegaparaelojete,11,"Tigre"));
        audiosPasar.add(new Audio("Que decis huevon",R.raw.playmarzvsnahuel,12,"Nahuel"));
        audiosPasar.add(new Audio("Que hdp que sos!",R.raw.quehijodeputaquesos,5,"Rader"));
        audiosPasar.add(new Audio("Bueno voy!",R.raw.chrispateapenal,2,"Chris"));
        audiosPasar.add(new Audio("Correte Oswell",R.raw.correteoswell,12,"Nahuel"));
        audiosPasar.add(new Audio("Te voy a matar rader",R.raw.tevoyamatarrader,1,"Pablo"));
        audiosPasar.add(new Audio("Sos un hijo de puta",R.raw.sosunhdp,5,"Rader"));
        audiosPasar.add(new Audio("Inimputable",R.raw.inimputable,13,"Fer"));
        audiosPasar.add(new Audio("Te la doy pablo",R.raw.teladoypablovete,7,"Oswell"));
        audiosPasar.add(new Audio("Perdon pablito",R.raw.perdonpablito,2,"Chris"));
        audiosPasar.add(new Audio("No beto, no!",R.raw.nobetonobeto,12,"Nahuel"));
        audiosPasar.add(new Audio("Tranquilos es la salvacion",R.raw.tranquiloeslasalvacion,14,"Edu"));
        audiosPasar.add(new Audio("Fiuuuum",R.raw.fiuumm,8,"Depetris"));
        audiosPasar.add(new Audio("Noooooo",R.raw.nooooo,1,"Pablo"));
        audiosPasar.add(new Audio("Graba eso beto!",R.raw.grabaesobeto,13,"Fer"));
        audiosPasar.add(new Audio("Soy rubio con ojos verdes!",R.raw.chetorubio,10,"Luker"));
        audiosPasar.add(new Audio("Chris electro",R.raw.chriselectropablo,2,"Chris"));
        audiosPasar.add(new Audio("Dale pablo dale",R.raw.dalepablodale,2,"Chris"));
        audiosPasar.add(new Audio("Vamo betooo",R.raw.vamobeto,2,"Chris"));
        audios = audiosPasar;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recicler.setLayoutManager(linearLayoutManager);
        AudiosAdapter adapter = new AudiosAdapter(audiosPasar,this);
        // lista =(ListView) findViewById(R.id.listaProductoSucursales);
        recicler.setAdapter(adapter);
    }
    public void play(int sound){
        if(!paro)
        {

                mp.stop();
                mp.reset();
                mp.release();

        }
        audioSonando = sound;
        mp = MediaPlayer.create(this,sound);
        mp.start();
        paro = false;
    }
    public void stop(int sound){
        if(audioSonando == sound) {
            mp.stop();
            mp.reset();
            mp.release();
            paro = true;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_filter, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

            switch (item.getItemId()) {
                case R.id.filter:
                    CharSequence colors[] = new CharSequence[] {"Ordenar Alfabeticamente", "Ordenar Por Autor"};
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("Filtrar");
                    builder.setItems(colors, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // the user clicked on colors[which]
                            switch (which){
                                case 0:

                                    Collections.sort(audios, new Comparator<Audio>() {
                                        @Override
                                        public int compare(Audio p1, Audio p2) {
                                            return (p1.getNombre()).compareTo(p2.getNombre());
                                        }
                                    });
                                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ctx);
                                    recicler.setLayoutManager(linearLayoutManager);
                                    AudiosAdapter adapter = new AudiosAdapter(audios,ctx);
                                    // lista =(ListView) findViewById(R.id.listaProductoSucursales);
                                    recicler.setAdapter(adapter);
                                    break;
                                case 1:
                                    Collections.sort(audios, new Comparator<Audio>() {
                                        @Override
                                        public int compare(Audio p1, Audio p2) {
                                            return (p1.getAutor()).compareTo(p2.getAutor());
                                        }
                                    });
                                    linearLayoutManager = new LinearLayoutManager(ctx);
                                    recicler.setLayoutManager(linearLayoutManager);
                                    adapter = new AudiosAdapter(audios,ctx);
                                    // lista =(ListView) findViewById(R.id.listaProductoSucursales);
                                    recicler.setAdapter(adapter);
                                    break;
                            }
                        }
                    });
                    builder.show();
                    break;
        }
        return true;
    }
}

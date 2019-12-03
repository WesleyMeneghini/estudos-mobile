package com.example.a19180131.newsapp_b;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.pkmmte.pkrss.Article;
import com.pkmmte.pkrss.Callback;
import com.pkmmte.pkrss.PkRSS;

import java.util.ArrayList;
import java.util.List;

//classe que mostrara o recyclerview
public class FeedActivity extends AppCompatActivity implements Callback {

    //declarando o recyclerview
    private RecyclerView recyclerView;
    private RecyclerAdapter recyclerAdapter;
    //criando um objeto array com uma lista vazia
    private List<Article> artigos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        recyclerView = findViewById(R.id.artigos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerAdapter = new RecyclerAdapter(artigos);
        recyclerView.setAdapter(recyclerAdapter);

        PkRSS.with(this).load("http://androidpro.com.br/feed/").skipCache().callback(this).async();

    }

    //antes de carregar o conteudo da web
    @Override
    public void onPreload() {

    }

    //conteudo carregado
    @Override
    public void onLoaded(List<Article> newArticles) {
        //limpando os artigos antigos
        artigos.clear();
        //adiciona os novos artigos
        artigos.addAll(newArticles);
        //notificar que os dados foram alerados. Para reenderizar
        recyclerAdapter.notifyDataSetChanged();
    }

    //falha no carregamento
    @Override
    public void onLoadFailed() {

    }
}

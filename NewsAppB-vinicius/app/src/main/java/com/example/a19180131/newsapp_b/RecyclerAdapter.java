package com.example.a19180131.newsapp_b;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pkmmte.pkrss.Article;

import java.util.List;

//
public class RecyclerAdapter extends RecyclerView.Adapter<ViewHolderFeed>{

    private List<Article> artigos;

//  criando o construtor para receber uma lista de artigos
    public RecyclerAdapter(List<Article> artigos){
        this.artigos = artigos;
    }

    //card de noticias
    @NonNull
    @Override
    public ViewHolderFeed onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //criar uma view que vai inflar com o view
        //inflando o elemento pai com o contexto(artigo)
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        //retornar o objeto view
        return new ViewHolderFeed(view);
    }

    //
    @Override
    public void onBindViewHolder(@NonNull ViewHolderFeed holder, int position) {
        //pegando o artigos pela posiçao e colocando no recyclerView
        Article artigo = artigos.get(position);
        //colocando o titulo do artigo no atibuto da class ViewHolderFeed
        holder.tituloArtigo.setText(artigo.getTitle());
        //adicionando o autor
        holder.descricaoArtigo.setText(artigo.getAuthor());

    }

    //
    @Override
    public int getItemCount() {
        return artigos.size();
    }
}

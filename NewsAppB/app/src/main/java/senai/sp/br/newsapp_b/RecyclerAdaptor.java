package senai.sp.br.newsapp_b;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pkmmte.pkrss.Article;

import java.util.List;

public class RecyclerAdaptor extends RecyclerView.Adapter<ViewHolderFeed>{

    private List<Article> artigos;

    public RecyclerAdaptor(List<Article> artigos) {
        this.artigos = artigos;
    }


    @NonNull
    @Override
    public ViewHolderFeed onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //criar uma view que vai inflar com o view
        //inflando o elemento pai com o contexto(artigo)
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolderFeed(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderFeed holder, int position) {
        //pegando o artigos pela posiçao e colocando no recyclerView
        Article article = artigos.get(position);
        //colocando o titulo do artigo no atibuto da class ViewHolderFeed
        

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}

package senai.sp.br.newsapp_b;

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
public class FeedActivity extends AppCompatActivity implements Callback{

    private RecyclerView recyclerView;
    private RecyclerAdaptor recyclerAdaptor;
    private List<Article> artigos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        recyclerView = findViewById(R.id.artigos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerAdaptor = new RecyclerAdaptor(artigos);
        recyclerView.setAdapter(recyclerAdaptor);

        PkRSS.with(this).load("http://androidpro.com.br/feed/").skipCache().callback(this).async();

    }

    //antes de carregar o conteudo da web
    @Override
    public void onPreload() {

    }

    @Override
    public void onLoaded(List<Article> newArticles) {
        artigos.clear();

        artigos.addAll(newArticles);

        recyclerAdaptor.notifyDataSetChanged();
    }

    @Override
    public void onLoadFailed() {

    }
}

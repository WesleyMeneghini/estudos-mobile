package senai.sp.br.toolbaractivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Declarar o objeto ToolBar
        toolbar = findViewById(R.id.toolbar);
        // Adicionar a Toolbar a esta tela
        setSupportActionBar(toolbar);


    }

    // sobreescrever o metodo para criar um novo menu antes de  startar o metodo onCreate
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflar o menu que esta vazio com conteudo do tipo menu
        getMenuInflater().inflate(R.menu.menu_tollbar, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.menu_buscar:{
                Toast.makeText(this, "Buscar...",Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.menu_carrinho:{
                Toast.makeText(this, "Carrinho...",Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.menu_configuracoes:{
                Toast.makeText(this, "Configurações...",Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.menu_sobre:{
                Toast.makeText(this, "Sobre...",Toast.LENGTH_SHORT).show();
                break;
            }
        }

        return super.onOptionsItemSelected(item);
    }
}

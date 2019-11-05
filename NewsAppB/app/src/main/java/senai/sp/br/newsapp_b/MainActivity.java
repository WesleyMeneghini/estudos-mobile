package senai.sp.br.newsapp_b;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnLogin;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = (Button) findViewById(R.id.btn_login);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbar.setTitle("Login");
        setSupportActionBar(toolbar);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openCategories = new Intent(MainActivity.this, CategoriesActivity.class);
                startActivity(openCategories);
            }
        });
    }
}

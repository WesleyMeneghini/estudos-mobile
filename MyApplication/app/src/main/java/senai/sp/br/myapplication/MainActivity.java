package senai.sp.br.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button btnCalcular;

    public static final String teste = "teste";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCalcular = findViewById(R.id.btn_calcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DisplayMessageActivity.class);
                EditText editText = (EditText) findViewById(R.id.editText);
                String message = editText.getText().toString();
                intent.putExtra(teste, message);
                startActivity(intent);
            }
        });
    }


}

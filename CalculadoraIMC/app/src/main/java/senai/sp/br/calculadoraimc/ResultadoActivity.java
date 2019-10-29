package senai.sp.br.calculadoraimc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {

    private TextView txtResultado;
    private TextView txtEstado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_imc);

        Intent intent = getIntent();
        String imc = intent.getStringExtra("imc");
        String estado = intent.getStringExtra("estado");

        txtResultado = findViewById(R.id.txt_resultado);
        txtEstado = findViewById(R.id.txt_estado);


        txtResultado.setText(imc);
        txtEstado.setText(estado);

    }
}

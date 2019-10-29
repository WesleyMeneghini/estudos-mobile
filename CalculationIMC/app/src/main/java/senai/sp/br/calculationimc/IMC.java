package senai.sp.br.calculationimc;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class IMC extends AppCompatActivity {

    private EditText txtNome;
    private EditText txtAltura;
    private EditText txtPeso;
    private Button btnCalcular;
    private TextInputLayout layoutTxtNome;
    private TextInputLayout layoutTxtAltura;
    private TextInputLayout layoutTxtPeso;
//    private TextInputLayout layoutTxtResultado;
    private TextView txtResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);

        txtNome = findViewById(R.id.txt_nome);
        txtPeso = findViewById(R.id.txt_peso);
        txtAltura = findViewById(R.id.txt_altura);
        btnCalcular = findViewById(R.id.btn_calcular);
        layoutTxtNome = findViewById(R.id.layout_txt_nome);
        layoutTxtAltura = findViewById(R.id.layout_txt_altura);
        layoutTxtPeso = findViewById(R.id.layout_txt_peso);
        txtResultado = findViewById(R.id.txt_resultado);


        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double peso = 0.0;
                double altura = 0.0;

                if(true){
                    if(txtNome.getText().toString().isEmpty()){
                        layoutTxtNome.setErrorEnabled(true);
                        layoutTxtNome.setError("Nome é obrigatório!");
                    }else{
                        layoutTxtNome.setErrorEnabled(false);
                    }

                    if(txtPeso.getText().toString().isEmpty()){
                        layoutTxtPeso.setErrorEnabled(true);
                        layoutTxtPeso.setError("Peso é obrigatório!");
                    }else{
                        layoutTxtPeso.setErrorEnabled(false);
                        peso = Double.parseDouble(txtPeso.getText().toString());
                    }

                    if(txtAltura.getText().toString().isEmpty()){
                        layoutTxtAltura.setErrorEnabled(true);
                        layoutTxtAltura.setError("Altura é obrigatoria!");
                    }else{
                        layoutTxtAltura.setErrorEnabled(false);
                        altura = Double.parseDouble(txtAltura.getText().toString());
                    }
                    double imc = peso / (altura * altura);
                    String resultado = String.valueOf(imc);
                    txtResultado.setText(resultado);
                }
                /*else{

                   double imc = peso / (altura * altura);
                   String resultado = String.valueOf(imc);
                   txtResultado.setText(resultado);
                }
                */


            }
        });
    }
}

package senai.sp.br.calculadoraimc;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    public static final String imcActivity = "imc";
    public static final String estadoActivity = "estado";
    private Button btnCalcular;
    private EditText txtPeso;
    private EditText txtAltura;
    private TextInputLayout layoutTxtPeso;
    private TextInputLayout layoutTxtAltura;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        btnCalcular = findViewById(R.id.btn_calcular);
        txtPeso = findViewById(R.id.txt_peso);
        txtAltura = findViewById(R.id.txt_altura);
        layoutTxtPeso = findViewById(R.id.layout_txt_peso);
        layoutTxtAltura = findViewById(R.id.layout_txt_altura);


        this.btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DecimalFormat f = new DecimalFormat("#0.00");

                if(txtPeso.getText().toString().isEmpty()){
                    layoutTxtPeso.setErrorEnabled(true);
                    layoutTxtPeso.setError("Peso é obrigatório");
                }else{

                    layoutTxtPeso.setErrorEnabled(false);

                    if (txtAltura.getText().toString().isEmpty()){
                        layoutTxtAltura.setErrorEnabled(true);
                        layoutTxtAltura.setError("Altura é obrigatório");
                    }else {
                        layoutTxtAltura.setErrorEnabled(false);
                        double peso = Double.parseDouble(txtPeso.getText().toString());
                        double altura = Double.parseDouble(txtAltura.getText().toString());

                        double imc = peso / (altura*altura);
                        String estado = "";

                        if (imc < 17){
                            estado = "Muito abaixo do peso";
                        }
                        else {
                            if ((imc >= 17) && (imc < 18.5)){
                                estado = "Abaixo do peso";
                            }
                            else {
                                if ((imc >= 18.5) && (imc <= 25)){
                                    estado = "Peso normal";
                                }
                                else{
                                    if ((imc >= 25) && (imc < 30)){
                                        estado = "Acima do peso";
                                    }
                                    else{
                                        if ((imc >= 30) && (imc < 35)){
                                            estado =  "Obesidade 1";
                                        }
                                        else{
                                            if ((imc >= 35) && (imc < 40)){
                                                estado = "Obesidade 2 (severa)";
                                            }
                                            else{
                                                if (imc >= 40){
                                                    estado = "Obesidade 3 (morbida)";
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }




                        Intent abrirActivityResposta = new Intent(MainActivity.this, ResultadoActivity.class);

                        String resultadoImc = String.valueOf(f.format(imc));

                        abrirActivityResposta.putExtra("imc", resultadoImc);
                        abrirActivityResposta.putExtra("estado", estado);

                        startActivity(abrirActivityResposta);
                    }


                }

            }
        });
    }
}

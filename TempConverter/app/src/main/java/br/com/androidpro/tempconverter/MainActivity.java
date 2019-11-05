package br.com.androidpro.tempconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    private EditText txtTemperatura;
    private RadioButton rdoCelcius;
    private RadioButton rdoFareinheit;
    private Button btnConverter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTemperatura = (EditText) findViewById(R.id.txt_temperatura);
        rdoCelcius = (RadioButton) findViewById(R.id.rdo_celcius);
        rdoFareinheit = (RadioButton) findViewById(R.id.rdo_fahreinheit);
        btnConverter = (Button) findViewById(R.id.btn_converter);

        btnConverter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                conversor();
            }
        });
    }

    public void conversor(){
        Double temperatura = Double.valueOf(txtTemperatura.getText().toString());

        if(rdoCelcius.isChecked()){
            temperatura = (temperatura - 32) * 5/9;
        } else if(rdoFareinheit.isChecked()){
            temperatura = temperatura * 9/5 + 32;
        }

        txtTemperatura.setText(temperatura.toString());
    }
}

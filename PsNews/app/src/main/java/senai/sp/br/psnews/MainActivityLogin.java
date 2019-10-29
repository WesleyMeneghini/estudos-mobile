package senai.sp.br.psnews;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivityLogin extends AppCompatActivity {

    private TextInputLayout layoutTxtEmail;
    private TextInputLayout layoutTxtPassword;
    private EditText txtEmail;
    private EditText txtPassword;
    private Button btnLogin;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_login);

        layoutTxtEmail = findViewById(R.id.layout_txt_email);
        layoutTxtPassword = findViewById(R.id.layout_txt_password);
        txtEmail = findViewById(R.id.txt_email);
        txtPassword = findViewById(R.id.txt_password);
        btnLogin = findViewById(R.id.btn_login);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Login");
        setSupportActionBar(toolbar);

        this.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(txtEmail.getText().toString().isEmpty()){
                    layoutTxtEmail.setErrorEnabled(true);
                    layoutTxtEmail.setError("Email é obrigatório");
                }else{

                    layoutTxtEmail.setErrorEnabled(false);

                    if(txtPassword.getText().toString().isEmpty()){
                        layoutTxtPassword.setErrorEnabled(true);
                        layoutTxtPassword.setError("Senha é obrigatória");
                    }else{

                        layoutTxtPassword.setErrorEnabled(false);

                        Intent abrirActivityCategories = new Intent(MainActivityLogin.this, ActivityCategories.class);
                        startActivity(abrirActivityCategories);

                    }
                }




            }
        });
    }
}

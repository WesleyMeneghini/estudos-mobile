package senai.sp.br.relativelayout;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private ImageButton btnFoto;
    private static final int CODIGO_RETORNO_DA_FOTO = 595;
    private ImageView imgFoto;
    private Bitmap bitMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFoto = findViewById(R.id.btn_foto);
        imgFoto = findViewById(R.id.img_foto);

        btnFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent abrirActivity2 = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(abrirActivity2);


//                Intent abrirGaleria = new Intent();
//
//                /* tipo de arquivos que vai abrir*/
//                abrirGaleria.setType("image/*");
//
//                /* intencao para abrir a galeria de fotos*/
//                abrirGaleria.setAction(Intent.ACTION_PICK);
//
//                /* Abre a galeria e coloca  a aplicacao em pause e para voltar e procura o metodo onActivityResult  -> que é o proximo metodo*/
//                startActivityForResult(abrirGaleria, CODIGO_RETORNO_DA_FOTO);


            }
        });
    }


    /* metodo para a aplicacao voltar depois de entrar na galeria*/
    @Override
    /*
        requestCode -> codigo que foi passado para identificar qual intencao foi aberta
        resultCode  -> retorna se a aplicacao deu certo mostrando um numero (-1 retorna foto, 0 nao retorna nada)
        data -> o arquivo que retorna
    */
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        Toast.makeText(this, "Voltei!!!", Toast.LENGTH_SHORT).show();
        super.onActivityResult(requestCode, resultCode, data);

        /* local onde a foto esta no celular*/

        if( resultCode == -1){
            Uri caminhoDaFoto = data.getData();
            try {
                bitMap = MediaStore.Images.Media.getBitmap(getContentResolver(), caminhoDaFoto);
                imgFoto.setImageBitmap(bitMap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

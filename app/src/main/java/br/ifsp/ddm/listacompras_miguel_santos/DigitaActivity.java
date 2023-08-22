package br.ifsp.ddm.listacompras_miguel_santos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;


import java.util.ArrayList;

public class DigitaActivity extends AppCompatActivity {

    private EditText txtNome;
    private EditText txtMarca;
    private EditText txtQuantidade;
    private Button btnAdiciona;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digita);

        // ligando atributos com os ID dos objetos na interface
        txtNome = findViewById( R.id.txtNome );
        txtMarca = findViewById( R.id.txtMarca );
        txtQuantidade = findViewById( R.id.txtQuantidade );
        btnAdiciona = findViewById( R.id.btnAdiciona );

        //adicionando o escutador no botão de adicionar
        btnAdiciona.setOnClickListener(new EscutadorBtnAdicionar());
    }

    //classe do escutador do botão de adicionar:
    class EscutadorBtnAdicionar implements View.OnClickListener {
        @Override
        public void onClick(View view){
            Intent conteudo = new Intent();

            String nome = txtNome.getText().toString();
            String quantidade = txtQuantidade.getText().toString();
            String marca = txtMarca.getText().toString();

            conteudo.putExtra("nome", nome);
            conteudo.putExtra("marca", marca);
            conteudo.putExtra("quantidade", quantidade);

            setResult( RESULT_OK, conteudo );

            finish();
        }
    }
}
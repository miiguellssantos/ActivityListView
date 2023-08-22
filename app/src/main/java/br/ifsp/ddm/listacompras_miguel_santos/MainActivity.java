package br.ifsp.ddm.listacompras_miguel_santos;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button btnVai;
    private ListView listaProdutos;

    private AdapterProdutos adaptador;

    private ArrayList<Produto> produtos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnVai = findViewById(R.id.btnVai);
        listaProdutos = findViewById(R.id.listaProdutos);

        btnVai.setOnClickListener(new EscutadorVai());

        adaptador = new AdapterProdutos(this, produtos);

        listaProdutos.setAdapter(adaptador);

        // Criando o objeto escutador de cliques na lista:
        EscutadorLista el = new EscutadorLista();
        // Configurar a lista com o escutador de cliques comuns:
        listaProdutos.setOnItemClickListener( el );
        // configurar a lista com o escutador de cliques longos
        listaProdutos.setOnItemLongClickListener( el );


    }

    //classe do escutador do botão vai:
    class EscutadorVai implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            // CRIANDO O INTENT QUE VAI ABRIR A ACITIVITY:
            Intent i = new Intent( getApplicationContext(), DigitaActivity.class );
            startActivityForResult( i, 1 );
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        String nome;
        String marca;
        String quantidade;

            if (resultCode == RESULT_OK){
                nome =data.getStringExtra("nome");
                marca =data.getStringExtra("marca");
                quantidade = data.getStringExtra("quantidade");

                Produto p = new Produto(nome, marca, quantidade, "");

                produtos.add(p);


                // avisando o adapter que os dados foram atualizados
                adaptador.notifyDataSetChanged();

                System.out.println(produtos);
            } else {
                // EXIBINDO TOAST INFORMATIVO:
                String msg = "O usuário clicou no BACK do celular";
                Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
            }



    }

    // Criando a classe escutadora de cliques na lista:
    private class EscutadorLista implements AdapterView.OnItemClickListener,
            AdapterView.OnItemLongClickListener {
        // Método que vai ser chamado no caso de clique simples:

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            // O parâmetro i é o número do item clicado ...

            // Pegando o objeto correto no Arraylist:
            Produto p = produtos.get(i);

            if (p.getComprado().equals("")){
                p.setComprado("*COMPRADO*");
                // Avisar o adapter que o arraylist mudou:
                adaptador.notifyDataSetChanged();
            }

        }

        // Método que vai ser chamado no caso de clique longo:

        @Override
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
            // Remover o item de índice i do ArrayList:
            produtos.remove( i );
            // Avisar o adapter que o arraylist mudou:
            adaptador.notifyDataSetChanged();
            // mensagem informativa
            Toast.makeText(MainActivity.this, "Item apagado!", Toast.LENGTH_LONG).show();
            // receita de bolo: retornar true, indicando que o evento foi tratado.
            // se retornar false, vai querer tratar clique comum também
            return true;
        }
    }

}
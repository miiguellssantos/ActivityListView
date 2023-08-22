package br.ifsp.ddm.listacompras_miguel_santos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AdapterProdutos extends ArrayAdapter<Produto> {
    // Atributos:
    // Contexto:
    private Context context;
    // Arraylist de objetos do tipo Produto:
    private ArrayList<Produto> produtos;
    // Construtor:
    public AdapterProdutos(Context context, ArrayList<Produto> produtos) {
        // Super:
        // contexto, layout do item da lista, arraylist com os itens
        super(context, R.layout.item_lista, produtos);
        // Guarda o contexto no atributo correspondente:
        this.context = context;
        // Guarda o arraylist com os itens no atributo correspondente:
        this.produtos = produtos;
    }
    // Método getView():
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Recuperar um objeto "inflador” de layouts...
        LayoutInflater li = LayoutInflater.from(parent.getContext());
        // "Inflando" o xml do item da lista, gerando sua visualização (view):
        View itemView = li.inflate(R.layout.item_lista, parent, false);
        // Pegando referência para os objetos gráficos dentro do objeto inflado:
        TextView lblNome = itemView.findViewById(R.id.lblNome);
        TextView lblMarca = itemView.findViewById(R.id.lblMarca);
        TextView lblQuantidade = itemView.findViewById(R.id.lblQuantidade);
        TextView lblComprado = itemView.findViewById(R.id.lblComprado);

        // Acessando o objeto correspondente (índice position) no arraylist.
        // Pegando seus dados, e colocando eles dentro da view,
        // utilizando as referências estabelecidas acima:
        lblNome.setText(produtos.get(position).getNome());
        lblMarca.setText(produtos.get(position).getMarca());
        lblQuantidade.setText(produtos.get(position).getQuantidade());

        // A view do item da lista está montada!!
        // É só devolver!
        return itemView;
    }

}

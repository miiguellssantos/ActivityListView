package br.ifsp.ddm.listacompras_miguel_santos;

public class Produto {
    private String nome;
    private String marca;
    private String quantidade;
    private String comprado;

    public Produto(String nome, String marca, String quantidade, String comprado) {
        this.nome = nome;
        this.marca = marca;
        this.quantidade = quantidade;
        this.comprado = "";
    }

    public String getNome() {
        return nome;
    }

    public String getMarca() {
        return marca;
    }

    public String getQuantidade() {
        return quantidade;
    }

    public String getComprado() {
        return comprado;
    }

    public void setComprado(String comprado) {
        this.comprado = comprado;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", marca='" + marca + '\'' +
                ", quantidade='" + quantidade + '\'' +
                ", comprado='" + comprado + '\'' +
                '}';
    }
}

package br.com.pesquisasPerifericos.pesquisasPerifericos.dtos;

import br.com.pesquisasPerifericos.pesquisasPerifericos.models.Produto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoDTO {
    private String nome;
    private String marca;
    private double preco;


    public ProdutoDTO(Produto produto){
        this.nome = produto.getNome();
        this.marca = produto.getMarca();
        this.preco = produto.getPreco();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
}

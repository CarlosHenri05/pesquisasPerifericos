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

}

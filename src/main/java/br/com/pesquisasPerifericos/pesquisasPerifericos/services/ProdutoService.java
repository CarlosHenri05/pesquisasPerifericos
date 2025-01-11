package br.com.pesquisasPerifericos.pesquisasPerifericos.services;

import br.com.pesquisasPerifericos.pesquisasPerifericos.dtos.ProdutoDTO;
import br.com.pesquisasPerifericos.pesquisasPerifericos.exceptions.ResourceNotFoundException;
import br.com.pesquisasPerifericos.pesquisasPerifericos.models.Produto;
import br.com.pesquisasPerifericos.pesquisasPerifericos.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ProdutoDTO> listarProdutos(){
        return produtoRepository.findAll()
                .stream()
                .map(ProdutoDTO::new)
                .collect(Collectors.toList());
    }

    public List<ProdutoDTO> buscarProdutosPorNome(String nome){
        return produtoRepository.findByNomeContainingIgnoreCase(nome)
                .stream()
                .map(ProdutoDTO::new)
                .collect(Collectors.toList());
    }

    public void deletarProduto(Long id) {
        Produto produto = produtoRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Não encontrado pelo id: "+id));

        produtoRepository.deleteById(id);

    }

}

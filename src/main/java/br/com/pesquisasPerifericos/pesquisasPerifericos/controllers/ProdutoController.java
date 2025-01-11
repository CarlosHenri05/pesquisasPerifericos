package br.com.pesquisasPerifericos.pesquisasPerifericos.controllers;


import br.com.pesquisasPerifericos.pesquisasPerifericos.dtos.ProdutoDTO;
import br.com.pesquisasPerifericos.pesquisasPerifericos.models.Produto;
import br.com.pesquisasPerifericos.pesquisasPerifericos.repositories.ProdutoRepository;
import br.com.pesquisasPerifericos.pesquisasPerifericos.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;
    @Autowired
    private ProdutoRepository produtoRepository;


    @RequestMapping("/mostrarprodutos")
    @GetMapping
    public List<Produto> obterProdutos(){
        return produtoRepository.findAll();
    }

    @RequestMapping("/listarProdutos")
    @PostMapping
    public ResponseEntity<List<ProdutoDTO>> listarProdutos(@RequestParam(required = false) String nome) {
        List<ProdutoDTO> produtos = nome == null ? produtoService.listarProdutos() : produtoService.buscarProdutosPorNome(nome);
        return ResponseEntity.ok(produtos);
    }

    @RequestMapping("/apagarProdutos")
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletarProduto(@PathVariable Long id){
        produtoService.deletarProduto(id);
        return ResponseEntity.ok("Deletado com sucesso!");
    }

}
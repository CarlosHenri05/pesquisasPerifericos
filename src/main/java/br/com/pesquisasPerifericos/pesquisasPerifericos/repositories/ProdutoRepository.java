package br.com.pesquisasPerifericos.pesquisasPerifericos.repositories;

import br.com.pesquisasPerifericos.pesquisasPerifericos.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Long> {
    List<Produto> findByNomeContainingIgnoreCase(String nome);

}

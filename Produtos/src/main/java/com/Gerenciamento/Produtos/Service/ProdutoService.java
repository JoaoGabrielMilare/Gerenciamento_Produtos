package com.Gerenciamento.Produtos.Service;

import com.Gerenciamento.Produtos.Model.ProdutoModel;
import com.Gerenciamento.Produtos.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repository;

    public ProdutoModel criarProduto(ProdutoModel produto) {
        return repository.save(produto);
    }

    public List<ProdutoModel> listarTodos(){
        return repository.findAll();
    }

    public Optional<ProdutoModel> buscarPorId(Long id){
        return repository.findById(id);
    }

    public ProdutoModel atualizarProduto(Long id, ProdutoModel produtoatualizado){
        Optional<ProdutoModel> produtoExistente = repository.findById(id);
        if(produtoExistente.isPresent()){
            ProdutoModel produto = produtoExistente.get();
            produto.setNome(produtoatualizado.getNome());
            produto.setPreco(produtoatualizado.getPreco());
            produto.setDescricao(produtoatualizado.getDescricao());
            produto.setStatusProduto(produtoatualizado.getStatusProduto());
            return repository.save(produto);
        } else{
            throw new RuntimeException("Nenhum produto encontrado com o id " + id);
        }
    }

    public void deletarPorId(Long id){
        if(!repository.existsById(id)){
           throw new RuntimeException("Nenhum produto encontrado");
        }
        repository.deleteById(id);
    }

}

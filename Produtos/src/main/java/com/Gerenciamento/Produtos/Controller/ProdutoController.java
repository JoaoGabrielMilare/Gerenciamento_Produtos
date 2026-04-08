package com.Gerenciamento.Produtos.Controller;


import com.Gerenciamento.Produtos.Model.ProdutoModel;
import com.Gerenciamento.Produtos.Service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService Service;

    public ResponseEntity<ProdutoModel> criar(@RequestBody ProdutoModel produto){
        ProdutoModel produtonovo = Service.criarProduto(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtonovo);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoModel>> listar(){
        List<ProdutoModel> produtos = Service.listarTodos();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoModel> buscar(@PathVariable Long id){
        Optional<ProdutoModel> produto = Service.buscarPorId(id);
        if(produto.isPresent()){
            return ResponseEntity.ok(produto.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        try{
            Service.deletarPorId(id);
            return ResponseEntity.noContent().build();
        } catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoModel> atualizar(@PathVariable Long id, @RequestBody ProdutoModel produto){
        try{
            ProdutoModel produtonovo = Service.atualizarProduto(id, produto);
            return ResponseEntity.ok(produtonovo);
        } catch(Exception e){
            return ResponseEntity.notFound().build();
        }
    }
}

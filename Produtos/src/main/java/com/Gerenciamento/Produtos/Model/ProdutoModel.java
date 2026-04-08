package com.Gerenciamento.Produtos.Model;


import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "Tbl_Produtos")
public class ProdutoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOME_PRODUTO")
    private String nome;
    @Column(name = "DESCRICAO_PRODUTO")
    private String descricao;
    @Column(name = "PRECO_PRODUTO")
    private BigDecimal preco;
    @Enumerated(EnumType.STRING)
    @Column(name = "Status_PRODUTO")
    private StatusProduto statusProduto;

    public ProdutoModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public StatusProduto getStatusProduto() {
        return statusProduto;
    }

    public void setStatusProduto(StatusProduto statusProduto) {
        this.statusProduto = statusProduto;
    }
}

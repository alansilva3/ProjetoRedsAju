package com.dcomp.redsaju.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Fornecimento implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @OneToOne
    @JoinColumn(name = "fornecedor_id")
    private Fornecedor fornecedor;
    private Date data;
    private Integer quantidade;

    public Fornecimento(Integer id, Produto produto, Fornecedor fornecedor, Date data, Integer quantidade) {
        super();
        this.setId(id);
        this.produto = produto;
        this.fornecedor = fornecedor;
        this.data = data;
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Fornecimento other = (Fornecimento) obj;
        if (id == null) {
            return other.id == null;
        } else return id.equals(other.id);
    }
}

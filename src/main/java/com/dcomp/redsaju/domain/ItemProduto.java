package com.dcomp.redsaju.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class ItemProduto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer quantidade;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @ManyToMany(mappedBy = "itens")
    private List<Carrinho> carrinhos = new ArrayList<>();
    @ManyToMany(mappedBy = "itens")
    private List<Pedido> pedidos = new ArrayList<>();

    public ItemProduto() {
    }

    public ItemProduto(Integer id, Integer quantidade, Produto produto) {
        super();
        this.id = id;
        this.quantidade = quantidade;
        this.produto = produto;
    }

    public List<Carrinho> getCarrinhos() {
        return carrinhos;
    }

//	public void setCarrinho(Carrinho carrinho) {
//		this.carrinhos.add(carrinho);
//	}

    public List<Pedido> getPedidos() {
        return pedidos;
    }

//	public void setPedido(Pedido pedido) {
//		this.pedidos.add(pedido);
//	}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
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
        ItemProduto other = (ItemProduto) obj;
        if (id == null) {
            return other.id == null;
        } else return id.equals(other.id);
    }
}

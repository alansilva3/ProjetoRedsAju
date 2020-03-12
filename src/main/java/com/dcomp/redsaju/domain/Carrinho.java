package com.dcomp.redsaju.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Carrinho implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToMany
    @JoinTable(name = "CARRINHO_ITEMPRODUTO",
            joinColumns = @JoinColumn(name = "carrinho_id"),
            inverseJoinColumns = @JoinColumn(name = "itemproduto_id"))
    private List<ItemProduto> itens = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "carrinho")
    private Venda venda;

    public Carrinho() {
    }

    public Carrinho(Integer id, Cliente cliente) {
        super();
        this.id = id;
        this.cliente = cliente;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<ItemProduto> getItens() {
        return itens;
    }

    public void setItem(ItemProduto item) {
        this.itens.add(item);
    }
    
    public void removeItem(Produto p) {
    	
    	List<ItemProduto> produtos = new ArrayList<>();
  
        
        for(int i = 0; i < itens.size(); i++) {
        	ItemProduto ip = itens.get(i);
        	
        	if(!ip.getProduto().equals(p)) {
        		produtos.add(itens.get(i));
        	}
        	
        }
        
        this.itens = produtos;
    }
    
public void maisItem(Produto p) {  	
  
        
        for(int i = 0; i < itens.size(); i++) {
        	ItemProduto ip = itens.get(i);
        	
        	if(ip.getProduto().equals(p)) {
        		int novaQtd = ip.getQuantidade()+1;
        		
        		
        		ip.setQuantidade(novaQtd);
        		
        		
        	}
        	
        }
        
}

public void menosItem(Produto p) {
	
	for(int i = 0; i < itens.size(); i++) {
    	ItemProduto ip = itens.get(i);
    	
    	if(ip.getProduto().equals(p)) {
    		int novaQtd = ip.getQuantidade()-1;
    		
    		if(novaQtd <= 0) {
    			this.removeItem(p);
    		}else {
    			ip.setQuantidade(novaQtd);
    		}
    		
    	}
    	
    }
}
    
    public double getPreco() {
    	double preco = 0;
        for(int i = 0; i < this.itens.size(); i++) {
        	int quantidade = this.itens.get(i).getQuantidade();
        	double precoProduto = this.itens.get(i).getProduto().getPrecoMercado();
        	
        	preco += quantidade*precoProduto;
        }
        
        return preco;
    }
    
    public int getQuantidade() {
    	int quantidade = 0;
    	
    	for(int i = 0; i < this.itens.size(); i++) {
    		int quantidadeItem = this.itens.get(i).getQuantidade();
    		quantidade += quantidadeItem;
    	}
    	
    	return quantidade;
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
        Carrinho other = (Carrinho) obj;
        if (id == null) {
            return other.id == null;
        } else return id.equals(other.id);
    }
}

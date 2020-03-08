package com.dcomp.redsaju.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class Carrinho {

	@Id
	private Integer id;
	@ManyToMany
	@JoinTable(name = "CARRINHO_ITEMPRODUTO", 
			joinColumns = @JoinColumn(name = "carrinho_id"),
			inverseJoinColumns = @JoinColumn(name = "itemproduto_id"))
	private List<ItemProduto> itens = new ArrayList<>();
	
	@OneToOne
	@JoinColumn(name = "cliente_id")
	@MapsId
	private Cliente cliente;
	
	public Carrinho() {
	}

	public Carrinho(Integer id, Cliente cliente) {
		super();
		this.id = id;
		this.cliente = cliente;
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
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}

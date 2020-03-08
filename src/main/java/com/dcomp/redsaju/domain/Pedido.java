package com.dcomp.redsaju.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Pedido implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "funcionario_id")
	private Funcionario funcionario;
	
	@ManyToMany
	@JoinTable(name = "PEDIDO_ITEMPRODUTO", 
			joinColumns = @JoinColumn(name = "pedido_id"),
			inverseJoinColumns = @JoinColumn(name = "itemproduto_id"))
	private List<ItemProduto> itens = new ArrayList<>();
	
	public Pedido() {
	}

	public Pedido(Integer id, Funcionario funcionario) {
		super();
		this.id = id;
		this.funcionario = funcionario;
	}

	public List<ItemProduto> getItens() {
		return itens;
	}

	public void setItem(ItemProduto item) {
		this.itens.add(item);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
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
		Pedido other = (Pedido) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}

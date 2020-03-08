package com.dcomp.redsaju.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.dcomp.redsaju.domain.enums.StatusPag;
import com.dcomp.redsaju.domain.enums.TipoPagamento;

@Entity
public class PagamentoCompra implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date data;
	private Date hora;
	private TipoPagamento tipoPagamento;
	private StatusPag status;
	
	
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy = "pagamentoCompra")
	private NotaFiscalCompra notaFiscalCompra;

	public PagamentoCompra() {
	}
	public PagamentoCompra(Integer id, Date data, Date hora, TipoPagamento tipoPagamento, StatusPag status) {
		super();
		this.id = id;
		this.data = data;
		this.hora = hora;
		this.setTipoPagamento(tipoPagamento);
		this.status = status;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}

	public Date getHora() {
		return hora;
	}
	public void setHora(Date hora) {
		this.hora = hora;
	}
	
	public TipoPagamento getTipoPagamento() {
		return tipoPagamento;
	}
	public void setTipoPagamento(TipoPagamento tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}
	
	public StatusPag getStatus() {
		return status;
	}
	public void setStatus(StatusPag status) {
		this.status = status;
	}

	public NotaFiscalCompra getNotaFiscal() {
		return notaFiscalCompra;
	}
	public void setNotaFiscal(NotaFiscalCompra notaFiscalCompra) {
		this.notaFiscalCompra = notaFiscalCompra;
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
		PagamentoCompra other = (PagamentoCompra) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}

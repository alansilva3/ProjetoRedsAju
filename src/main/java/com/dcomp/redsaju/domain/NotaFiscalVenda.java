package com.dcomp.redsaju.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class NotaFiscalVenda implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "pagamento_id")
    private PagamentoVenda pagamentoVenda;

    public NotaFiscalVenda() {
    }

    public NotaFiscalVenda(Integer id, PagamentoVenda pagamentoVenda) {
        super();
        this.id = id;
        this.pagamentoVenda = pagamentoVenda;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PagamentoVenda getPagamento() {
        return pagamentoVenda;
    }

    public void setPagamento(PagamentoVenda pagamentoVenda) {
        this.pagamentoVenda = pagamentoVenda;
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
        NotaFiscalVenda other = (NotaFiscalVenda) obj;
        if (id == null) {
            return other.id == null;
        } else return id.equals(other.id);
    }
}

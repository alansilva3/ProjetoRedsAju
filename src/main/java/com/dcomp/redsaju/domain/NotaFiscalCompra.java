package com.dcomp.redsaju.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class NotaFiscalCompra implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "pagamento_id")
    private PagamentoCompra pagamentoCompra;

    public NotaFiscalCompra() {
    }

    public NotaFiscalCompra(Integer id, PagamentoCompra pagamentoCompra) {
        super();
        this.id = id;
        this.pagamentoCompra = pagamentoCompra;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PagamentoCompra getPagamento() {
        return pagamentoCompra;
    }

    public void setPagamento(PagamentoCompra pagamentoCompra) {
        this.pagamentoCompra = pagamentoCompra;
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
        NotaFiscalCompra other = (NotaFiscalCompra) obj;
        if (id == null) {
            return other.id == null;
        } else return id.equals(other.id);
    }
}

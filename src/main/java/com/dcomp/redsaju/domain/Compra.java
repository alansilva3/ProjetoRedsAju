package com.dcomp.redsaju.domain;

import com.dcomp.redsaju.domain.enums.Status;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Compra implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date data;
    private Date hora;
    private Status status;

    @OneToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    public Compra() {
    }

    public Compra(Integer id, Date data, Date hora, Status status, Pedido pedido) {
        super();
        this.id = id;
        this.data = data;
        this.hora = hora;
        this.status = status;
        this.pedido = pedido;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
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
        Compra other = (Compra) obj;
        if (id == null) {
            return other.id == null;
        } else return id.equals(other.id);
    }
}

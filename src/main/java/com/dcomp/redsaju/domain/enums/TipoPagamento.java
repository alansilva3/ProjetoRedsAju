package com.dcomp.redsaju.domain.enums;

public enum TipoPagamento {

    BOLETO,
    CARTAO;

    public static TipoPagamento getByCodigo(Integer cod) {
        if (cod == null)
            return null;
        for (TipoPagamento e : TipoPagamento.values()) {
            if (e.ordinal() == cod)
                return e;
        }
        return null;
    }
}

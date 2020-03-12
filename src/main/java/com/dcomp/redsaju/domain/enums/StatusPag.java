package com.dcomp.redsaju.domain.enums;

public enum StatusPag {

    PENDENTE,
    CONFIRMADO,
    RECUSADO;

    public static StatusPag getByCodigo(Integer cod) {
        if (cod == null)
            return null;
        for (StatusPag e : StatusPag.values()) {
            if (e.ordinal() == cod)
                return e;
        }
        return null;
    }
}

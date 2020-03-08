package com.dcomp.redsaju.domain.enums;

public enum Status {

	PENDENTE,
	CONCLUIDO;
	
	public static Status getByCodigo(Integer cod){
		if (cod == null)
			return null;
		for (Status e : Status.values()){
			if (e.ordinal() == cod)
				return e;
		}
		return null;
	}
}

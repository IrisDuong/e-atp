package com.eatp.common.service;

public interface CustomDataConverter<E,D> {

	D buildDTOFromEntity(E e);
	E buildEntityFromDto(D d);
}

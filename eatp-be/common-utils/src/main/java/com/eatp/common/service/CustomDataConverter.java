package com.eatp.common.service;

public interface CustomDataConverter<E,D> {

	D convertToDto(E e);
	E convertToEntity(D d);
}

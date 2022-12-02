package com.kodlamaio.bootcamp.core.mapping;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {

	ModelMapper forRequest();
	ModelMapper forResponse();
}

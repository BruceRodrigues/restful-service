package br.test.restful.service.conversor.api;

public interface IService<RETURN_TYPE> {

	RETURN_TYPE convertDollarToReal();

	RETURN_TYPE convertDollarToRealFromInput(Double d);

	RETURN_TYPE createResponse(String result);
}

package br.test.restful.service.conversor;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.test.restful.service.conversor.api.IService;

@Path("/rtodconversor")
public class RToDConversorService implements IService<String> {

	private final Double REAL = 3.09434663;

	@Override
	@GET
	@Produces("application/xml")
	public String convertDollarToReal() {

		String result = "@Produces(\"application/xml\") Output: "
				+ "\n 1 dollar = " + this.REAL + " reais";
		return this.createResponse("<real>" + this.REAL + "</real>"
				+ "<output>" + result + "</output>");
	}

	@Override
	@Path("{d}")
	@GET
	@Produces("application/xml")
	public String convertDollarToRealFromInput(@PathParam("d") Double d) {
		Double reais = d * this.REAL;
		String result = "@Produces(\"application/xml\") Output: "
				+ "\n Dollar to real: ";
		return this.createResponse("<real>" + reais + "</real> " + "<output>"
				+ result + "</output>");

	}

	@Override
	public String createResponse(String result) {
		return "<rtodconversorservice>" + result + "</rtodconversorservice>";
	}

}

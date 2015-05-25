package br.test.restful.service.conversor;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/rtodconversor")
public class RToDConversorService {

	private final Double REAL = 3.09434663;

	@GET
	@Produces("application/xml")
	public String convertDollarToReal() {

		String result = "@Produces(\"application/xml\") Output: "
				+ "\n 1 dollar = " + this.REAL + " reais";
		return "<rtodconversorservice>" + "<real>" + this.REAL + "</real>"
		+ "<output>" + result + "</output>" + "</rtodconversorservice>";
	}

	@Path("{d}")
	@GET
	@Produces("application/xml")
	public String convertDollarToRealFromInput(@PathParam("d") Double d) {
		Double reais = d * this.REAL;
		String result = "@Produces(\"application/xml\") Output: "
				+ "\n Dollar to real: ";
		return "<rtodconversorservice>" + "<real>" + reais + "</real> "
		+ "<output>" + result + "</output>" + "</rtodconversorservice>";

	}

}

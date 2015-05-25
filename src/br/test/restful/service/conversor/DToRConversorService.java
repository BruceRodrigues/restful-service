package br.test.restful.service.conversor;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.json.JSONException;
import org.json.JSONObject;

@Path("/dtorconversor")
public class DToRConversorService {

	private final Double REAL = 3.09434663;

	@GET
	@Produces("application/json")
	public Response convertDollarToReal() throws JSONException {

		JSONObject obj = new JSONObject();

		obj.put("R Value", this.REAL);
		obj.put("D Value", 1);

		String result = "@Produces(\"application/json\") Output: " + obj;
		return this.createResponse(result);
	}

	@Path("{d}")
	@GET
	@Produces("application/json")
	public Response convertDollarToRealFromInput(@PathParam("d") Double d)
			throws JSONException {
		JSONObject obj = new JSONObject();
		Double reais = d * this.REAL;
		obj.put("R Value", reais);
		obj.put("D Value", d);

		String result = "@Produces(\"application/json\") Output: "
				+ "\n Dollar to real: " + obj;
		return this.createResponse(result);
	}

	private Response createResponse(String result) {
		return Response.status(200).entity(result).build();
	}

}

package com.phamluu.ws;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.phamluu.entity.Product;

@RestController
public class JSONService {

	
	@RequestMapping(value="/getProductInJSON", method=RequestMethod.GET )
	@Produces("application/json")
	// working
	public Product getProductInJSON() {

		Product product = new Product();
		product.setName("iPad 3");
		product.setQty(999);

		return product;

	}

	@Consumes("application/json")
	@RequestMapping(value="/postProductInJSON", method=RequestMethod.POST )
	public Response createProductInJSON(Product product) {

		String result = "Product created : " + product;
		return Response.status(201).entity(result).build();

	}

}
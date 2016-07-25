package com.thoughtworks.ketsu.web;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;


@Path("products")
public class ProductApi {

//  @Context
//  ProductRepository productRepository;

  @POST
  public Response createProduct() {
    return Response.status(201).build();
  }
}

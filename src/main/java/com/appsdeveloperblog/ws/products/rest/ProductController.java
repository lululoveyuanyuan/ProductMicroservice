package com.appsdeveloperblog.ws.products.rest;
// This package declaration places the controller class within the
// com.appsdeveloperblog.ws.products package, helping organize related classes.

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.appsdeveloperblog.ws.products.service.ProductService;
// Imports necessary classes and annotations:
// - HttpStatus: Provides HTTP status codes like 200 (OK), 201 (CREATED), etc.
// - ResponseEntity: A flexible way to build HTTP responses by setting status, headers, and body.
// - PostMapping, RequestBody, RequestMapping, RestController: Annotations from Spring MVC
//   to define controllers, map endpoints to methods, and process request bodies.

@RestController
@RequestMapping("/products") // Base URL path: http://localhost:<port>/products
// @RestController: Marks this class as a REST controller, meaning methods return
// data (e.g., JSON) rather than rendering a view.
// @RequestMapping("/products"): Specifies that all request mappings in this class
// start with "/products", making it the base path for this controller.

public class ProductController {
    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    // @PostMapping: This annotation maps HTTP POST requests to this method.
    // Since no additional path is specified, the endpoint is POST http://localhost:<port>/products.

    public ResponseEntity<String> createProduct(@RequestBody CreateProductRestModel product) {
        // @RequestBody: Maps the JSON in the request body to a CreateProductRestModel instance.
        // 'product' is the object representing the incoming product data sent by the client.
        // The method returns ResponseEntity<String>, allowing us to set both the response
        // status code and body. Returning a status of 201 (CREATED) indicates the
        // resource was successfully created on the server.
        // body("") sets the response body as an empty string. In a real scenario, you might
        // return the created product's details or ID.
        String productId = productService.createProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(productId); // 201 means resource created
    }

}

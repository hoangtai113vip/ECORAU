package com.example.demo.Rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.ProductService;
import com.example.demo.model.Product;

@RestController
@RequestMapping("/product")
public class ProductRestController {
	
	@Autowired
	ProductService pro;
	
	@GetMapping("")
	public List<Product> getAll(){
		
		return pro.getAll();
		
	}
	@GetMapping("/{id}")
	public Product getOne(@PathVariable int id ) {
		Product product = pro.getOne(id);
		if(product==null) {
			throw new BanHangException("product not exist");
		}
		return product;
	}
	@PostMapping("")
	public Product add(@RequestBody Product product) {
		product.setProductId(0);
		pro.add(product);
		return product;
	}
	@PutMapping("")
	public Product update(@RequestBody Product product)
	{
		pro.update(product);
		return product;
	}
	
	@DeleteMapping("/{id}")
	public String delete(int id)
	{
		Product product = pro.getOne(id);
		if(product==null) {
			throw new BanHangException("product not exist");
			
		}
		pro.delete(id);
		return "delete success";
	}


}

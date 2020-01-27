package project.dao;

import java.util.List;

import project.model.Product;

public interface ProductDAO {
	
	void addproductDetails(Product product) throws Exception;
	void deleteproductDetails(Product product) throws Exception;
	List<Product> Displayproduct()throws Exception;
	void updateproduct(Product product) throws Exception;
}

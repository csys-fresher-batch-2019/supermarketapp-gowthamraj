package project.dao;

import java.util.List;

import exception.DbException;
import project.model.Product;

public interface ProductDAO {
	
	void addproductDetails(Product product) throws DbException;
	void deleteproductDetails(Product product) throws DbException;
	List<Product> displayproduct()throws DbException;
	void updateproduct(Product product) throws DbException;
	int getProductPrice(int productId) throws DbException;
}

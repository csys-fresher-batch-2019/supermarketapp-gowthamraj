package com.chainsys.supermarketapp.dao;

import java.util.List;

import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.model.Product;

public interface ProductDAO {
	
	void addproductDetails(Product product) throws DbException;
	void deleteproductDetails(Product product) throws DbException;
	List<Product> displayproduct()throws DbException;
	void updateproduct(Product product) throws DbException;
	int getProductPrice(int productId) throws DbException;
}

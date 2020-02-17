package com.chainsys.supermarketapp.dao;

import java.util.List;

import com.chainsys.supermarketapp.exception.DbException;
import com.chainsys.supermarketapp.model.ProductStock;

public interface ProductStockDAO {
	void addProductStock(ProductStock productstock )throws DbException;
	void deleteProductStock(ProductStock productstock )throws DbException;
	void updateProductStock(ProductStock productstock )throws DbException;

	List<ProductStock> displayProductStock() throws DbException;
	void updateProductStock1(ProductStock productstock) throws DbException;



}

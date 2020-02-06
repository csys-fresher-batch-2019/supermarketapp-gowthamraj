package project.dao;

import exception.DbException;
import project.model.ProductStock;

public interface ProductStockDAO {
	void addProductStock(ProductStock productstock )throws DbException;
	void deleteProductStock(ProductStock productstock )throws DbException;
	void updateProductStock(ProductStock productstock )throws DbException;
	void displayProductStock(ProductStock productstock )throws DbException;



}

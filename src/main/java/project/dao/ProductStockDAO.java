package project.dao;

import project.model.ProductStock;

public interface ProductStockDAO {
	void addProductStock(ProductStock productstock )throws Exception;
	void deleteProductStock(ProductStock productstock )throws Exception;
	void updateProductStock(ProductStock productstock )throws Exception;
	void displayProductStock(ProductStock productstock )throws Exception;



}

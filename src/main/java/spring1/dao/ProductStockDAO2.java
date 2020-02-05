package spring1.dao;

import java.util.List;

import project.model.ProductStock;

public interface ProductStockDAO2 {
	void addproductDetails(ProductStock product) throws Exception;
	void deleteproductDetails(ProductStock product) throws Exception;
	List<ProductStock> displayproduct()throws Exception;
	void updateproduct(ProductStock product) throws Exception;


}

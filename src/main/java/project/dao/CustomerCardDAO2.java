package project.dao;
import java.util.List;
import project.model.customerCard;

public interface CustomerCardDAO2 {
	void addCustomerCardtDetails(customerCard cc) throws Exception;
	void deleteCustomerCardDetails(customerCard cc) throws Exception;
	List<customerCard> DisplayCustomerCardDetails()throws Exception;
	void updateCustomerCard(customerCard cc) throws Exception;


}

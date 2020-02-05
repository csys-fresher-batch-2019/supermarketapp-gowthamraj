package spring1.dao;
import java.util.List;
import project.model.customerCard;

public interface CustomerCardDAO2 {
	void addCustomerCardtDetails(customerCard cc) throws Exception;
	void deleteCustomerCardDetails(customerCard cc) throws Exception;
	List<customerCard> displayCustomerCardDetails()throws Exception;
	void updateCustomerCard(customerCard cc) throws Exception;


}

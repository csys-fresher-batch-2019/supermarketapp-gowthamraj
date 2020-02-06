package spring1.dao;
import java.util.List;
import project.model.CustomerCard;

public interface CustomerCardDAO2 {
	void addCustomerCardtDetails(CustomerCard cc) throws Exception;
	void deleteCustomerCardDetails(CustomerCard cc) throws Exception;
	List<CustomerCard> displayCustomerCardDetails()throws Exception;
	void updateCustomerCard(CustomerCard cc) throws Exception;


}

package project.dao;

import project.model.customerCard;

public interface CustomerCardDAO
{
public void addCustomerCard(customerCard customercard) throws Exception;
public void deleteCustomerCard(customerCard customercard)throws Exception;
public void displayCustomerCard(customerCard customercard)throws Exception;
public void updateCustomerCard(customerCard customercard)throws Exception;

}

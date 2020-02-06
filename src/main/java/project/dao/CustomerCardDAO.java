package project.dao;

import exception.DbException;
import project.model.customerCard;

public interface CustomerCardDAO
{
public void addCustomerCard(customerCard customercard) throws DbException;
public void deleteCustomerCard(customerCard customercard)throws DbException;
public void displayCustomerCard(customerCard customercard)throws DbException;
public void updateCustomerCard(customerCard customercard)throws DbException;

}

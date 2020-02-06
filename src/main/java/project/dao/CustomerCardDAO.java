package project.dao;

import exception.DbException;
import project.model.CustomerCard;

public interface CustomerCardDAO
{
public void addCustomerCard(CustomerCard customercard) throws DbException;
public void deleteCustomerCard(CustomerCard customercard)throws DbException;
public void displayCustomerCard(CustomerCard customercard)throws DbException;
public void updateCustomerCard(CustomerCard customercard)throws DbException;

}

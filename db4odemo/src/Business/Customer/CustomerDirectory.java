/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Customer;

import Business.DeliveryMan.DeliveryMan;

import java.util.ArrayList;

/**
 *
 * @author harold
 */
public class CustomerDirectory {
    ArrayList<Customer> customerArrayList;

    public CustomerDirectory() {
        this.customerArrayList = new ArrayList<>();
    }

    public ArrayList<Customer> getCustomerArrayList() {
        return customerArrayList;
    }

    public void setCustomerArrayList(ArrayList<Customer> customerArrayList) {
        this.customerArrayList = customerArrayList;
    }

    public Customer createCustomer(String name){
        Customer customer =new Customer();
        customer.setName(name);
        customerArrayList.add(customer);
        return customer;
    }
}

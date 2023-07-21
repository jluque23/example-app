package org.vaadin.exampleapp.business.service;

import org.vaadin.exampleapp.business.model.Customer;

import java.util.List;

public interface ICustomerService {
    public List<Customer> findAll();

    public Customer save(Customer customer);

    public Customer findById(Long id);

    public void delete(Long id);
}

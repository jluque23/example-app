package org.vaadin.exampleapp.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vaadin.exampleapp.business.model.Customer;

public interface ICustomerDao extends JpaRepository<Customer, Long> {

}

package org.vaadin.exampleapp.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vaadin.exampleapp.business.model.Company;

public interface ICompanyDao extends JpaRepository<Company, Long> {

}

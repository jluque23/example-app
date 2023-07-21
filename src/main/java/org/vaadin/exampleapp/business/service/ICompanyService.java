package org.vaadin.exampleapp.business.service;

import java.util.List;

import org.vaadin.exampleapp.business.model.Company;

public interface ICompanyService {
    public List<Company> findAllCompany();
    
}

package org.vaadin.exampleapp.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vaadin.exampleapp.business.model.Company;
import org.vaadin.exampleapp.business.repository.ICompanyDao;
import org.vaadin.exampleapp.business.service.ICompanyService;

@Service
public class CompanyServiceImpl implements ICompanyService {

    @Autowired
    private ICompanyDao companyDao;

    @Override
    public List<Company> findAllCompany() {
        return companyDao.findAll();
    }

}

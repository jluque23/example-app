package org.vaadin.exampleapp.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vaadin.exampleapp.business.model.Status;
import org.vaadin.exampleapp.business.repository.IStatusDao;
import org.vaadin.exampleapp.business.service.IStatusService;

@Service
public class StatusServiceImpl implements IStatusService {

    @Autowired
    private IStatusDao statusDao;

    @Override
    public List<Status> findAllStatus() {
        return statusDao.findAll();
    }

}

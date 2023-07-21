package org.vaadin.exampleapp.business.service;

import java.util.List;

import org.vaadin.exampleapp.business.model.Status;

public interface IStatusService {
    public List<Status> findAllStatus();
}

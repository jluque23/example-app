package org.vaadin.exampleapp.business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vaadin.exampleapp.business.model.Status;

public interface IStatusDao extends JpaRepository<Status, Long> {

}

package org.vaadin.exampleapp.business.service;

import java.util.List;

import org.vaadin.exampleapp.business.model.Contact;

public interface IContactService {
    public List<Contact> findAllContacts(String stringFilter);
    public Long countContacts();
    public void saveContact(Contact contact);
    public void deleteContact(Long id);
}

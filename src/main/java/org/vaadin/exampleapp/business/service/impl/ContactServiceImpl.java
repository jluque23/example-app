package org.vaadin.exampleapp.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vaadin.exampleapp.business.model.Contact;
import org.vaadin.exampleapp.business.repository.IContactDao;
import org.vaadin.exampleapp.business.service.IContactService;

@Service
public class ContactServiceImpl implements IContactService {

    @Autowired
    private IContactDao contactDao;

    @Override
    public List<Contact> findAllContacts(String stringFilter) {

        if (stringFilter == null || stringFilter.isEmpty()) {
            return contactDao.findAll();
        } else {
            return contactDao.search(stringFilter);
        }
    }

    @Override
    public Long countContacts() {
        return contactDao.count();
    }

    @Override
    public void saveContact(Contact contact) {
        if (contact == null) {
            System.err.println("Contact is null.");
            return;
        }
        contactDao.save(contact);
    }

    @Override
    public void deleteContact(Long id) {
        contactDao.deleteById(id);
    }

}

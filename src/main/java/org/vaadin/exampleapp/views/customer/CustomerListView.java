package org.vaadin.exampleapp.views.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.exampleapp.business.model.Contact;
import org.vaadin.exampleapp.business.service.ICompanyService;
import org.vaadin.exampleapp.business.service.IContactService;
import org.vaadin.exampleapp.business.service.IStatusService;
import org.vaadin.exampleapp.views.layout.MainLayout;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "", layout = MainLayout.class)
@PageTitle("Contacts")
public class CustomerListView extends VerticalLayout {
    Grid<Contact> grid = new Grid<>(Contact.class);
    TextField filterText = new TextField();
    CustomerForm customerForm;

    @Autowired
    private ICompanyService companyService;
    @Autowired
    private IStatusService statusService;
    @Autowired
    private IContactService contactService;

    public CustomerListView(ICompanyService companyService, IStatusService statusService,IContactService contactService) {
        this.companyService = companyService;
        this.statusService = statusService;
        this.contactService = contactService;

        addClassName("customer-list-view");
        setSizeFull();
        configureGrid();
        configureForm();

        add(getToolbar(), getContent());
        updateList();
        closeEditor();
    }

    private void updateList() {
        grid.setItems(contactService.findAllContacts(filterText.getValue()));
    }

    private void configureGrid() {
        grid.addClassNames("customer-grid");
        grid.setSizeFull();
        grid.setColumns("firstName", "lastName", "email");
        grid.addColumn(contact -> contact.getStatus().getName()).setHeader("Status");
        grid.addColumn(contact -> contact.getCompany().getName()).setHeader("Company");
        grid.getColumns().forEach(col -> col.setAutoWidth(true));

        grid.asSingleSelect().addValueChangeListener(event -> editContact(event.getValue()));
    }

    public void editContact(Contact contact) { 
        if (contact == null) {
            closeEditor();
        } else {
            customerForm.setContact(contact);
            customerForm.setVisible(true);
            addClassName("editing");
        }
    }

    private void closeEditor() {
        customerForm.setContact(null);
        customerForm.setVisible(false);
        removeClassName("editing");
    }

    private void addContact() { 
        grid.asSingleSelect().clear();
        editContact(new Contact());
    }

    private HorizontalLayout getToolbar() {
        filterText.setPlaceholder("Filter by name...");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);
        filterText.addValueChangeListener(e -> updateList());

        Button addContactButton = new Button("Add contact");
        addContactButton.addClickListener(click -> addContact());

        var toolbar = new HorizontalLayout(filterText, addContactButton);
        toolbar.addClassName("toolbar");
        return toolbar;
    }

    private Component getContent() {
        HorizontalLayout content = new HorizontalLayout(grid, customerForm);
        content.setFlexGrow(2, grid); 
        content.setFlexGrow(1, customerForm);
        content.addClassNames("content");
        content.setSizeFull();
        return content;
    }

    private void configureForm() {
        customerForm = new CustomerForm(companyService.findAllCompany(),statusService.findAllStatus());
        customerForm.setWidth("25em");
        customerForm.addSaveListener(this::saveContact); 
        customerForm.addDeleteListener(this::deleteContact); 
        customerForm.addCloseListener(e -> closeEditor()); 
    }

    private void saveContact(CustomerForm.SaveEvent event) {
        contactService.saveContact(event.getContact());
        updateList();
        closeEditor();
    }
    
    private void deleteContact(CustomerForm.DeleteEvent event) {
        contactService.deleteContact(event.getContact().getId());
        updateList();
        closeEditor();
    }
}

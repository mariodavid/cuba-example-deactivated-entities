package com.rtcab.cede.web.customer;

import com.haulmont.cuba.gui.components.Table;
import com.haulmont.cuba.gui.screen.*;
import com.rtcab.cede.entity.Customer;
import com.rtcab.cede.entity.Order;
import com.rtcab.cede.entity.WithInactivityOption;
import com.rtcab.cede.web.WithInactivityOptionSupport;

import javax.inject.Inject;

@UiController("cede_Customer.edit")
@UiDescriptor("customer-edit.xml")
@EditedEntityContainer("customerDc")
@LoadDataBeforeShow
public class CustomerEdit extends StandardEditor<Customer> implements WithInactivityOptionSupport {

    @Inject
    protected Table<Order> ordersTable;


    @Override
    public WithInactivityOption getEditedEntityWithInactivityOption() {
        return getEditedEntity();
    }

}
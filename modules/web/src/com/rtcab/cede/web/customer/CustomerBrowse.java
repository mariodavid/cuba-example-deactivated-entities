package com.rtcab.cede.web.customer;

import com.haulmont.cuba.gui.components.Action;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.icons.CubaIcon;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import com.rtcab.cede.entity.Customer;

import javax.inject.Inject;

@UiController("cede_Customer.browse")
@UiDescriptor("customer-browse.xml")
@LookupComponent("customersTable")
@LoadDataBeforeShow
public class CustomerBrowse extends StandardLookup<Customer> {

    @Inject
    protected CollectionContainer<Customer> customersDc;


    private boolean activeFilterState = true;

    @Inject
    protected Button toggleInactiveBtn;

    @Inject
    protected CollectionLoader<Customer> customersDl;

    @Inject
    protected MessageBundle messageBundle;

    @Subscribe
    protected void onInit(InitEvent event) {
        activateActiveFilter();
        renderShowInactiveButton();
    }
    
    

    @Subscribe("customersTable.toggleDeactivatable")
    protected void onCustomersTableToggleDeactivatable(Action.ActionPerformedEvent event) {

        if (!activeFilterState) {
            activateActiveFilter();
            toggleActiveFilterState();
            renderShowInactiveButton();
        }
        else {
            deactivateActiveFilter();
            toggleActiveFilterState();
            renderHideInactiveButton();
        }

        customersDl.load();
    }

    private void deactivateActiveFilter() {
        customersDl.removeParameter("showActive");
    }

    private void renderHideInactiveButton() {
        toggleInactiveBtn.setCaption(messageBundle.formatMessage("hideInactive"));
        toggleInactiveBtn.setIconFromSet(CubaIcon.EYE_SLASH);
    }

    private void renderShowInactiveButton() {
        toggleInactiveBtn.setCaption(messageBundle.formatMessage("showInactive"));
        toggleInactiveBtn.setIconFromSet(CubaIcon.EYE);
    }

    private void toggleActiveFilterState() {
        activeFilterState = !activeFilterState;
    }

    private void activateActiveFilter() {
        customersDl.setParameter("showActive", true);
    }

}
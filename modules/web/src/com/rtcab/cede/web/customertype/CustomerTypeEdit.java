package com.rtcab.cede.web.customertype;

import com.haulmont.cuba.gui.screen.*;
import com.rtcab.cede.entity.CustomerType;
import com.rtcab.cede.entity.WithInactivityOption;
import com.rtcab.cede.web.WithInactivityOptionSupport;

@UiController("cede_CustomerType.edit")
@UiDescriptor("customer-type-edit.xml")
@EditedEntityContainer("customerTypeDc")
@LoadDataBeforeShow
public class CustomerTypeEdit extends StandardEditor<CustomerType> implements WithInactivityOptionSupport {

    @Override
    public WithInactivityOption getEditedEntityWithInactivityOption() {
        return getEditedEntity();
    }
}
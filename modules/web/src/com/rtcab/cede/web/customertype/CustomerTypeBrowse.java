package com.rtcab.cede.web.customertype;

import com.haulmont.cuba.gui.screen.*;
import com.rtcab.cede.entity.CustomerType;

@UiController("cede_CustomerType.browse")
@UiDescriptor("customer-type-browse.xml")
@LookupComponent("customerTypesTable")
@LoadDataBeforeShow
public class CustomerTypeBrowse extends StandardLookup<CustomerType> {


}
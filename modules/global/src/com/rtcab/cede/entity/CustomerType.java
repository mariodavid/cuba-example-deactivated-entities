package com.rtcab.cede.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.chile.core.annotations.NamePattern;
import javax.validation.constraints.NotNull;

@NamePattern("%s|name")
@Table(name = "CEDE_CUSTOMER_TYPE")
@Entity(name = "cede_CustomerType")
public class CustomerType extends StandardEntity implements WithInactivityOption {
    private static final long serialVersionUID = -2326044218258846480L;

    @Column(name = "CODE")
    protected String code;

    @Column(name = "NAME")
    protected String name;

    @NotNull
    @Column(name = "ACTIVE", nullable = false)
    protected Boolean active = false;

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public Boolean getActive() {
        return active;
    }


    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
package com.rtcab.cede.entity;

import com.haulmont.chile.core.annotations.Composition;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.OnDelete;
import com.haulmont.cuba.core.global.DeletePolicy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@NamePattern("%s|name")
@Table(name = "CEDE_CUSTOMER")
@Entity(name = "cede_Customer")
public class Customer extends StandardEntity implements WithInactivityOption {
    private static final long serialVersionUID = 786517995673282123L;

    @Column(name = "NAME")
    protected String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TYPE_ID")
    protected CustomerType type;

    @NotNull
    @Column(name = "ACTIVE", nullable = false)
    protected Boolean active = false;

    @Composition
    @OnDelete(DeletePolicy.CASCADE)
    @OneToMany(mappedBy = "customer")
    protected List<Order> orders;

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public Boolean getActive() {
        return active;
    }


    public void setType(CustomerType type) {
        this.type = type;
    }

    public CustomerType getType() {
        return type;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
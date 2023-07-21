package org.vaadin.exampleapp.business.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "membershipType")
public class MembershipType extends AbstractEntity {
    
    @NotNull
    private String membershipTypeOf;

    private String description;

    @NotNull
    private String duration;

    @NotNull
    private String price;

    private String accessToFacilities;

    public String getMembershipTypeOf() {
        return membershipTypeOf;
    }

    public void setMembershipType(String membershipTypeOf) {
        this.membershipTypeOf = membershipTypeOf;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getAccessToFacilities() {
        return accessToFacilities;
    }

    public void setAccessToFacilities(String accessToFacilities) {
        this.accessToFacilities = accessToFacilities;
    }

    
}

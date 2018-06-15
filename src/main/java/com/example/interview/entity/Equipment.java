package com.example.interview.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Entity
public class Equipment extends BaseEntity {

    @NotNull
    @Size(min = 1, max = 255)
    private String type;

    @NotNull
    private boolean toFix;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @OrderColumn(name = "id")
    private List<EquipmentParameter> properties;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @OrderColumn(name = "id")
    private List<EquipmentComment> comments;

    public Equipment() {
    }

    public Equipment(String type, boolean toFix, List<EquipmentParameter> propeties, List<EquipmentComment> comments) {
        this.type = type;
        this.toFix = toFix;
        this.properties = propeties;
        this.comments = comments;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isToFix() {
        return toFix;
    }

    public void setToFix(boolean toFix) {
        this.toFix = toFix;
    }

    public List<EquipmentParameter> getProperties() {
        return properties;
    }

    public void setPropeties(List<EquipmentParameter> properties) {
        this.properties = properties;
    }

    public List<EquipmentComment> getComments() {
        return comments;
    }

    public void setComments(List<EquipmentComment> comments) {
        this.comments = comments;
    }

}

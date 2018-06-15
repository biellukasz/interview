package com.example.interview.entity;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class EquipmentComment extends BaseEntity {


    @NotNull
    private String equipmentUUID;

    @NotNull
    @Size(min = 1, max = 255)
    private String comment;

    public EquipmentComment() {
    }

    public EquipmentComment(@NotNull String equipmentUUID, @NotNull @Size(min = 1, max = 255) String comment) {
        this.equipmentUUID = equipmentUUID;
        this.comment = comment;
    }

    public String getEquipmentUUID() {
        return equipmentUUID;
    }

    public void setEquipmentUUID(String equipmentUUID) {
        this.equipmentUUID = equipmentUUID;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

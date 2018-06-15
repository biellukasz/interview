package com.example.interview.entity;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class EquipmentParameter extends BaseEntity {

    @NotNull
    private String equipmentUUID;

    @NotNull
    private String parameterName;

    @NotNull
    private String parameterValue;

    public EquipmentParameter() {
    }

    public EquipmentParameter(@NotNull String equipmentUUID, @NotNull @Size(min = 1, max = 255) String parameterName, @NotNull @Size(min = 1, max = 255) String parameterValue) {
        this.equipmentUUID = equipmentUUID;
        this.parameterName = parameterName;
        this.parameterValue = parameterValue;
    }

    public String getEquipmentUUID() {
        return equipmentUUID;
    }

    public void setEquipmentUUID(String equipmentUUID) {
        this.equipmentUUID = equipmentUUID;
    }

    public String getParameterName() {
        return parameterName;
    }

    public void setParameterName(String parameterName) {
        this.parameterName = parameterName;
    }

    public String getParameterValue() {
        return parameterValue;
    }

    public void setParameterValue(String parameterValue) {
        this.parameterValue = parameterValue;
    }
}

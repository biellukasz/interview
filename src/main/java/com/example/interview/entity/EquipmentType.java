package com.example.interview.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class EquipmentType {
    public static final String TV = "TV";
    public static final String LAPTOP = "LAPTOP";
    public static final String FRIDGE = "FRIDGE";
    public static final String MOBILE_PHONE = "MOBILE_PHONE";
    public static final String WASHER = "WASHER";
    public static final String ELECTRIC_SHAVER = "ELECTRIC_SHAVER";

    public List<String> getAllTypes(){
        List<String> types = new ArrayList<>();
        Stream.of(EquipmentType.ELECTRIC_SHAVER,EquipmentType.FRIDGE,EquipmentType.MOBILE_PHONE,EquipmentType.WASHER,EquipmentType.TV,EquipmentType.LAPTOP)
                .forEach(eqType ->types.add(eqType));
        return types;
    }
}

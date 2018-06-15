package com.example.interview.controller;

import com.example.interview.entity.Equipment;
import com.example.interview.entity.EquipmentComment;
import com.example.interview.entity.EquipmentParameter;
import com.example.interview.entity.EquipmentType;
import com.example.interview.repository.EquipmentCommentRepo;
import com.example.interview.repository.EquipmentParameterRepo;
import com.example.interview.repository.EquipmentRepo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(EquipmentController.class)
public class EquipmentControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EquipmentRepo equipmentRepo;

    @MockBean
    private EquipmentParameterRepo equipmentParameterRepo;

    @MockBean
    private EquipmentCommentRepo equipmentCommentRepo;


    @Before
    public void setUp() throws Exception {
        Equipment equipment1 = new Equipment();
        equipment1.setType(EquipmentType.FRIDGE);
        equipment1.setToFix(true);

        List<EquipmentParameter> parameters1 = new ArrayList<>();
        parameters1.add(new EquipmentParameter(equipment1.getUuid(),"name","beko"));
        parameters1.add(new EquipmentParameter(equipment1.getUuid(),"owner","kris"));
        equipment1.setPropeties(parameters1);

        List<EquipmentComment> comments1 = new ArrayList<>();
        comments1.add(new EquipmentComment(equipment1.getUuid(),"ready to ship"));
        comments1.add(new EquipmentComment(equipment1.getUuid(),"fixed by john"));
        equipment1.setComments(comments1);

        Equipment equipment2 = new Equipment();
        equipment2.setType(EquipmentType.ELECTRIC_SHAVER);
        equipment2.setToFix(true);

        List<EquipmentParameter> parameters2 = new ArrayList<>();
        parameters2.add(new EquipmentParameter(equipment2.getUuid(),"name","philips"));
        parameters2.add(new EquipmentParameter(equipment2.getUuid(),"owner","boss"));
        equipment2.setPropeties(parameters2);

        List<EquipmentComment> comments2 = new ArrayList<>();
        comments2.add(new EquipmentComment(equipment2.getUuid(),"fix itt asap"));
        comments2.add(new EquipmentComment(equipment2.getUuid(),"john is fixing"));
        equipment2.setComments(comments2);
        List<Equipment> equipmentList = new ArrayList<>();
        equipmentList.add(equipment1);
        equipmentList.add(equipment2);


        when(equipmentRepo.findAll()).thenReturn(equipmentList);
        when(equipmentCommentRepo.findByEquipmentUUID("hi")).thenReturn(comments2);

    }

    @Test
    public void getAllEquipment() throws Exception {
        this.mockMvc.perform(get("/api/getall")).andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void equipment() throws Exception {
    }

    @Test
    public void getAllTypes() throws Exception {
    }

    @Test
    public void getCommentsByUID() throws Exception {
//        ????
        this.mockMvc.perform(post("/api/getcomments").contentType(MediaType.APPLICATION_JSON).content("hi")).andDo(print());
    }

    @Test
    public void addProperties() throws Exception {
    }

    @Test
    public void addComments() throws Exception {
    }

}
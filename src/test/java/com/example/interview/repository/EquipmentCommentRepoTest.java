package com.example.interview.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@DataJpaTest
public class EquipmentCommentRepoTest {

    @Autowired
    EquipmentCommentRepo equipmentCommentRepo;

    @Autowired
    EquipmentRepo equipmentRepo;



    @Test
    public void nonativequert() throws Exception {
        String uuid = equipmentRepo.findAll().get(0).getUuid();
        Assert.assertEquals(2,equipmentCommentRepo.findByEquipmentUUID(uuid).size());
    }
}
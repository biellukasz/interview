package com.example.interview.repository;

import com.example.interview.entity.EquipmentParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface EquipmentParameterRepo extends JpaRepository<EquipmentParameter,Long>{

    List<EquipmentParameter> findAllByEquipmentUUID(String equid);

    @Transactional
    void deleteByUuid(String uid);
}

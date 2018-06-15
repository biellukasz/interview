package com.example.interview.repository;

import com.example.interview.entity.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Repository
public interface EquipmentRepo extends JpaRepository<Equipment,Long> {

    List<Equipment> findAll();

    Equipment findByUuid(String uid);

    @Transactional
    void deleteByUuid(String uid);

}

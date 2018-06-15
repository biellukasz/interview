package com.example.interview.repository;

import com.example.interview.entity.EquipmentComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.lang.reflect.Type;
import java.util.List;

@Repository
public interface EquipmentCommentRepo extends JpaRepository<EquipmentComment,Long> {

    @Query(value = "select * from equipment_comment where equipmentuuid = ?1",nativeQuery = true)
    List<EquipmentComment> findByEquipmentUUID(String uid);

    @Transactional
    void deleteByUuid(String uid);
}

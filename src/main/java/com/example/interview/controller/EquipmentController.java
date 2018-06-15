package com.example.interview.controller;

import com.example.interview.entity.Equipment;
import com.example.interview.entity.EquipmentComment;
import com.example.interview.entity.EquipmentParameter;
import com.example.interview.entity.EquipmentType;
import com.example.interview.repository.EquipmentCommentRepo;
import com.example.interview.repository.EquipmentParameterRepo;
import com.example.interview.repository.EquipmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api")
public class EquipmentController {

    private EquipmentRepo repository;
    private EquipmentParameterRepo equipmentParameterRepo;
    private EquipmentCommentRepo equipmentCommentRepo;

    @Autowired
    public EquipmentController(EquipmentRepo repository,EquipmentParameterRepo equipmentParameterRepo,EquipmentCommentRepo equipmentCommentRepo) {
        this.repository = repository;
        this.equipmentParameterRepo = equipmentParameterRepo;
        this.equipmentCommentRepo = equipmentCommentRepo;
    }

    @GetMapping("/getall")
    @CrossOrigin(origins = "*")
    @ResponseStatus(HttpStatus.OK)
    public List<Equipment> getAllEquipment(){

        List<Equipment> all = repository.findAll();
        all.forEach(equipment -> {
            equipment.setComments(equipmentCommentRepo.findByEquipmentUUID(equipment.getUuid()));
            equipment.setPropeties(equipmentParameterRepo.findAllByEquipmentUUID(equipment.getUuid()));
        });
        return all;

    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin("*")
    public Equipment equipment(@RequestBody Equipment equipment){

        return repository.save(equipment);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin("*")
    public Equipment updateEquipment(@RequestBody Equipment equipment){
        Equipment e = repository.findByUuid(equipment.getUuid());
        e.setType(equipment.getType());
        e.setToFix(equipment.isToFix());
        return repository.save(e);
    }

    @DeleteMapping("/delete/{uid}")
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin("*")
    public void deleteEquipment(@PathVariable("uid") String uid){
        repository.deleteByUuid(uid);
    }


    @GetMapping("/gettypes")
    @CrossOrigin("*")
    @ResponseStatus(HttpStatus.OK)
    public List<String> getAllTypes(){
        EquipmentType equipmentType = new EquipmentType();
        return equipmentType.getAllTypes();
    }
    @PostMapping("/getcomments")
    @CrossOrigin("*")
    @ResponseStatus(HttpStatus.OK)
    public List<EquipmentComment> getCommentsByUID(@RequestBody String uid){
       return equipmentCommentRepo.findByEquipmentUUID(uid);
    }

    @PostMapping("/getprop")
    @CrossOrigin("*")
    @ResponseStatus(HttpStatus.OK)
    public List<EquipmentParameter> getParametersByUID(@RequestBody String uid){
        return equipmentParameterRepo.findAllByEquipmentUUID(uid);
    }


    @PostMapping("/addproperties")
    @CrossOrigin("*")
    @ResponseStatus(HttpStatus.OK)
    public List<EquipmentParameter> addProperties(@RequestBody List<EquipmentParameter> properties){
        properties.forEach(property ->{
            equipmentParameterRepo.save(property);
        });
        return properties;
    }
    @PostMapping("/addproperty")
    @CrossOrigin("*")
    @ResponseStatus(HttpStatus.OK)
    public EquipmentParameter addProperty(@RequestBody EquipmentParameter property){
           return equipmentParameterRepo.save(property);
    }
    @PutMapping("/updateproperties")
    @CrossOrigin("*")
    @ResponseStatus(HttpStatus.OK)
    public List<EquipmentParameter> updateProperties(@RequestBody List<EquipmentParameter> properties){
        properties.forEach(property ->{
            equipmentParameterRepo.save(property);
        });
        return properties;
    }
    @DeleteMapping("/deleteprop/{uid}")
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin("*")
    public void deleteProp(@PathVariable("uid") String uid){
        equipmentParameterRepo.deleteByUuid(uid);
    }

    @DeleteMapping("/deletecom/{uid}")
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin("*")
    public void deleteComment(@PathVariable("uid") String uid){
        equipmentCommentRepo.deleteByUuid(uid);
    }

    @PostMapping("/addcomments")
    @CrossOrigin("*")
    @ResponseStatus(HttpStatus.OK)
    public List<EquipmentComment> addComments(@RequestBody List<EquipmentComment> comments){
        comments.forEach(comment ->{
            equipmentCommentRepo.save(comment);
        });
        return comments;
    }

    @PostMapping("/addcomment")
    @CrossOrigin("*")
    @ResponseStatus(HttpStatus.OK)
    public EquipmentComment addComment(@RequestBody EquipmentComment comment){
            return equipmentCommentRepo.save(comment);
    }

    @PutMapping("/updatecomments")
    @CrossOrigin("*")
    @ResponseStatus(HttpStatus.OK)
    public List<EquipmentComment> updateComments(@RequestBody List<EquipmentComment> comments){
        comments.forEach(comment ->{
            equipmentCommentRepo.save(comment);
        });
        return comments;
    }

}

import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, FormArray, Form} from '@angular/forms';
import {EquipmentService} from "../../../equipment.service";
import {Equipment} from "../../../model/equipment";
import 'rxjs/add/observable/throw';
import {Property} from "../../../model/property";
import {Comments} from "../../../model/comment";

@Component({
  selector: 'app-equipment-manager',
  templateUrl: './equipment-manager.component.html',
  styleUrls: ['./equipment-manager.component.css']
})
export class EquipmentManagerComponent implements OnInit {


  equipment: Equipment = new Equipment();
  selectedEquipment: Equipment = new Equipment();
  equipmentTypes:Array<string>;
  equipmentPropertis: Array<Property> = new Array();
  equipmentComments: Array<Comments> = new Array();
  form: FormGroup;


  constructor(private equipmentService: EquipmentService,private fb: FormBuilder) {
  }

  ngOnInit() {
    this.equipmentService.getAllTypes().subscribe(data =>{
      this.equipmentTypes = data;
    });
    // this.initSelectedEquipment();
    this.buildForm();
    this.equipmentService.change.subscribe(selectedEquipment => {
      this.selectedEquipment = selectedEquipment;
      console.log("clicked from another component" + this.selectedEquipment.uuid);
      this.patch();
    });
  }

  createEquipment(): void {
    this.getEquipment();
    this.equipmentService.createEquipment(this.equipment)
      .subscribe( data => {
        this.createPropertiesList(data.uuid);
        this.createCommentsList(data.uuid);
        this.equipmentService.createProperties(this.equipmentPropertis)
          .subscribe(data =>{
          });
        this.equipmentService.createComments(this.equipmentComments)
          .subscribe(data=>{
          });
        alert("Equipment created successfully.");
        this.equipmentService.getAllEq();
        this.equipmentService.getCommentsByID(data.uuid);
        this.equipmentService.getPropByID(data.uuid);
        this.resetFrom();
      });

  };
  updateEquipment(): void {
    this.getEquipment();
    this.equipment.uuid = this.equipmentService.selectedEquipment.uuid;
    console.log(this.equipment);
    this.equipmentService.updateEquipment(this.equipment)
      .subscribe( data => {
        this.createPropertiesList(data.uuid);
        this.createCommentsList(data.uuid);
        this.equipmentService.updateProperties(this.equipmentPropertis)
          .subscribe(data =>{
          });
        this.equipmentService.updateCommets(this.equipmentComments)
          .subscribe(data=>{
          });
        alert("Equipment updated successfully.");
        this.equipmentService.getAllEq();
        this.resetFrom();
      });

  };
  buildForm(): void {
    this.form = this.fb.group({
      // uid:'',
      type: '',
      toFix: false,
      properties: this.fb.array([]),
      comments: this.fb.array([]),
    });
  }
  getEquipment():void{
    // let uid = this.form.get('uid');
    let type = this.form.get('type');
    let toFix = this.form.get('toFix');
    // this.equipment.uuid = uid.value;
    this.equipment.toFix = toFix.value;
    this.equipment.type = type.value;
    // this.createCommentsList(this.equipment.uuid);
    // this.createPropertiesList(this.equipment.uuid);
    // this.equipment.comments = this.equipmentComments;
    // this.equipment.properties = this.equipmentPropertis;
  }


  createItem(): FormGroup {
    return this.fb.group({
      parameterName: '',
      parameterValue: ''
    });
  }
  createComment(): FormGroup {
    return this.fb.group({
      commentValue: ''
    });
  }
  addItem(): void {
    let propertiesArray = this.form.get('properties') as FormArray;
    const newItem = this.createItem();
    propertiesArray.push(newItem);
  }
  addComment(): void {
    let commentsArray = this.form.get('comments') as FormArray;
    const newItem = this.createComment();
    commentsArray.push(newItem);
  }
  createPropertiesList(equuid:string):void{
    let propertiesArray = this.form.get('properties') as FormArray;
    for (let pro of propertiesArray.value) {
      let property = new Property();
      property.equipmentUUID = equuid;
      property.parameterName = pro.parameterName;
      property.parameterValue = pro.parameterValue;
      this.equipmentPropertis.push(property);
    }
  }
  createCommentsList(equuid:string):void{
    let propertiesArray = this.form.get('comments') as FormArray;
    for (let pro of propertiesArray.value) {
      let comment = new Comments();
      comment.equipmentUUID = equuid;
      comment.comment = pro.commentValue;
      this.equipmentComments.push(comment);
    }
  }



  resetFrom(){
    this.form.reset();
    this.buildForm();
  }

  patch() {
    this.resetFrom();
    if(this.selectedEquipment.uuid != null){
      // let uid =this.form.get('uid');
      // uid.setValue(this.selectedEquipment.uuid);

      let type = this.form.get('type');
      type.setValue(this.selectedEquipment.type);

      let toFix = this.form.get('toFix');
      toFix.setValue(this.selectedEquipment.toFix);

      // let properties = this.form.get('properties') as FormArray;
      // this.selectedEquipment.properties.forEach(y=>{
      //   properties.push(this.patchProperties(y.parameterName,y.parameterValue))
      // });
      // let comments = this.form.get('comments') as FormArray;
      // this.selectedEquipment.comments.forEach(x => {
      //   comments.push(this.patchCommnet(x.comment))
      // });
    }
  }

  patchCommnet(comment) {
    return this.fb.group({
      commentValue: [comment]
    })
  }
  patchProperties(propName,propValue) {
    return this.fb.group({
      parameterName: [propName],
      parameterValue: [propValue]
    })
  }

}

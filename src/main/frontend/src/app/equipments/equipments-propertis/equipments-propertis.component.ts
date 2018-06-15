import { Component, OnInit } from '@angular/core';
import {EquipmentService} from "../../equipment.service";
import {Property} from "../../model/property";

@Component({
  selector: 'app-equipments-propertis',
  templateUrl: './equipments-propertis.component.html',
  styleUrls: ['./equipments-propertis.component.css']
})
export class EquipmentsPropertisComponent implements OnInit {


  property:Property = new Property();
  constructor(private equipmentService:EquipmentService) { }

  ngOnInit() {
  }
  addProp(){
    this.property.equipmentUUID = this.equipmentService.selectedEquipment.uuid;
    console.log(this.property);
    this.equipmentService.createProperty(this.property).subscribe(data=>{
      this.equipmentService.getAllEq();
      this.equipmentService.getPropByID(this.property.equipmentUUID);
    });
  }

  deleteProp(uuid: String) {
    if (confirm('Are you sure to delete this Property ?') == true){
      this.equipmentService.getAllEq();
      this.equipmentService.deletePropbyUID(uuid);
    }
  }
}

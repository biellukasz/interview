import {Component, HostListener, OnInit} from '@angular/core';
import {EquipmentService} from "../../equipment.service";
import {Equipment} from "../../model/equipment";

@Component({
  selector: 'app-equipment-list',
  templateUrl: './equipment-list.component.html',
  styleUrls: ['./equipment-list.component.css']
})
export class EquipmentListComponent implements OnInit {


  constructor(private equipmentService: EquipmentService) { }

  ngOnInit() {
    this.equipmentService.getAllEq();
  }

  showForEdit(emp: Equipment) {
    this.equipmentService.selectedEquipment = Object.assign({}, emp);
    this.equipmentService.editEquipment();
    this.equipmentService.selectedEqUID = Object.assign({},emp.uuid);
    }


  showComments(emp: Equipment) {
    let commentsByID = this.equipmentService.getCommentsByID(emp.uuid);
    this.equipmentService.selectedCommentsList = Object.assign({},commentsByID);
    this.equipmentService.selectedEquipment = Object.assign({},emp);

  }
  // do poprawy
  showProp(emp: Equipment) {
   let propByID = this.equipmentService.getPropByID(emp.uuid);
   this.equipmentService.selectedPropertis = Object.assign({},propByID);
   this.equipmentService.selectedEquipment = Object.assign({},emp);

  }

  onDelete(uuid: String) {

    if (confirm('Are you sure to delete this Equipment ?') == true){
      this.equipmentService.deleteEqbyUID(uuid);
      this.equipmentService.getAllEq();
    }
  }
}

import { Component, OnInit } from '@angular/core';
import {EquipmentService} from "../../equipment.service";
import {Comments} from "../../model/comment";
import {NgForm} from "@angular/forms";

@Component({
  selector: 'app-equipment-comments',
  templateUrl: './equipment-comments.component.html',
  styleUrls: ['./equipment-comments.component.css']
})
export class EquipmentCommentsComponent implements OnInit {

  commentToSubmit:Comments = new Comments();

  constructor(private equipmentService:EquipmentService) { }

  ngOnInit() {
  }

  addComment(){
    this.commentToSubmit.equipmentUUID = this.equipmentService.selectedEquipment.uuid;
    console.log(this.commentToSubmit.comment);
    this.equipmentService.createComment(this.commentToSubmit).subscribe(data=>{
      this.equipmentService.getAllEq();
      this.equipmentService.selectedCommentsList = this.equipmentService.getCommentsByID(this.commentToSubmit.equipmentUUID);
    });

  }

  deleteComment(uuid: String) {
    if (confirm('Are you sure to delete this Property ?') == true){
      this.equipmentService.getAllEq();
      this.equipmentService.deleteCommentbyUID(uuid);

    }
  }

}

import {EventEmitter, Injectable, Output} from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs/Observable";
import {Equipment} from "./model/equipment";
import {Property} from "./model/property";
import {Comments} from "./model/comment";
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/toPromise';


@Injectable()
export class EquipmentService {

  selectedPropertis: Property[];
  selectedCommentsList: Comments[];
  selectedEquipment:Equipment;
  equipmentList:Equipment[];
  selectedEqUID:string;
  @Output() change: EventEmitter<Equipment> = new EventEmitter();

  constructor(private http: HttpClient) { }

  getAllEq(){
    this.http.get('http://localhost:8080/api/getall').map(data =>{
        return data as Equipment[];
    }).toPromise().then(eq =>{
      this.equipmentList = eq;
    });
  }
  public createEquipment(equipment) {
    return this.http.post<Equipment>('http://localhost:8080/api/create', equipment);
  }
  public updateEquipment(equipment) {
    return this.http.put<Equipment>('http://localhost:8080/api/update', equipment);
  }

  getAllTypes(): Observable<any> {
    return this.http.get('http://localhost:8080/api/gettypes');
  }
  public createProperties(propertiesList) {
    return this.http.post<Array<Property>>('http://localhost:8080/api/addproperties', propertiesList);
  }
  public createProperty(property) {
    return this.http.post<Property>('http://localhost:8080/api/addproperty', property);
  }
  public updateProperties(propertiesList) {
    return this.http.put<Array<Property>>('http://localhost:8080/api/addproperties', propertiesList);
  }
  public createComments(commentsList) {
    return this.http.post<Array<Comments>>('http://localhost:8080/api/addcomments', commentsList);
  }

  public updateCommets(commentsList) {
    return this.http.put<Array<Comments>>('http://localhost:8080/api/addcomments', commentsList);
  }
  // do poprawy
 public getCommentsByID(uuid):Comments[] {
    this.http.post('http://localhost:8080/api/getcomments',uuid).map(data=>{
      return data as Comments[];
    }).toPromise().then(com =>{
      this.selectedCommentsList = com;
    });
    return this.selectedCommentsList;

  }
  public deletePropbyUID(uuid: String) {
    return  this.http.delete('http://localhost:8080/api/deleteprop/'+uuid).subscribe((response) =>{
      console.log('deletd Eq');
      this.getAllEq();
      this.getPropByID(uuid);
    });
  }
  public getPropByID(uuid):Property[] {
    this.http.post('http://localhost:8080/api/getprop',uuid).map(data=>{
      return data as Property[];
    }).toPromise().then(com =>{
      this.selectedPropertis = com;
    })
    return this.selectedPropertis;

  }

  public deleteEqbyUID(uuid: String) {
    return this.http.delete('http://localhost:8080/api/delete/'+uuid).subscribe((response) =>{
      console.log('deletd prop');
      this.getAllEq();
    });
  }

  public editEquipment() {
    this.change.emit(this.selectedEquipment);

  }

 public createComment(comment):Observable<any> {
    return this.http.post<Comments>('http://localhost:8080/api/addcomment', comment);
  }

  public deleteCommentbyUID(uuid: String) {
    this.http.delete('http://localhost:8080/api/deletecom/'+uuid).subscribe((response) =>{
      console.log('deletd comment');
      this.getAllEq();
      this.getCommentsByID(uuid);
    });
  }
}



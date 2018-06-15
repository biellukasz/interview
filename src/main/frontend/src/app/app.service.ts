import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from '@angular/common/http';

@Injectable()
export class AppService {

  authenticated = false;

  constructor(private http: HttpClient) {
  }

  authenticate(credentials) {
    // return this.authenticated = true;


    return this.http.post('http://localhost:8080/user',credentials).subscribe(data=>{
      console.log(data);
      if(data == true){
        this.authenticated = true;
      }
    });
    }
    // const headers = new HttpHeaders(credentials ? {
    //   authorization : 'Basic ' + btoa(credentials.username + ':' + credentials.password)
    // } : {});
    //
    // this.http.get('http://localhost:8080/user', {headers: headers}).subscribe(response => {
    //   if (response['name']) {
    //     this.authenticated = true;
    //   } else {
    //     this.authenticated = false;
    //   }
    //   return callback && callback();
    // });

}


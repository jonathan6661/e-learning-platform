import {Injectable} from '@angular/core';
import {Observable} from 'rxjs/Observable';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {TokenStorage} from './token.storage';
import * as jwt_decode from "jwt-decode";
import { JwtHelperService } from '@auth0/angular-jwt';

@Injectable()
export class AuthService {

  baseUrl: 'http://localhost:8080/email2sms/';

  constructor(private http: HttpClient, private token: TokenStorage) {
  }

  attemptAuth(ussername: string, password: string): Observable<any> {
    const credentials = {username: ussername, password: password};
    //console.log('attempAuth ::');
    return this.http.post<any>('http://localhost:8080/token/generate-token', credentials);
  }

  isAdmin(): boolean {
    const tokenPayload = jwt_decode(this.token.getToken());
    if (tokenPayload.scopes == 'ROLE_ADMIN') {
      return true;

    } else {
      return false;
    }


  }

  isTeacher(): boolean {
    const tokenPayload = jwt_decode(this.token.getToken());
    if (tokenPayload.scopes == 'ROLE_TEACHER') {
      return true;

    } else {
      return false;
    }

  }

  isStudent(): boolean {
    const tokenPayload = jwt_decode(this.token.getToken());
    if (tokenPayload.scopes == 'ROLE_USER') {
      return true;

    } else {
      return false;
    }

  }



  public getUsername():string{
    const tokenPayload = jwt_decode(this.token.getToken());
    return tokenPayload.sub;

  }




  public isAuth(): boolean {

   // console.log("1");

    const helper = new JwtHelperService();
   // console.log("2");

    const token = this.token.getToken();
   // console.log(token);

    const isexp = helper.isTokenExpired(token);
  //  console.log(!isexp);

    return !isexp;

  }
}

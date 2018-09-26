import { Component } from '@angular/core';
import {Router} from '@angular/router';
import {AuthService} from './core/auth.service';
import {TokenStorage} from './core/token.storage';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  isAdmin$: boolean;                  // {1}
  isTeacher$:boolean;
  isStudent$:boolean;

  constructor(private authservice:AuthService , private  token:TokenStorage,private router:Router) {
    //this.isAdmin$=this.authservice.isAdmin();
    //console.log(this.isAdmin$);

  }

  Admin():boolean{
  this.isAdmin$=this.authservice.isAdmin();
    console.log(this.isAdmin$);

    return this.isAdmin$;
}
  Teacher():boolean{
    this.isTeacher$=this.authservice.isTeacher();
    console.log(this.isTeacher$);

    return this.isTeacher$;
  }
  Student():boolean{
    this.isStudent$=this.authservice.isStudent();
    return this.isStudent$;
  }

  logout(){
    this.token.signOut();
    this.router.navigate(['login']);
  }

  Auth():boolean {

    if (!this.authservice.isAuth()) {
      return false;
    }
    else{
    return true;

  }}
}

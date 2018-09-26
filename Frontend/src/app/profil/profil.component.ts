import { Component, OnInit } from '@angular/core';
import {UserService} from '../app.service';
import {AuthService} from '../core/auth.service';
import {Profil} from './profil.model';

@Component({
  selector: 'app-profil',
  templateUrl: './profil.component.html',
  styleUrls: ['./profil.component.css']
})
export class ProfilComponent implements OnInit {

  username:string="";
  profil$:Object=new Profil();
  constructor(private userService:UserService,private authService:AuthService) {
    this.username=this.authService.getUsername();

  }

  ngOnInit() {

    this.userService.getProfil(this.username).subscribe(
      data=>this.profil$=data
    );

  }

}

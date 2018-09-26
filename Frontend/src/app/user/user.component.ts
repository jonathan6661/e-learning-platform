                                                                      import {Component, OnInit} from '@angular/core';
import {MatTableDataSource} from '@angular/material';
import {User} from './user.model';
import {UserService} from '../app.service';
import {Router} from '@angular/router';
import {Observable} from 'rxjs/Observable';
import {AuthService} from '../core/auth.service';
import {TokenStorage} from '../core/token.storage';
import decode from 'jwt-decode';
import * as jwt_decode from "jwt-decode";

@Component({
  selector: 'app-root',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  displayedColumns = ['id', 'username', 'salary', 'age'];
  dataSource = new MatTableDataSource<User>();
  users$: Object;
  isAdmin$: boolean;                  // {1}

  constructor(private router: Router, private userService: UserService,private authservice:AuthService, private token: TokenStorage) {
  }
  ngOnInit(): void {
    //this.isAdmin$=this.authservice.isAdmin();
    //console.log(this.authservice.isAdmin())
    this.userService.getUsers().subscribe(
      data => {
        this.users$ = data;
      }
    );
  }
}


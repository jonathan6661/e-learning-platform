import { Component, OnInit } from '@angular/core';
import {UserService} from '../app.service';
import {AuthService} from '../core/auth.service';

@Component({
  selector: 'app-favourite-courses',
  templateUrl: './favourite-courses.component.html',
  styleUrls: ['./favourite-courses.component.css']
})
export class FavouriteCoursesComponent implements OnInit {
  courses$: Object;
  username:string;

  constructor(private data:UserService ,private authService:AuthService) {
    this.username=this.authService.getUsername();
  }

  ngOnInit() {
    this.data.getPannier(this.username).subscribe(
      data => this.courses$ = data
    )
  }

}

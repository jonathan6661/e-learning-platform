import { Component, OnInit } from '@angular/core';
import {UserService} from '../app.service';
import { Observable } from 'rxjs';
import {Router} from '@angular/router';
import {Course} from '../courseadd/course.model';
import {AuthService} from '../core/auth.service';
@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.css']
})
export class CoursesComponent implements OnInit {
  courses$: Object;


  constructor(private data:UserService , private route:Router,private authService:AuthService) { }

  ngOnInit() {
    this.data.getCourses().subscribe(
      data => this.courses$ = data
    );

    console.log(this.authService.getUsername());
  }

  getTitle(course:Course){
    return course.title;
  }
  getLink(course:Course){
    return course.link;
  }
}

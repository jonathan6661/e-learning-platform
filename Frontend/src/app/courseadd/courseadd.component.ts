import { Component, OnInit } from '@angular/core';
import {Course} from './course.model';
import {UserService} from '../app.service';

@Component({
  selector: 'app-courseadd',
  templateUrl: './courseadd.component.html',
  styleUrls: ['./courseadd.component.css']
})
export class CourseaddComponent implements OnInit {

  course:Course=new Course();
  mode:number=1;
  constructor( private userService:UserService) { }

  ngOnInit() {
  }
  saveCourse(){
    this.userService.saveCourse(this.course).subscribe(
      data=>//this.course=data;
      this.mode=2
    )


  }


}

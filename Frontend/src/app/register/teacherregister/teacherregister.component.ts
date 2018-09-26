import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {UserService} from '../../app.service';
import {Teacher} from './teacher.model';

@Component({
  selector: 'app-teacherregister',
  templateUrl: './teacherregister.component.html',
  styleUrls: ['./teacherregister.component.css']
})
export class TeacherregisterComponent implements OnInit {
  teacher:any=new Teacher();
  mode:number=1;

  constructor( private userService:UserService,private router: Router) { }

  ngOnInit() {
  }

  saveTeacher(){
    this.userService.saveTeacher(this.teacher).subscribe(
      data=>{
        this.teacher=data;
        //  this.mode=2;
        this.router.navigate(['login']);}
    )

  }

  gotoPage():void{

    this.router.navigate(['register'])
  }
}

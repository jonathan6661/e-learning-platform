import { Component, OnInit } from '@angular/core';
import {Student} from './student.model';
import {UserService} from '../app.service';
import {Course} from '../courseadd/course.model';
import {Router} from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  student:any=new Student();
  mode:number=1;

  constructor( private userService:UserService,private router: Router) { }

  ngOnInit() {
  }

  saveStudent(){
    this.userService.saveStudent(this.student).subscribe(
     data=>{
       this.student=data;
     //  this.mode=2;
      this.router.navigate(['login']);}
    )

  }
  gotoPage():void{

    this.router.navigate(['tregister'])
  }

}

import {Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {User} from './user/user.model';
import {Course} from './courseadd/course.model';
import {Student} from './register/student.model';
import {Teacher} from './register/teacherregister/teacher.model';


const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable()
export class UserService {

  constructor(private http: HttpClient) {}

  private userUrl = 'http://localhost:8080/';

  public getUsers(){
    return this.http.get('http://localhost:8080/users');
  }
  getUser(userId) {
    return this.http.get('http://localhost:8080/users/' + userId);
  }
  public getCourses(){
    return this.http.get('http://localhost:8080/courses');
  }

  public getCourse(idCourse){
    return this.http.get('http://localhost:8080/courses/'+idCourse);
  }

  public saveCourse(course:Course){

    return this.http.post("http://localhost:8080/courses",course)
  }
  public saveStudent(student:Student){

    return this.http.post("http://localhost:8080/signup/student",student)
  }
  public saveTeacher(teacher:Teacher){

    return this.http.post("http://localhost:8080/signup/teacher",teacher)
  }

  public deleteCourse(id:number){

    return this.http.delete("http://localhost:8080/courses/"+id)
  }
  public getProfil(username:string){
    return this.http.get("http://localhost:8080/profil?username="+username)
  }
  public addToPannier(id:number,username:string){
    return this.http.get("http://localhost:8080/addToWishlist?id="+id+"&username="+username)
  }
  public getPannier(username:string){
    return this.http.get("http://localhost:8080/wishlist?username="+username)
  }


}

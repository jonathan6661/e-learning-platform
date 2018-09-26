import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {UserComponent} from '../user/user.component';
import {LoginComponent} from '../login/login.component';
import {RoleGuardServiceGuard} from '../role-guard-service.guard';
import {RegisterComponent} from '../register/register.component';
import {CoursesComponent} from '../courses/courses.component';
import {ContactComponent} from '../contact/contact.component';
import {CourseaddComponent} from '../courseadd/courseadd.component';
import {ChatComponent} from '../chat/chat.component';
import {TeacherregisterComponent} from '../register/teacherregister/teacherregister.component';
import {CoursedetailsComponent} from '../coursedetails/coursedetails.component';
import {QuizComponent} from '../quiz/quiz.component';
import {ProfilComponent} from '../profil/profil.component';
import {FavouriteCoursesComponent} from '../favourite-courses/favourite-courses.component';
import {UserDetailComponent} from '../user-detail/user-detail.component';

const routes: Routes = [
  { path: 'user', component: UserComponent ,},
  { path: 'user/:id', component: UserDetailComponent ,},
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'contact', component: ContactComponent },
  { path: 'addcourse', component: CourseaddComponent },
  { path: 'chat', component: ChatComponent },
  { path: 'quiz', component: QuizComponent },
  { path: 'profil', component: ProfilComponent },
  { path: 'favourite', component: FavouriteCoursesComponent },
  { path: 'tregister', component: TeacherregisterComponent },
  { path: 'courses/:id', component: CoursedetailsComponent },
  { path: 'courses', component: CoursesComponent   },
  {path : '', component : LoginComponent}
];

@NgModule({
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ],
  declarations: []
})
export class AppRoutingModule { }

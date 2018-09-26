import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import {CustomMaterialModule} from './core/material.module';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {FormsModule} from '@angular/forms';
import { UserComponent } from './user/user.component';
import {AppRoutingModule} from './core/app.routing.module';
import { LoginComponent } from './login/login.component';
import {ErrorDialogComponent} from './core/error-dialog.component';
import {UserService} from "./app.service";
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {AuthService} from "./core/auth.service";
import {Interceptor} from "./core/inteceptor";
import {TokenStorage} from "./core/token.storage";
import {RoleGuardServiceGuard} from './role-guard-service.guard';
import {JwtHelperService} from '@auth0/angular-jwt';
import { RegisterComponent } from './register/register.component';
import { CoursesComponent } from './courses/courses.component';
import { CoursedetailsComponent } from './coursedetails/coursedetails.component';
import { ContactComponent } from './contact/contact.component';
import { CourseaddComponent } from './courseadd/courseadd.component';
import { ChatComponent } from './chat/chat.component';
import { StudentComponent } from './student/student.component';
import { TeacherregisterComponent } from './register/teacherregister/teacherregister.component';
import {YoutubePlayerModule} from 'ngx-youtube-player';
import {APP_BASE_HREF} from '@angular/common';
import { PdfViewerModule } from 'ng2-pdf-viewer';
import { QuizComponent } from './quiz/quiz.component';
import { ProfilComponent } from './profil/profil.component';
import { FavouriteCoursesComponent } from './favourite-courses/favourite-courses.component';
import { UserDetailComponent } from './user-detail/user-detail.component';


@NgModule({
  declarations: [
    AppComponent,
    UserComponent,
    LoginComponent,
    ErrorDialogComponent,
    RegisterComponent,RegisterComponent, CoursesComponent, CoursedetailsComponent, ContactComponent, CourseaddComponent, ChatComponent, StudentComponent, TeacherregisterComponent, QuizComponent, ProfilComponent, FavouriteCoursesComponent, UserDetailComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    CustomMaterialModule,
    FormsModule,
    AppRoutingModule,YoutubePlayerModule,PdfViewerModule
  ],
  entryComponents: [ErrorDialogComponent],
  providers: [ErrorDialogComponent, UserService, AuthService, TokenStorage, TokenStorage,
    {provide: HTTP_INTERCEPTORS,
    useClass: Interceptor,
    multi : true},RoleGuardServiceGuard,{provide: APP_BASE_HREF, useValue : '/' }

],
  bootstrap: [AppComponent]
})
export class AppModule { }

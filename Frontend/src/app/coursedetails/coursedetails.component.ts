import {Component, NgModule, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {UserService} from '../app.service';
import {Course} from '../courseadd/course.model';
import { PdfViewerModule } from 'ng2-pdf-viewer';

import { YoutubePlayerModule } from 'ngx-youtube-player';
import {Option, Question, Quiz, QuizConfig} from '../models';
import {QuizService} from '../services/quiz.service';
import {AuthService} from '../core/auth.service';

@NgModule({
  imports:      [ YoutubePlayerModule , PdfViewerModule]
})
@Component({
  selector: 'app-coursedetails',
  templateUrl: './coursedetails.component.html',
  styleUrls: ['./coursedetails.component.css'],
  providers: [QuizService]

})
export class CoursedetailsComponent implements OnInit {

  id :string= '';
  userna:string='';

  x:string="qDuKsiwS5xw";
  private player;
  public ytEvent;
 // pdfSrc: string = '../assets/pr.pdf';
  show:boolean=false;
  courseorquiz:boolean=false;

  course$:any=new Course();
  isAdmin$: boolean;                  // {1}
  isTeacher$:boolean;
  isStudent$:boolean;

  score:number=0;
  modee:number=1;
  quizame='';
  quizes: any[];
  quiz: Quiz = new Quiz(null);
  mode = 'quiz';
  quizName: string;
  config: QuizConfig = {
    'allowBack': true,
    'allowReview': true,
    'autoMove': false,  // if true, it will move to next question automatically when answered.
    'duration': 300,  // indicates the time (in secs) in which quiz needs to be completed. 0 means unlimited.
    'pageSize': 1,
    'requiredAll': false,  // indicates if you must answer all the questions before submitting.
    'richText': false,
    'shuffleQuestions': false,
    'shuffleOptions': false,
    'showClock': false,
    'showPager': true,
    'theme': 'none'
  };

  pager = {
    index: 0,
    size: 1,
    count: 1
  };
  timer: any = null;
  startTime: Date;
  endTime: Date;
  ellapsedTime = '00:00';
  duration = '';

  constructor(private route: ActivatedRoute, private data: UserService , private router: Router, private quizService: QuizService,private authService:AuthService) {
    this.route.params.subscribe( params => this.course$ = params.id );
    this.userna=this.authService.getUsername();
  }
  Admin():boolean{
    this.isAdmin$=this.authService.isAdmin();
    console.log(this.isAdmin$);

    return this.isAdmin$;
  }
  Teacher():boolean{
    this.isTeacher$=this.authService.isTeacher();
    console.log(this.isTeacher$);

    return this.isTeacher$;
  }
  Student():boolean{
    this.isStudent$=this.authService.isStudent();
    return this.isStudent$;
  }


  ngOnInit() {

    this.data.getCourse(this.course$).subscribe(
      data => {
        this.course$ = data;
     //   console.log(this.course$.link);
        this.id=this.course$.link;
        this.x=this.id
      } );
    //  this.getId();
    this.quizes = this.quizService.getAll();
    this.quizName = this.quizes[0].id;

  }
  getTitle(course:Course){
    return course.title;
  }

  onStateChange(event) {
    this.ytEvent = event.data;
  }
  savePlayer(player) {
    this.player = player;
  }

  playVideo() {
    this.player.playVideo();
  }

  pauseVideo() {
    this.player.pauseVideo();
  }
  getId(){
    this.x=this.course$.link;
    this.id=this.x;
    console.log(this.id);
   // return 'qDuKsiwS5xw';
  }
  getPdf(course:Course){

    return course.category;
  }

  deleteCourse(i:number){

    this.data.deleteCourse(i).subscribe(
      data=>{
      // this.course$.splice();
      }

    )
    this.router.navigate(['courses']);
  }

  modifyCourse(i:number){

  }

  hideShow(){

    this.show=!this.show;
  }
  startQuiz(name:string){
    this.courseorquiz=!this.courseorquiz;
    this.quizame=name;

  }


  loadQuiz(quizName: string) {
    this.quizService.get(quizName).subscribe(res => {
      this.quiz = new Quiz(res);
      this.pager.count = this.quiz.questions.length;
      this.startTime = new Date();
      this.timer = setInterval(() => { this.tick(); }, 1000);
      this.duration = this.parseTime(this.config.duration);
    });
    this.mode = 'quiz';
  }

  tick() {
    const now = new Date();
    const diff = (now.getTime() - this.startTime.getTime()) / 1000;
    if (diff >= this.config.duration) {
      this.onSubmit();
    }
    this.ellapsedTime = this.parseTime(diff);
  }

  parseTime(totalSeconds: number) {
    let mins: string | number = Math.floor(totalSeconds / 60);
    let secs: string | number = Math.round(totalSeconds % 60);
    mins = (mins < 10 ? '0' : '') + mins;
    secs = (secs < 10 ? '0' : '') + secs;
    return `${mins}:${secs}`;
  }

  get filteredQuestions() {
    return (this.quiz.questions) ?
      this.quiz.questions.slice(this.pager.index, this.pager.index + this.pager.size) : [];
  }

  onSelect(question: Question, option: Option) {
    if (question.questionTypeId === 1) {
      question.options.forEach((x) => { if (x.id !== option.id) x.selected = false; });
    }

    if (this.config.autoMove) {
      this.goTo(this.pager.index + 1);
    }
  }

  goTo(index: number) {
    if (index >= 0 && index < this.pager.count) {
      this.pager.index = index;
      this.mode = 'quiz';
    }
  }

  isAnswered(question: Question) {
    return question.options.find(x => x.selected) ? 'Answered' : 'Not Answered';
  };

  isCorrect(question: Question) {
    return question.options.every(x => x.selected === x.isAnswer) ? 'correct' : 'wrong';
  };


  onSubmit() {
    let answers = [];
    this.quiz.questions.forEach(x => answers.push({ 'quizId': this.quiz.id, 'questionId': x.id, 'answered': x.answered }));

    // Post your data to the server here. answers contains the questionId and the users' answer.
    this.mode = 'result';
  }

  changemode(name:string){
    this.quizame=name;
    this.loadQuiz(this.quizame);

    this.modee=2;
    this.startTime = new Date();
    this.timer = setInterval(() => { this.tick(); }, 1000);
    this.duration = this.parseTime(this.config.duration);
  }

  addFavourite(idcourse:number,username:string){
    this.data.addToPannier(idcourse, username).subscribe(

    )
  }

}

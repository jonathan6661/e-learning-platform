import { Component, OnInit } from '@angular/core';
import {UserService} from '../app.service';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-user-detail',
  templateUrl: './user-detail.component.html',
  styleUrls: ['./user-detail.component.css']
})
export class UserDetailComponent implements OnInit {
  user$: Object;

  constructor(private route: ActivatedRoute, private data: UserService) {
    this.route.params.subscribe( params => this.user$ = params.id );

  }

  ngOnInit() {
    this.data.getUser(this.user$).subscribe(
      data => this.user$ = data

    );
  }

}

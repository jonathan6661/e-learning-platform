import { Injectable } from '@angular/core';
import {CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router} from '@angular/router';
import { Observable } from 'rxjs/Observable';
import decode from 'jwt-decode';
import {TokenStorage} from './core/token.storage';
import {AuthService} from './core/auth.service';


@Injectable()
export class RoleGuardServiceGuard implements CanActivate {
  constructor(public auth: AuthService, public router: Router) {}

  canActivate():boolean {

    if (!this.auth.isAuth()) {
      this.router.navigate(['login']);

      return false;
    } else {
      return true;
    }
  }
}

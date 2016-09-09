import {Component} from '@angular/core';
import {OnInit} from '@angular/core';
import {AppSettings} from './app.constants';
import {AuthService} from './auth/auth.service';

@Component({
  moduleId: module.id,
  selector: 'app-root',
  templateUrl: 'app.component.html',
  styleUrls: ['app.component.css'],
  providers: [AuthService]
})
export class AppComponent implements OnInit {
  constructor(private authService: AuthService) {
  }

  private user;
  private users;
  title: string = 'Hello';
  private url: string = this.getUrl();

  ngOnInit(): any {
    this.findUser();
  this.findUsers();
  }

  getANumber() {
    return this.title;
  }

  getUrl() {
    return AppSettings.BASE_URL;
  }

  findUser(): void {
    this.authService.getUser(1).then((user => {
      this.user = user
    }));
  }

  findUsers(): void {
    this.authService.getUsers().then(users => {
      this.users = users;
    })
  }

}

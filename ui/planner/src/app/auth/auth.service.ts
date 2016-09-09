import {Injectable} from '@angular/core';
import {Http} from '@angular/http';
import {AppSettings} from '../app.constants'


@Injectable()
export class AuthService {
  private userApi: string;

  constructor(private http: Http) {
    this.userApi = AppSettings.BASE_URL + 'user';
  }


  getUser(id : number): Promise<User> {
    //noinspection TypeScriptUnresolvedFunction
    return this.http.get(`${this.userApi}/${id}`)
      .toPromise()
      .then(response => {
        return <User> response.json()})
      .catch(this.handleError);
  };

  getUsers(): Promise<User[]> {
    //noinspection TypeScriptUnresolvedFunction
    return this.http.get(this.userApi + 's')
      .toPromise()
      .then(response => {
        return <User[]> response.json()})
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }
}
export class User {
  id: number;
  name: string;
  email: string;
}

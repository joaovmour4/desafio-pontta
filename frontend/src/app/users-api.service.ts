import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class UsersApiService {

  private baseUrl = 'http://localhost:8080/users'

  constructor( private httpService: HttpClient ) { }

  public getUsers(name: string){
    return this.httpService.get(`${this.baseUrl}?name=${name}`)
  }
  public getUserById(id: number){
    return this.httpService.get(`${this.baseUrl}/${id}`)
  }
  public createUser(user: User){
    return this.httpService.post(`${this.baseUrl}`, user)
  }
  public updateUser(user: User){
    return this.httpService.put(`${this.baseUrl}/${user.id}`, user)
  }
  public deleteUser(id: number){
    return this.httpService.delete(`${this.baseUrl}/${id}`)
  }

}

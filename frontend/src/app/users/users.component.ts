import { Component, OnInit } from '@angular/core';
import { UsersApiService } from '../users-api.service';
import { User } from '../user';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  searchValue: string = ''
  users: User[] = []

  constructor(private apiService: UsersApiService) { }

  ngOnInit() {
    this.loadUsers()
  }

  loadUsers(){
    this.apiService.getUsers(this.searchValue).subscribe((data: User[]) => this.users = data);
  }

}

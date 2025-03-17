import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UsersApiService } from '../users-api.service';
import { User } from '../user';

@Component({
  selector: 'app-users-form',
  templateUrl: './users-form.component.html',
  styleUrls: ['./users-form.component.css']
})
export class UsersFormComponent implements OnInit {

  id: string = null;
  user: User = new User();

  constructor(protected activatedRoute: ActivatedRoute, protected router: Router, private apiService: UsersApiService) { }

  ngOnInit() {
    this.id = this.activatedRoute.snapshot.paramMap.get('id');

    if(this.id){
      this.loadUser(this.id)
    }
  }

  loadUser(id: string){
    this.apiService.getUserById(parseInt(id)).subscribe((data: User) => this.user = data);
  }

  saveUser(){
    if(this.id){
      this.apiService.updateUser(this.user).subscribe(
        () => this.callbackSuccess(),
        (error: any) => this.callbackError(error)
      )
    }else{
      this.apiService.createUser(this.user).subscribe(
        () => this.callbackSuccess(),
        (error: any) => this.callbackError(error)
      )
    }
  }

  callbackSuccess(){
    this.router.navigate(['/users'])
  }
  callbackError(error: any){
    alert(error.error.message)
  }

}

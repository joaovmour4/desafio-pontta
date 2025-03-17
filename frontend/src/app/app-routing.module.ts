import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UsersComponent } from './users/users.component';
import { UsersFormComponent } from './users-form/users-form.component';
import { ProductsComponent } from './products/products.component';
import { ProductsFormComponent } from './products-form/products-form.component';


const routes: Routes = [
  { path: '', redirectTo: 'users', pathMatch: 'full' },
  { path: 'users', component: UsersComponent },
  { path: 'users/novo', component: UsersFormComponent },
  { path: 'users/:id', component: UsersFormComponent },
  { path: 'products', component: ProductsComponent },
  { path: 'products/novo', component: ProductsFormComponent },
  { path: 'products/:id', component: ProductsFormComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

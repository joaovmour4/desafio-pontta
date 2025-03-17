import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { UsersComponent } from './users/users.component';
import { UsersFormComponent } from './users-form/users-form.component';
import { ProductsComponent } from './products/products.component';
import { ProductsFormComponent } from './products-form/products-form.component';

@NgModule({
  declarations: [
    AppComponent,
    UsersComponent,
    UsersFormComponent,
    ProductsComponent,
    ProductsFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

import { Component, OnInit } from '@angular/core';
import { Product } from '../product';
import { ProductsApiService } from '../products-api.service';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  searchValue: string = ''
  products: Product[] = []

  constructor(private apiService: ProductsApiService) { }

  ngOnInit() {
    this.loadProducts()
  }

  loadProducts(){
    this.apiService.getProducts(this.searchValue).subscribe((data: Product[]) => this.products = data);
  }

}

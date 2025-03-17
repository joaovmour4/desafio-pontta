import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Product } from './Product';

@Injectable({
  providedIn: 'root'
})
export class ProductsApiService {

  private baseUrl = 'http://localhost:8080/products'

  constructor(private httpService: HttpClient) { }

  public getProducts(name: string){
    return this.httpService.get(`${this.baseUrl}?name=${name}`)
  }
  public getProductById(id: number){
    return this.httpService.get(`${this.baseUrl}/${id}`)
  }
  public createProduct(product: Product){
    return this.httpService.post(`${this.baseUrl}`, product)
  }
  public updateProduct(product: Product){
    return this.httpService.put(`${this.baseUrl}/${product.id}`, product)
  }
  public deleteProduct(id: number){
    return this.httpService.delete(`${this.baseUrl}/${id}`)
  }

}

import { environment } from './../../environments/environment';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { Topping } from '../models/topping.model';


@Injectable({
    providedIn: 'root'
})
export class ToppingsService {

    constructor(private http: HttpClient) { }

    public obtenerToppings(): Observable<Topping[]> {

        return this.http.get<Topping[]>(`${environment.server}gestion/mantenimientos/toppings/all`);
    }

    public obtenerToppingPorId(id: number): Observable<Topping> {

        return this.http.get<Topping>(`${environment.server}gestion/mantenimientos/toppings/byId/` + id.toString());

    }

    public insertarTopping(topping: Topping): Observable<Topping> {

        return this.http.post<Topping>(`${environment.server}gestion/mantenimientos/toppings/new`, topping);
    }

    public modificarTopping(topping: Topping): Observable<Topping> {
        return this.http.put<Topping>(`${environment.server}gestion/mantenimientos/toppings/edit`, topping);
    }
}

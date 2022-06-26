import { environment } from './../../environments/environment';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Leche } from '../models/leche.model';



@Injectable({
    providedIn: 'root'
})
export class LechesService {


    constructor(private http: HttpClient) { }

    public obtenerLeche(): Observable<Leche[]> {

        return this.http.get<Leche[]>(`${environment.server}gestion/mantenimientos/toppings/leches/all`);
    }

    public obtenerLechePorId(id: number): Observable<Leche> {

        return this.http.get<Leche>(`${environment.server}gestion/mantenimientos/leches/byId/` + id.toString());

    }

    public insertarLeche(leche: Leche): Observable<Leche> {

        return this.http.post<Leche>(`${environment.server}gestion/mantenimientos/leches/new`, leche);
    }

    public modificarLeche(leche: Leche): Observable<Leche> {
        return this.http.put<Leche>(`${environment.server}gestion/mantenimientos/leches/edit`, leche);
    }
}

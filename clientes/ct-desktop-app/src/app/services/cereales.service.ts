import { environment } from './../../environments/environment';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { Cereal } from '../models/cereal.model'

@Injectable({
    providedIn: 'root'
})
export class CerealService {


    constructor(private http: HttpClient) { }


    public obtenerCereales(): Observable<Cereal[]> {

        return this.http.get<Cereal[]>(`${environment.server}gestion/mantenimientos/cereales/all`);

    }

    public obtenerCerealPorId(id: number): Observable<Cereal> {

        return this.http.get<Cereal>(`${environment.server}gestion/mantenimientos/cereales/byId/` + id.toString());

    }


    public obtenerCerealPorTipo(tipo: number): Observable<Cereal> {

        return this.http.get<Cereal>(`${environment.server}gestion/mantenimientos/cereales/byType/` + tipo.toString());

    }

    public insertarCereal(cereal: Cereal): Observable<Cereal> {

        return this.http.post<Cereal>(`${environment.server}gestion/mantenimientos/cereales/new`, cereal);
    }

    public modificarCereal(cereal: Cereal): Observable<Cereal> {

        return this.http.put<Cereal>(`${environment.server}gestion/mantenimientos/cereales/edit`, cereal);

    }
}

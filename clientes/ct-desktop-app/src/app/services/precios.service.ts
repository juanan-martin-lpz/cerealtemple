import { environment } from './../../environments/environment';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Precios } from '../models/precios.model';

@Injectable({
  providedIn: 'root'
})
export class PreciosService {

  constructor(private http: HttpClient) { }

  public obtenerPreciosTamanio(): Observable<Precios[]>  {
    return this.http.get<Precios[]>(`${environment.server}gestion/mantenimientos/preciostamanios/all`);

  }

  public obtenerPreciosTamanioPorId(id: number): Observable<Precios>  {

    return this.http.get<Precios>(`${environment.server}gestion/mantenimientos/preciostamanios/byId/` + id.toString());

  }

  public insertarPreciosTamanio(precio: Precios): Observable<Precios> {

    return this.http.post<Precios>(`${environment.server}gestion/mantenimientos/preciostamanios/new`, precio);
  }

  public modificarPreciosTamanio(precio: Precios): Observable<Precios> {
    return this.http.put<Precios>(`${environment.server}gestion/mantenimientos/preciostamanios/edit`, precio);
  }

}

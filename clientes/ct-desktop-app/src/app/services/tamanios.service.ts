import { environment } from './../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Tamanios } from '../models/tamanios.model';


@Injectable({
  providedIn: 'root'
})
export class TamaniosService {

  constructor(private http: HttpClient) { }

  public obtenerTamanios(): Observable<Tamanios[]>  {

    return this.http.get<Tamanios[]>(`${environment.server}gestion/mantenimientos/tamanios/all`);
  }

  public obtenerTamanioPorId(id: number): Observable<Tamanios>  {

    return this.http.get<Tamanios>(`${environment.server}gestion/mantenimientos/tamanios/byId/` + id.toString());

  }

  public insertarTamanio(tamanio: Tamanios): Observable<Tamanios> {

    return this.http.post<Tamanios>(`${environment.server}gestion/mantenimientos/tamanios/new`, tamanio);
  }

  public modificarTamanio(tamanio: Tamanios): Observable<Tamanios> {
    return this.http.put<Tamanios>(`${environment.server}gestion/mantenimientos/colores/edit`, tamanio);
  }

}

import { environment } from './../../environments/environment';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Colores } from '../models/colores.model';

@Injectable({
  providedIn: 'root'
})
export class ColoresService {

  constructor(private http: HttpClient) { }

  public obtenerColores(): Observable<Colores[]> {

    return this.http.get<Colores[]>(`${environment.server}gestion/mantenimientos/colores/all`);
  }

  public obtenerColorPorId(id: number): Observable<Colores> {

    return this.http.get<Colores>(`${environment.server}gestion/mantenimientos/colores/byId/` + id.toString());

  }

  public insertarColores(color: Colores): Observable<Colores> {

    return this.http.post<Colores>(`${environment.server}gestion/mantenimientos/colores/new`, color);
  }

  public modificarColores(color: Colores): Observable<Colores> {
    return this.http.put<Colores>(`${environment.server}gestion/mantenimientos/colores/edit`, color);
  }

  public borrarColor(id: number): Observable<string> {

    return this.http.delete<string>(`${environment.server}gestion/mantenimientos/colores/delete/${id}`);

  }
}

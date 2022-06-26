import { environment } from './../../environments/environment';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Precios } from '../models/precios.model';
import { TipoPrecios } from '../models/tipoprecios.model';

@Injectable({
  providedIn: 'root'
})
export class TipopreciosService {

  constructor(private http: HttpClient) { }

  public obtenerTipoPrecios(): Observable<TipoPrecios[]>  {
    return this.http.get<TipoPrecios[]>(`${environment.server}gestion/mantenimientos/tipoprecios/all`);
  }

  public obtenerTipoPrecioPorId(id: number): Observable<TipoPrecios>  {
    return this.http.get<TipoPrecios>(`${environment.server}gestion/mantenimientos/tipoprecios/byId/` + id.toString());
  }

  public insertarTipoPrecio(tipo: TipoPrecios): Observable<TipoPrecios> {

    return this.http.post<TipoPrecios>(`${environment.server}gestion/mantenimientos/tipoprecios/new`, tipo);
  }

  public modificarTipoPrecio(tipo: TipoPrecios): Observable<TipoPrecios> {
    return this.http.put<TipoPrecios>(`${environment.server}gestion/mantenimientos/tipoprecios/edit`, tipo);
  }
}

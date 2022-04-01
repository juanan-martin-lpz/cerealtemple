import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


import { TipoPrecios } from '@app/models/tipoprecios';
import { Precios } from '@app/models/precios';
import { Tamanios } from '@app/models/tamanios';

import { DevelopmentConfig } from '../config/development';
import { abstractConfig } from '../config/abstractConfig';
import { Colores } from '@app/models/colores';

@Injectable({
  providedIn: 'root'
})
export class PreciosService {

  constructor(private http: HttpClient, private config: abstractConfig) { }


  public obtenerTamanios(): Observable<Tamanios[]>  {

    return this.http.get<Tamanios[]>(`${this.config.server}gestion/mantenimientos/tamanios/all`);
  }

  // COLORES
  public obtenerColores(): Observable<Colores[]>  {

    return this.http.get<Colores[]>(`${this.config.server}gestion/mantenimientos/colores/all`);
  }

  public insertarColores(color: Colores): Observable<Colores> {

    return this.http.post<Colores>(`${this.config.server}gestion/mantenimientos/colores/new`, color);
  }

  public modificarColores(color: Colores): Observable<Colores> {
    return this.http.put<Colores>(`${this.config.server}gestion/mantenimientos/colores/edit`, color);
  }

  // TIPO PRECIOS
  public obtenerTipoPrecios(): Observable<TipoPrecios[]>  {
    return this.http.get<TipoPrecios[]>(`${this.config.server}gestion/mantenimientos/tipoprecios/all`);

  }

  public obtenerPrecios(): Observable<Precios[]>  {
    return this.http.get<Precios[]>(`${this.config.server}gestion/mantenimientos/preciostamanios/all`);
  }



}

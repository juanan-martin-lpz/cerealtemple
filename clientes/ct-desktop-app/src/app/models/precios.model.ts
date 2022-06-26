import { TipoPrecios } from './tipoprecios.model';
import { Tamanios } from './tamanios.model';


export interface Precios {
  idprecio_tamanio: number;
  tipoprecio: TipoPrecios;
  tamanio: Tamanios;
  precio: number;

}

import { createAction, props } from '@ngrx/store';
import { TipoPrecios } from '../../models/tipoprecios.model';


export const CargarTipoPrecios = createAction('[TIPOPRECIOS] Cargar Tipo Precios');
export const CargarTipoPreciosSuccess = createAction('[TIPOPRECIOS] Cargar Tipo Precios Exito', props<{tipoprecios: TipoPrecios[]}>());
export const CargarTipoPreciosFailure = createAction('[TIPOPRECIOS] Cargar Tipo Precios Fallo', props<{error: string}>());

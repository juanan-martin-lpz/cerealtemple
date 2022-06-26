import { createAction, props } from '@ngrx/store';
import { Precios } from '../../models/precios.model';


export const CargarPrecios = createAction('[PRECIOS] Cargar Precios');
export const CargarPreciosSuccess = createAction('[PRECIOS] Cargar Precios Exito', props<{precios: Precios[]}>());
export const CargarPreciosFailure = createAction('[PRECIOS] Cargar Precios Fallo', props<{error: string}>());

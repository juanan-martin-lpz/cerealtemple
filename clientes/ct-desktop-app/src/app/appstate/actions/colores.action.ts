import { createAction, props } from '@ngrx/store';
import { Colores } from '../../models/colores.model';


export const CargarColores = createAction('[COLORES] Cargar Colores');
export const CargarColoresSuccess = createAction('[COLORES] Cargar Colores Exito', props<{colores: Colores[]}>());
export const CargarColoresFailure = createAction('[COLORES] Cargar Colores Fallo', props<{error: string}>());

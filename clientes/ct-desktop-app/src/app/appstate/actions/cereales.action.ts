import { createAction, props } from '@ngrx/store';
import { Cereal } from '../../models/cereal.model';


export const CargarCereales = createAction('[CEREALES] Cargar Cereales');
export const CargarCerealesSuccess = createAction('[CEREALES] Cargar Cereales Exito', props<{cereales: Cereal[]}>());
export const CargarCerealesFailure = createAction('[CEREALES] Cargar Cereales Fallo', props<{error: string}>());

import { createAction, props } from '@ngrx/store';
import { Tamanios } from '../../models/tamanios.model';


export const CargarTamanios = createAction('[TAMANIOS] Cargar Tamanios');
export const CargarTamaniosSuccess = createAction('[TAMANIOS] Cargar Tamanios Exito', props<{tamanios: Tamanios[]}>());
export const CargarTamaniosFailure = createAction('[TAMANIOS] Cargar Tamanios Fallo', props<{error: string}>());

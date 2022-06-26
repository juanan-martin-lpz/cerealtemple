import { createAction, props } from '@ngrx/store';
import { Leche } from '../../models/leche.model';


export const CargarLeches = createAction('[LECHES] Cargar Leches');
export const CargarLechesSuccess = createAction('[LECHES] Cargar Leches Exito', props<{leches: Leche[]}>());
export const CargarLechesFailure = createAction('[LECEHS] Cargar Leches Fallo', props<{error: string}>());

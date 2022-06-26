import { createAction, props } from '@ngrx/store';
import { Topping } from '../../models/topping.model';


export const CargarToppings = createAction('[TOPPINGS] Cargar Toppings');
export const CargarToppingsSuccess = createAction('[TOPPINGS] Cargar Toppings Exito', props<{toppings: Topping[]}>());
export const CargarToppingsFailure = createAction('[TOPPINGS] Cargar Toppings Exito', props<{error: string}>());

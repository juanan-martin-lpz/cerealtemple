import { Cereal } from '../../models/cereal.model';
import { Leche } from '../../models/leche.model';
import { Topping } from '../../models/topping.model';
import { Precios } from '../../models/precios.model';
import { Tamanios } from '../../models/tamanios.model';
import { TipoPrecios } from '../../models/tipoprecios.model';
import { createReducer, on } from '@ngrx/store';

import * as CerealesActions from '../actions/cereales.action';
import * as ColoresActions from '../actions/colores.action';
import * as LechesActions from '../actions/leches.action';
import * as PreciosActions from '../actions/precios.action';
import * as TamaniosActions from '../actions/tamanios.action';
import * as TipoPreciosActions from '../actions/tipoprecios.action';
import * as ToppingsActions from '../actions/toppings.action';
import { Colores } from '../../models/colores.model';


export interface AppState {
  cereales: Cereal[];
  leches: Leche[];
  toppings: Topping[];
  precios: Precios[];
  tamanios: Tamanios[];
  preciosTamanio: TipoPrecios[];
  colores: Colores[];
}

export const initialState: AppState = {
  cereales: [],
  leches: [],
  toppings: [],
  precios: [],
  tamanios: [],
  colores: [],
  preciosTamanio: []
}

export const appReducer = createReducer(
  initialState,
  on(CerealesActions.CargarCereales, (state) => ({...state})),
  on(CerealesActions.CargarCerealesSuccess, (state, { cereales }) => ({...state, cereales})),
  on(CerealesActions.CargarCerealesFailure, (state, { error }) => ({...state, error})),
  on(ColoresActions.CargarColores, (state) => ({...state})),
  on(ColoresActions.CargarColoresSuccess, (state, { colores }) => ({...state, colores})),
  on(ColoresActions.CargarColoresFailure, (state, { error }) => ({...state, error})),
  on(LechesActions.CargarLeches, (state) => ({...state})),
  on(LechesActions.CargarLechesSuccess, (state, { leches }) => ({...state, leches})),
  on(LechesActions.CargarLechesFailure, (state, { error }) => ({...state, error})),
  on(PreciosActions.CargarPrecios, (state) => ({...state})),
  on(PreciosActions.CargarPreciosSuccess, (state, { precios }) => ({...state, precios})),
  on(PreciosActions.CargarPreciosFailure, (state, { error }) => ({...state, error})),
  on(TamaniosActions.CargarTamanios, (state) => ({...state})),
  on(TamaniosActions.CargarTamaniosSuccess, (state, { tamanios }) => ({...state, tamanios})),
  on(TamaniosActions.CargarTamaniosFailure, (state, { error }) => ({...state, error})),
  on(TipoPreciosActions.CargarTipoPrecios, (state) => ({...state})),
  on(TipoPreciosActions.CargarTipoPreciosSuccess, (state, { tipoprecios }) => ({...state, tipoprecios })),
  on(TipoPreciosActions.CargarTipoPreciosFailure, (state, { error }) => ({...state, error})),
  on(ToppingsActions.CargarToppings, (state) => ({...state})),
  on(ToppingsActions.CargarToppingsSuccess, (state, { toppings }) => ({...state, toppings })),
  on(ToppingsActions.CargarToppingsFailure, (state, { error }) => ({...state, error}))
})

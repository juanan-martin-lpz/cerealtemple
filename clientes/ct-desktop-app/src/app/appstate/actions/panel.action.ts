import { createAction, props } from "@ngrx/store";


export const PanelAction = createAction('[Panel] Carga de Panel');
export const PanelActionSuccess = createAction('[Panel] Carga de Panel Exito');
export const PanelActionFailure = createAction('[Panel] Carga de Panel Fallo', props<{error: string}>());


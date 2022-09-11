import { Routes, RouterModule } from '@angular/router';
import { MantenimientosComponent } from './negocio/mantenimientos/mantenimientos.component';
import { DashboardComponent } from './negocio/dashboard/dashboard.component';


const appRoutes: Routes = [
  { path: '', component: DashboardComponent },
  { path: 'mantenimientos', component: MantenimientosComponent}
];

export const routing = RouterModule.forRoot(appRoutes);

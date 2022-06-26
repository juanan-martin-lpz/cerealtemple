import { Routes, RouterModule } from '@angular/router';
import { DashboardComponent } from './negocio/dashboard/dashboard.component';

const appRoutes: Routes = [
    { path: '', component: DashboardComponent }
];

export const routing = RouterModule.forRoot(appRoutes);

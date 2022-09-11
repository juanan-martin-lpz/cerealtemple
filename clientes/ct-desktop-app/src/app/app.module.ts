import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';

import { routing } from './app.routing';

// Primeng imports
import {Menubar, MenubarModule} from 'primeng/menubar';
import {MenuItem} from 'primeng/api';
import {ChipsModule} from 'primeng/chips';

// Componentes
import { MantenimientosComponent } from './negocio/mantenimientos/mantenimientos.component';
import { AppComponent } from './app.component';
import { TopPanelComponent } from './layout/top-panel/top-panel.component';
import { FooterPanelComponent } from './layout/footer-panel/footer-panel.component';
import { MenuComponent } from './common/menu/menu.component';
import { DashboardComponent } from './negocio/dashboard/dashboard.component';


// Servicios
import { ColoresService } from './services/colores.service';

@NgModule({
  declarations: [
    AppComponent,
    TopPanelComponent,
    FooterPanelComponent,
    MenuComponent,
    MantenimientosComponent,
    DashboardComponent
   ],
  imports: [
    BrowserModule,
    routing,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    MenubarModule,
    ChipsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

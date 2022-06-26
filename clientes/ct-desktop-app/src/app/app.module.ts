import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { TopPanelComponent } from './layout/top-panel/top-panel.component';
import { FooterPanelComponent } from './layout/footer-panel/footer-panel.component';
import { MenuComponent } from './common/menu/menu.component';

import { routing } from './app.routing';
import { DashboardComponent } from './negocio/dashboard/dashboard.component';

// Primeng imports
import {Menubar, MenubarModule} from 'primeng/menubar';
import {MenuItem} from 'primeng/api';

@NgModule({
  declarations: [
    AppComponent,
    TopPanelComponent,
    FooterPanelComponent,
    MenuComponent,
    DashboardComponent
   ],
  imports: [
    BrowserModule,
    routing,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    MenubarModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

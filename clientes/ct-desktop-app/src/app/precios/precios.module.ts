import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TranslateModule } from '@ngx-translate/core';
import { FlexLayoutModule } from '@angular/flex-layout';

import { SharedModule } from '@shared';
import { MaterialModule } from '@app/material.module';
import { DashboardComponent } from './dashboard.component';
import { PreciosRoutingModule } from './precios-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { DevelopmentConfig } from '../config/development';
import { abstractConfig } from '@app/config/abstractConfig';
import { TamaniosGridComponent } from './tamanios-grid/tamanios-grid.component';
import { FormsModule } from '@angular/forms';
import { TipoPreciosComponent } from './tipo-precios/tipo-precios.component';
import { ColoresGridComponent } from './colores-grid/colores-grid.component';


@NgModule({
  declarations: [
    DashboardComponent,
    TamaniosGridComponent,
    TipoPreciosComponent,
    ColoresGridComponent
  ],
  imports: [
    CommonModule,
    TranslateModule,
    SharedModule,
    FlexLayoutModule,
    MaterialModule,
    HttpClientModule,
    FormsModule,
    PreciosRoutingModule
  ],
  providers: [{provide: abstractConfig, useClass: DevelopmentConfig}]
})
export class PreciosModule { }

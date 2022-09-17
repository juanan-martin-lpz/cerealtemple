import { Component, OnInit } from '@angular/core';
import { MessageService } from 'primeng/api';

import { tap } from 'rxjs';

import { Leche } from 'src/app/models/leche.model';
import { Precios } from 'src/app/models/precios.model';
import { Tamanios } from 'src/app/models/tamanios.model';
import { TipoPrecios } from 'src/app/models/tipoprecios.model';
import { Topping } from 'src/app/models/topping.model';
import { ColoresService } from 'src/app/services/colores.service';
import { LechesService } from 'src/app/services/leches.service';
import { PreciosService } from 'src/app/services/precios.service';
import { TamaniosService } from 'src/app/services/tamanios.service';
import { TipopreciosService } from 'src/app/services/tipoprecios.service';
import { ToppingsService } from 'src/app/services/toppings.service';
import { Colores } from '../../models/colores.model';


@Component({
  selector: 'app-mantenimientos',
  templateUrl: './mantenimientos.component.html',
  styleUrls: ['./mantenimientos.component.scss'],
  providers: [MessageService]
})
export class MantenimientosComponent implements OnInit {


  public colores: string[] = [];
  public tamanios: string[] = [];

  public aColores: Colores[] = [];
  public aTamanios: Tamanios[] = [];
  public aPrecios: Precios[] = [];
  public aTipoPrecios: TipoPrecios[] = [];
  public aToppings: Topping[] = [];
  public aLeches: Leche[] = [];

  public asColores: string[] = [];
  public asTamanios: string[] = [];
  public asTipoPrecios: string[] = [];


  constructor(private coloresSvc: ColoresService,
              private tamaniosSvc: TamaniosService,
              private preciosSvc: PreciosService,
              private tiposPreSvc: TipopreciosService,
              private toppingSvc: ToppingsService,
              private lechesSvc: LechesService,
              private messageSvc: MessageService) {

    this.coloresSvc.obtenerColores().subscribe((colores: Colores[]) => {
      this.aColores = colores;
      this.asColores = this.aColores.map(item => item.nombre)
    });

    this.tamaniosSvc.obtenerTamanios().subscribe((tamanios: Tamanios[]) => {
      this.aTamanios = tamanios
      this.asTamanios = this.aTamanios.map(item => item.nombre)
    })

    this.preciosSvc.obtenerPreciosTamanio().subscribe((precios: Precios[]) => {
      this.aPrecios = precios
   });

    this.tiposPreSvc.obtenerTipoPrecios().subscribe((tiposPre: TipoPrecios[]) => {
      this.aTipoPrecios = tiposPre
      this.asTipoPrecios = this.aTipoPrecios.map(item => item.tipo_precio)
    })

    this.toppingSvc.obtenerToppings().subscribe((toppings: Topping[]) => this.aToppings = toppings)

    this.lechesSvc.obtenerLeche().subscribe((leches: Leche[]) => this.aLeches = leches)




  }

  ngOnInit(): void {

  }

  addColor(event: any) {


    let color = new Colores()
    color.nombre = event.value;

    this.aColores.push(color);

    this.coloresSvc.insertarColores(color).subscribe(color => {
      this.messageSvc.add({severity:'success', summary:'Guardado', detail:'Color guardado con exito'});
    })
  }


  removeColor(event: any) {

    let idColor = this.aColores.filter(item => item.nombre == event.value)[0].idcolor;

    this.aColores = this.aColores.filter(item => item.nombre != event.value)

    this.coloresSvc.borrarColor(idColor)
      .subscribe(item => {
        this.messageSvc.add({severity:'success', summary:'Borrado', detail:'Color borrado con exito'});
      })
  }


  addTamanio(event: any) {


    let tamanio = new Tamanios();

    tamanio.nombre = event.value;

    this.aTamanios.push(tamanio);

    this.tamaniosSvc.insertarTamanio(tamanio).subscribe(tamanio => {
      this.messageSvc.add({severity:'success', summary:'Guardado', detail:'Tamaño guardado con exito'});
    })
  }


  removeTamanio(event: any) {

    let idTamanio= this.aTamanios.filter(item => item.nombre == event.value)[0].idtamanio;

    this.aTamanios = this.aTamanios.filter(item => item.nombre != event.value)

    this.tamaniosSvc.borrarTamanio(idTamanio)
      .subscribe(item => {
        this.messageSvc.add({severity:'success', summary:'Borrado', detail:`Tamaño ${item.nombre} borrado con exito`});
      })
  }

}

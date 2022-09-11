import { Component, OnInit } from '@angular/core';
import { ColoresService } from 'src/app/services/colores.service';
import { Colores } from '../../models/colores.model';


@Component({
  selector: 'app-mantenimientos',
  templateUrl: './mantenimientos.component.html',
  styleUrls: ['./mantenimientos.component.scss']
})
export class MantenimientosComponent implements OnInit {


  public colores: string[] = [];
  public tamanios: string[] = [];

  constructor(public coloresSvc: ColoresService) {

    this.coloresSvc.obtenerColores().subscribe((colores: Colores[]) => this.colores = colores.map(item => item.nombre));

  }

  ngOnInit(): void {
  }

}

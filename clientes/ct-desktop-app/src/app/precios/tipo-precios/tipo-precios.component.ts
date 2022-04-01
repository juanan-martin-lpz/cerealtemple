import { Component, OnInit } from '@angular/core';
import { TipoPrecios } from '../../models/tipoprecios';
import { PreciosService } from '../precios.service';

@Component({
  selector: 'app-tipo-precios',
  templateUrl: './tipo-precios.component.html',
  styleUrls: ['./tipo-precios.component.scss']
})
export class TipoPreciosComponent implements OnInit {

  listaTipos: TipoPrecios[] = [];
  displayedColumns: string[] = ['idprecio', 'tipo_precio'];

  selectedRow!: TipoPrecios;

  public tipo!: string;

  constructor(private servicio: PreciosService) {
    servicio.obtenerTipoPrecios().subscribe( items => {
      this.listaTipos = items;
    });
  }

  ngOnInit(): void {
  }

  public selectRow(row: TipoPrecios): void {
      this.selectedRow = row;
      this.tipo = row.tipo_precio;
  }
}

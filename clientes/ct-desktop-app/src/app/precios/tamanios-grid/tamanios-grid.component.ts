import { Component, OnInit } from '@angular/core';
import { Tamanios } from '@app/models/tamanios';
import { PreciosService } from '../precios.service';

@Component({
  selector: 'app-tamanios-grid',
  templateUrl: './tamanios-grid.component.html',
  styleUrls: ['./tamanios-grid.component.scss']
})
export class TamaniosGridComponent implements OnInit {

  listaTamanios: Tamanios[] = [];
  displayedColumns: string[] = ['idtamanio', 'nombre'];

  selectedRow!: Tamanios;

  public tamanio!: string;

  constructor(private servicio: PreciosService) {
    servicio.obtenerTamanios().subscribe( items => {
      this.listaTamanios = items;
    });
  }

  ngOnInit(): void {
  }

  public selectRow(row: Tamanios): void {
      this.selectedRow = row;
      this.tamanio = row.nombre;
  }
}

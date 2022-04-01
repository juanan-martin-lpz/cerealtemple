import { Component, OnInit } from '@angular/core';

import { Colores } from '@app/models/colores';
import { PreciosService } from '../precios.service';

@Component({
  selector: 'app-colores-grid',
  templateUrl: './colores-grid.component.html',
  styleUrls: ['./colores-grid.component.scss']
})
export class ColoresGridComponent implements OnInit {


  listaColores: Colores[] = [];
  displayedColumns: string[] = ['idcolor', 'nombre'];

  selectedRow!: Colores;

  public color!: string;

  constructor(private servicio: PreciosService) {
    servicio.obtenerColores().subscribe( items => {
      this.listaColores = items;
    });
  }

  ngOnInit(): void {
  }

  public selectRow(row: Colores): void {
      this.selectedRow = row;
      this.color = row.nombre;
  }

  public guardar() {
    if (this.selectedRow != null) {
      // Modificacion
      // Si el nombre es igual no se envia y se deselecciona
      if (this.color == this.selectedRow.nombre) {
        this.selectedRow = null;
        this.color = "";
      }
      else {
        // Es una modificacion
        let modificado: Colores = {
          idcolor: this.selectedRow.idcolor,
          nombre: this.color
        };

        this.servicio.modificarColores(modificado).subscribe(resultado => {
          if (resultado) {
            this.servicio.obtenerColores().subscribe( items => {
              this.listaColores = items;
            });
          }
        });
      }
    }
    else {
      // Insercion
      let nuevo: Colores = {
        idcolor: null,
        nombre: this.color
      };

      this.servicio.insertarColores(nuevo).subscribe(resultado => {
        if (resultado) {
          this.servicio.obtenerColores().subscribe( items => {
            this.listaColores = items;
          });
        }
      });

    }
  }
}

import { Byte } from "@angular/compiler/src/util";

export interface Cereal {
  idcereal: number;
  nombre: string;
  descripcion: string;
  imagen: Byte[];
  precio: number;
}


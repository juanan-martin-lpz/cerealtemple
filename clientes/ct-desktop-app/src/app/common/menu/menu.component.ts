import { Component, OnInit } from '@angular/core';
import { MenuItem } from 'primeng/api';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.scss']
})
export class MenuComponent implements OnInit {

  items!: MenuItem[];

  constructor() {
  }

  ngOnInit(): void {
    this.items = [
      { label: "Panel"},
      {
          label: 'Mantenimientos',
          items: [
              {label: 'Tipos de Precio'},
              {label: 'Tamanios'},
              {label: 'Precios por Tamanio'},
              {label: 'Colores'}
          ]
      },
      {
          label: 'Cereales',
          items: [
              {label: 'Cereales'},
              {label: 'Leches'},
              {label: 'Toppings'}

          ]
      }
  ];
  }

}

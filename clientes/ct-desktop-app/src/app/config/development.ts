import { Injectable } from '@angular/core';
import { abstractConfig } from './abstractConfig';

@Injectable({
  providedIn: 'root'
})
export class DevelopmentConfig extends abstractConfig {
  public override server: string = "http://localhost:9100/"

}

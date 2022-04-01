import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TamaniosGridComponent } from './tamanios-grid.component';

describe('TamaniosGridComponent', () => {
  let component: TamaniosGridComponent;
  let fixture: ComponentFixture<TamaniosGridComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TamaniosGridComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TamaniosGridComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

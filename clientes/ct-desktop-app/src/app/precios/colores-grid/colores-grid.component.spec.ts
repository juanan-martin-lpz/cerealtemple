import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ColoresGridComponent } from './colores-grid.component';

describe('ColoresGridComponent', () => {
  let component: ColoresGridComponent;
  let fixture: ComponentFixture<ColoresGridComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ColoresGridComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ColoresGridComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

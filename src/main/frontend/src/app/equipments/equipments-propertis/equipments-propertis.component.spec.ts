import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EquipmentsPropertisComponent } from './equipments-propertis.component';

describe('EquipmentsPropertisComponent', () => {
  let component: EquipmentsPropertisComponent;
  let fixture: ComponentFixture<EquipmentsPropertisComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EquipmentsPropertisComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EquipmentsPropertisComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

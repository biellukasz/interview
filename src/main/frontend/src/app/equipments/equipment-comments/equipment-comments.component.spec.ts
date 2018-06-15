import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EquipmentCommentsComponent } from './equipment-comments.component';

describe('EquipmentCommentsComponent', () => {
  let component: EquipmentCommentsComponent;
  let fixture: ComponentFixture<EquipmentCommentsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EquipmentCommentsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EquipmentCommentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

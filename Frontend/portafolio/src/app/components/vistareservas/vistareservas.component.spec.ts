import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VistareservasComponent } from './vistareservas.component';

describe('VistareservasComponent', () => {
  let component: VistareservasComponent;
  let fixture: ComponentFixture<VistareservasComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VistareservasComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VistareservasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RcontrasenhaComponent } from './rcontrasenha.component';

describe('RcontrasenhaComponent', () => {
  let component: RcontrasenhaComponent;
  let fixture: ComponentFixture<RcontrasenhaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RcontrasenhaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RcontrasenhaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

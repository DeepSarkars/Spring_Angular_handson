import { ComponentFixture, TestBed } from '@angular/core/testing';

import { QualityIncrementComponent } from './quality-increment.component';

describe('QualityIncrementComponent', () => {
  let component: QualityIncrementComponent;
  let fixture: ComponentFixture<QualityIncrementComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ QualityIncrementComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(QualityIncrementComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

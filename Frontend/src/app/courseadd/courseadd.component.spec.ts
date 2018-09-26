import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CourseaddComponent } from './courseadd.component';

describe('CourseaddComponent', () => {
  let component: CourseaddComponent;
  let fixture: ComponentFixture<CourseaddComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CourseaddComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CourseaddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

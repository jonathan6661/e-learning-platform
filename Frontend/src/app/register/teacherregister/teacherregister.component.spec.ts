import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TeacherregisterComponent } from './teacherregister.component';

describe('TeacherregisterComponent', () => {
  let component: TeacherregisterComponent;
  let fixture: ComponentFixture<TeacherregisterComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TeacherregisterComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TeacherregisterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

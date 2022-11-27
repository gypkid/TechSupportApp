import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TaskMyComponent } from './task-my.component';

describe('TaskMyComponent', () => {
  let component: TaskMyComponent;
  let fixture: ComponentFixture<TaskMyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TaskMyComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TaskMyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

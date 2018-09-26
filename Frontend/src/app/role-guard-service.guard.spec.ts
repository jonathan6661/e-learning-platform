import { TestBed, async, inject } from '@angular/core/testing';

import { RoleGuardServiceGuard } from './role-guard-service.guard';

describe('RoleGuardServiceGuard', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [RoleGuardServiceGuard]
    });
  });

  it('should ...', inject([RoleGuardServiceGuard], (guard: RoleGuardServiceGuard) => {
    expect(guard).toBeTruthy();
  }));
});

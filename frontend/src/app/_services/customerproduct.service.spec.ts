import { TestBed } from '@angular/core/testing';

import { CustomerproductService } from './customerproduct.service';

describe('CustomerproductService', () => {
  let service: CustomerproductService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CustomerproductService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});

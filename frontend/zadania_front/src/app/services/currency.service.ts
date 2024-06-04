import { Injectable } from '@angular/core';
import { CurrencyValueRequest } from '../models/currencyValueRequest';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CurrencyValueResponse } from '../models/currencyValueResponse';

@Injectable({
  providedIn: 'root',
})
export class CurrencyService {
  apiUrl = 'http://localhost:8080/currencies';

  constructor(private httpClient: HttpClient) {}

  getCurrencyValue(
    request: CurrencyValueRequest
  ): Observable<CurrencyValueResponse> {
    return this.httpClient.post<CurrencyValueResponse>(
      this.apiUrl + '/get-current-currency-value-command',
      request
    );
  }
}

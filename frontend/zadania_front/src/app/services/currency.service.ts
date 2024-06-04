import { Injectable } from '@angular/core';
import { CurrencyValueRequest } from '../models/currencyValueRequest';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CurrencyValueResponse } from '../models/currencyValueResponse';
import { HistoryResponse } from '../models/historyResponse';

@Injectable({
  providedIn: 'root',
})
export class CurrencyService {
  public apiUrl: string = 'http://localhost:8080/currencies';

  constructor(private httpClient: HttpClient) {}

  public getCurrencyValue(
    request: CurrencyValueRequest
  ): Observable<CurrencyValueResponse> {
    return this.httpClient.post<CurrencyValueResponse>(
      this.apiUrl + '/get-current-currency-value-command',
      request
    );
  }

  public getHistory(): Observable<HistoryResponse> {
    return this.httpClient.get<HistoryResponse>(this.apiUrl + '/requests');
  }
}

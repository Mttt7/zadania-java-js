import { Component, OnInit } from '@angular/core';
import { CurrencyService } from '../../services/currency.service';
import { HistoryResponse } from '../../models/historyResponse';

@Component({
  selector: 'app-history',
  templateUrl: './history.component.html',
  styleUrl: './history.component.css',
})
export class HistoryComponent implements OnInit {
  public history: HistoryResponse = [];
  public loading: boolean = false;

  constructor(private currencyService: CurrencyService) {}

  ngOnInit(): void {
    this.loading = true;
    this.currencyService.getHistory().subscribe((data) => {
      this.history = data;
      this.loading = false;
    });
  }
}

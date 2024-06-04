import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { CurrencyService } from '../../services/currency.service';
import { CurrencyValueRequest } from '../../models/currencyValueRequest';
import { CurrencyValueResponse } from '../../models/currencyValueResponse';
import { toast } from 'ngx-sonner';

@Component({
  selector: 'app-request-form',
  templateUrl: './request-form.component.html',
  styleUrl: './request-form.component.css',
})
export class RequestFormComponent implements OnInit {
  loading: boolean = false;

  response: CurrencyValueResponse = {} as CurrencyValueResponse;

  code: string = '';

  constructor(private currencyService: CurrencyService) {}

  ngOnInit(): void {
    //throw new Error('Method not implemented.');
  }

  form: FormGroup = new FormGroup({
    code: new FormControl('', [
      Validators.required,
      Validators.minLength(3),
      Validators.maxLength(3),
    ]),
    fullName: new FormControl('', [
      Validators.required,
      Validators.minLength(3),
      Validators.maxLength(50),
      Validators.pattern('^[A-Z][a-z]+ [A-Z][a-z]+$'),
    ]),
  });

  onSubmit() {
    if (this.form.invalid) {
      if (this.form.controls['code'].invalid) {
        toast.error('Code invalid');
      } else if (this.form.controls['fullName'].invalid) {
        toast.error('Full name has to be in format: Name Surname');
      }
      return;
    }
    this.code = this.form.value.code;
    this.loading = true;
    const request = {
      currency: this.form.value.code,
      name: this.form.value.fullName,
    } as CurrencyValueRequest;
    this.currencyService.getCurrencyValue(request).subscribe((response) => {
      this.response = response;
      this.loading = false;
    });
  }
}

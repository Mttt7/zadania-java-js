import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-result-view',
  templateUrl: './result-view.component.html',
  styleUrl: './result-view.component.css',
})
export class ResultViewComponent {
  @Input() value: number;
  @Input() code: string;
}

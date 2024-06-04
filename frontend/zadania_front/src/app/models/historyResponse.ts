export interface HistoryResponseItem {
  currency: string;
  name: string;
  date: Date;
  value: number;
}

export type HistoryResponse = HistoryResponseItem[];

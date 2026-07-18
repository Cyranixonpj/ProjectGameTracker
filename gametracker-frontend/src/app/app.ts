import { Component, signal, inject, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './app.html',
  styleUrls: ['./app.css']
})
export class App implements OnInit {
  gameData = signal<any>(null);

  private http = inject(HttpClient);
  ngOnInit() {

    this.http.get('http://localhost:8080/api/games/mgs').subscribe({
      next: (data) => {

        this.gameData.set(data);
      },
      error: (err) => {
        console.error('Błąd pobierania danych ze Spring Boota:', err);
      }
    });
  }
}

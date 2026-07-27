import { Component, OnInit, inject , signal} from '@angular/core';
import {CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';



export interface Game{
  id: number;
  title: string;
  developer: string;
  rating: number;
  review: string;
}
@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './app.html',
  styleUrl: './app.css',
})
export class AppComponent implements OnInit {
  title = 'GameTracker';

  private http = inject(HttpClient);
  games = signal<Game[]>([]);
  averageRating = signal<number>(0);

  ngOnInit(): void {
    this.fetchGames();

  }
  fetchGames(): void {
    this.http.get<Game[]>('http://localhost:8081/api/games').subscribe({
      next: (data) => {
        console.log(data);
        this.games.set(data);
        const avg = this.calculateAverageRating(data);
        this.averageRating.set(avg);
      },
      error: (err) => {
        console.error('Błąd podczas pobierania gier', err);
      },

    });
  }
  calculateAverageRating(gameList: Game[]): number{
    if(gameList.length===0){
      return 0
    }
    let sum = 0;

    for (const game of gameList){
      sum+=game.rating
    }
    return sum/gameList.length;

  }
}

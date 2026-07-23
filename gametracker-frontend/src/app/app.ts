import { Component, signal } from '@angular/core';
import {CommonModule} from '@angular/common';


export interface Game{
  id: number;
  title: string;
  genre: string;
  rating: number;
}
@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class AppComponent {
  title = 'Gametracker';
  games: Game[] = [{
    id: 1,
    title: 'The Legend of Zelda: Breath of the Wild',
    genre: 'Action-adventure',
    rating: 10
  },
  {
    id: 2,
    title: 'Super Mario Odyssey',
    genre: 'Platformer',
    rating: 9
  },
  {
    id: 3,
    title: 'Red Dead Redemption 2',
    genre: 'Action-adventure',
    rating: 10
  },
  {
    id: 4,
    title: 'The Witcher 3: Wild Hunt',
    genre: 'Action RPG',
    rating: 9
  }

  ]

}

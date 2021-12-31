import { Component, OnInit, ChangeDetectionStrategy } from '@angular/core';
import {Observable, tap} from "rxjs";
import {Game} from "../../../types/game";
import {GameService} from "../../services/game.service";
import {ThemePalette} from "@angular/material/core";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-game-detail',
  templateUrl: './game-detail.component.html',
  styleUrls: ['./game-detail.component.scss', '../../app.component.scss'],
  changeDetection: ChangeDetectionStrategy.OnPush
})
export class GameDetailComponent implements OnInit {
  game$: Observable<Game> | undefined;
  slideIndex = 1;
  screenshotAmount: number | undefined;
  storeAmount: number | undefined;
  availableColors: ThemePalette[] = ['primary', 'accent', 'warn'];

  // @ts-ignore
  constructor(private readonly gameService: GameService,
              private route: ActivatedRoute) {
    const id = this.route.snapshot.paramMap.get('id');

    // @ts-ignore
    this.game$ = gameService.find(id)
      .pipe(
        tap((game)=> {
          this.screenshotAmount = game.screenshots?.length;
          this.storeAmount = game.stores.length;
          this.showSlides(1);
        }));
  }

  // Next/previous controls
  plusSlides(n: number) {
    this.showSlides(this.slideIndex += n);
  }

  // Thumbnail image controls
  currentSlide(n: number) {
    this.showSlides(this.slideIndex = n);
  }

  showSlides(n: number) {
    // get slides and dots elements
    const slides = document.getElementsByClassName("mySlides") as HTMLCollectionOf<HTMLElement>;
    const dots = document.getElementsByClassName("dot") as HTMLCollectionOf<HTMLElement>;

    // reset n to 1 if bigger than length
    if (n > slides.length) {
      this.slideIndex = 1
    }
    // set n to max if less than one
    else if (n < 1) {
      this.slideIndex = slides.length
    }

    // set display to none for all images
    for (let i = 0; i < slides.length; i++) {
      slides[i].style.display = "none";
      if (dots[i])
        dots[i].className = dots[i].className.replace(" active", "");
    }

    // set currently selected to be viewable
    if (slides[this.slideIndex - 1])
      slides[this.slideIndex - 1].style.display = "block";
    if (dots[this.slideIndex - 1])
      dots[this.slideIndex - 1].className += " active";
  }

  ngOnInit(): void {
  }
}

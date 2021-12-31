import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {SearchComponent} from "./components/search/search.component";
import {GameDetailComponent} from "./components/game-detail/game-detail.component";
import {TagComponent} from "./components/tag/tag.component";
import {DeveloperComponent} from "./components/developer/developer.component";
import {GenreComponent} from "./components/genre/genre.component";
import {PlatformComponent} from "./components/platform/platform.component";
import {ErrorComponent} from "./components/error/error.component";


const routes: Routes = [
  { path: '', component: SearchComponent},
  { path: 'games/:id', component: GameDetailComponent},
  { path: 'tags/:id', component: TagComponent},
  { path: 'developers/:id', component: DeveloperComponent},
  { path: 'genres/:id', component: GenreComponent},
  { path: 'platforms/:id', component: PlatformComponent},
  { path: '**', component: ErrorComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { GameDetailComponent } from './components/game-detail/game-detail.component';
import {HttpClientModule} from "@angular/common/http";
import {MatTabsModule} from "@angular/material/tabs";
import {MatGridListModule} from "@angular/material/grid-list";
import {MatToolbarModule} from "@angular/material/toolbar";
import { ErrorComponent } from './components/error/error.component';
import {MatChipsModule} from "@angular/material/chips";
import { SearchComponent } from './components/search/search.component';
import { DeveloperComponent } from './components/developer/developer.component';
import { TagComponent } from './components/tag/tag.component';
import { GenreComponent } from './components/genre/genre.component';
import { FooterComponent } from './components/footer/footer.component';
import { HeaderComponent } from './components/header/header.component';
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";
import {ReactiveFormsModule} from "@angular/forms";
import { PlatformComponent } from './components/platform/platform.component';
import {MatButtonModule} from "@angular/material/button";


@NgModule({
  declarations: [
    AppComponent,
    GameDetailComponent,
    ErrorComponent,
    SearchComponent,
    DeveloperComponent,
    TagComponent,
    GenreComponent,
    FooterComponent,
    HeaderComponent,
    PlatformComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    MatTabsModule,
    MatGridListModule,
    MatToolbarModule,
    MatChipsModule,
    MatFormFieldModule,
    MatInputModule,
    ReactiveFormsModule,
    AppRoutingModule,
    MatButtonModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

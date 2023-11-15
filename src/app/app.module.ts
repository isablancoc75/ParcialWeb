// app.module.ts

import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { LibroListComponent } from './components/libro-list.component';
import { LibroFormComponent } from './components/libro-form.component';
import { LibroService } from './services/libro.service';

@NgModule({
  declarations: [AppComponent, LibroListComponent, LibroFormComponent],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    RouterModule.forRoot([
      { path: '', component: LibroListComponent },
      { path: 'libros', component: LibroListComponent },
      { path: 'insertar-libro', component: LibroFormComponent },
    ]),
  ],
  providers: [LibroService],
  bootstrap: [AppComponent],
})
export class AppModule {}

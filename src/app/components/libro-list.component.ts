// libro-list.component.ts

import { Component, OnInit } from '@angular/core';
import { LibroService } from '../services/libro.service';
import { Libro } from '../models/libro.model'; 

@Component({
  selector: 'app-libro-list',
  templateUrl: './libro-list.component.html',
  styleUrls: ['./libro-list.component.css'],
})
export class LibroListComponent implements OnInit {
  libros: Libro[] = [];

  constructor(private libroService: LibroService) {}

  ngOnInit(): void {
    this.loadLibros();
  }

  private loadLibros() {
    this.libroService.getLibros().subscribe(
      (data) => {
        this.libros = data;
      },
      (error) => {
        console.error('Error al obtener libros', error);
      }
    );
  }
}

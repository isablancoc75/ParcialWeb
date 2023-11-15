// libro-form.component.ts

import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { LibroService } from '../services/libro.service';

@Component({
  selector: 'app-libro-form',
  templateUrl: './libro-form.component.html',
  styleUrls: ['./libro-form.component.css'],
})
export class LibroFormComponent {
    libroForm: FormGroup = this.fb.group({
        nombre: ['', Validators.required],
        autor: ['', Validators.required],
        biblioteca: ['', Validators.required],
      });

  constructor(private fb: FormBuilder, private libroService: LibroService) {
    this.createForm();
  }

  private createForm() {
    this.libroForm = this.fb.group({
      nombre: ['', Validators.required],
      autor: ['', Validators.required],
      biblioteca: ['', Validators.required],
    });
  }

  onSubmit() {
    if (this.libroForm.valid) {
      const nuevoLibro = this.libroForm.value;
      this.libroService.insertarLibro(nuevoLibro).subscribe(
        (libro) => {
          console.log('Libro insertado exitosamente:', libro);
          // Puedes hacer algo después de insertar, como recargar la lista de libros
        },
        (error) => {
          console.error('Error al insertar libro', error);
        }
      );
    }
  }
}

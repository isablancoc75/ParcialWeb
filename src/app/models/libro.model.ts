// libro.model.ts

export class Libro {
    id?: number;
    nombre: string;
    autor: string;
    biblioteca: string;
  
    constructor(nombre: string, autor: string, biblioteca: string) {
      this.nombre = nombre;
      this.autor = autor;
      this.biblioteca = biblioteca;
    }
  }
  
  
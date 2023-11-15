@RestController
@RequestMapping("/api/libros")
public class LibroController {
    @Autowired
    private LibroService libroService;

    @GetMapping
    public ResponseEntity<List<Libro>> listarLibros() {
        List<Libro> libros = libroService.listarLibros();
        return new ResponseEntity<>(libros, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Libro> agregarLibro(@RequestBody LibroDTO libroDTO) {
        Libro nuevoLibro = libroService.agregarLibro(libroDTO);
        return new ResponseEntity<>(nuevoLibro, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libro> obtenerLibroPorId(@PathVariable Long id) {
        Libro libro = libroService.obtenerLibroPorId(id);
        if (libro != null) {
            return new ResponseEntity<>(libro, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Libro> actualizarLibro(@PathVariable Long id, @RequestBody LibroDTO libroDTO) {
        Libro libroActualizado = libroService.actualizarLibro(id, libroDTO);
        if (libroActualizado != null) {
            return new ResponseEntity<>(libroActualizado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarLibro(@PathVariable Long id) {
        libroService.eliminarLibro(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

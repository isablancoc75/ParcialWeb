@RestController
@RequestMapping("/api/bibliotecas")
public class BibliotecaController {
    @Autowired
    private BibliotecaService bibliotecaService;

    @GetMapping
    public ResponseEntity<List<Biblioteca>> listarBibliotecas() {
        List<Biblioteca> bibliotecas = bibliotecaService.listarBibliotecas();
        return new ResponseEntity<>(bibliotecas, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Biblioteca> agregarBiblioteca(@RequestBody BibliotecaDTO bibliotecaDTO) {
        Biblioteca nuevaBiblioteca = bibliotecaService.agregarBiblioteca(bibliotecaDTO);
        return new ResponseEntity<>(nuevaBiblioteca, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Biblioteca> obtenerBibliotecaPorId(@PathVariable Long id) {
        Biblioteca biblioteca = bibliotecaService.obtenerBibliotecaPorId(id);
        if (biblioteca != null) {
            return new ResponseEntity<>(biblioteca, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Biblioteca> actualizarBiblioteca(@PathVariable Long id, @RequestBody BibliotecaDTO bibliotecaDTO) {
        Biblioteca bibliotecaActualizada = bibliotecaService.actualizarBiblioteca(id, bibliotecaDTO);
        if (bibliotecaActualizada != null) {
            return new ResponseEntity<>(bibliotecaActualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarBiblioteca(@PathVariable Long id) {
        bibliotecaService.eliminarBiblioteca(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {
    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private BibliotecaRepository bibliotecaRepository;

    public List<Libro> listarLibros() {
        return libroRepository.findAll();
    }

    public Libro agregarLibro(LibroDTO libroDTO) {
        Biblioteca biblioteca = bibliotecaRepository.findById(libroDTO.getBibliotecaId())
                .orElseThrow(() -> new IllegalArgumentException("Biblioteca no encontrada"));

        Libro nuevoLibro = new Libro(libroDTO.getNombre(), libroDTO.getAutor(), biblioteca);
        return libroRepository.save(nuevoLibro);
    }

    public Libro obtenerLibroPorId(Long id) {
        return libroRepository.findById(id).orElse(null);
    }

    public Libro actualizarLibro(Long id, LibroDTO libroDTO) {
        Libro libroExistente = libroRepository.findById(id).orElse(null);

        if (libroExistente != null) {
            libroExistente.setNombre(libroDTO.getNombre());
            libroExistente.setAutor(libroDTO.getAutor());

            Biblioteca biblioteca = bibliotecaRepository.findById(libroDTO.getBibliotecaId())
                    .orElseThrow(() -> new IllegalArgumentException("Biblioteca no encontrada"));

            libroExistente.setBiblioteca(biblioteca);

            return libroRepository.save(libroExistente);
        } else {
            return null;
        }
    }

    public void eliminarLibro(Long id) {
        libroRepository.deleteById(id);
    }
}

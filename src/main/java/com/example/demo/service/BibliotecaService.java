import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BibliotecaService {
    @Autowired
    private BibliotecaRepository bibliotecaRepository;

    public List<Biblioteca> listarBibliotecas() {
        return bibliotecaRepository.findAll();
    }

    public Biblioteca agregarBiblioteca(BibliotecaDTO bibliotecaDTO) {
        Biblioteca nuevaBiblioteca = new Biblioteca(bibliotecaDTO.getNombre(), bibliotecaDTO.getDireccion(), bibliotecaDTO.getCiudad());
        return bibliotecaRepository.save(nuevaBiblioteca);
    }

    public Biblioteca obtenerBibliotecaPorId(Long id) {
        return bibliotecaRepository.findById(id).orElse(null);
    }

    public Biblioteca actualizarBiblioteca(Long id, BibliotecaDTO bibliotecaDTO) {
        Biblioteca bibliotecaExistente = bibliotecaRepository.findById(id).orElse(null);

        if (bibliotecaExistente != null) {
            bibliotecaExistente.setNombre(bibliotecaDTO.getNombre());
            bibliotecaExistente.setDireccion(bibliotecaDTO.getDireccion());
            bibliotecaExistente.setCiudad(bibliotecaDTO.getCiudad());

            return bibliotecaRepository.save(bibliotecaExistente);
        } else {
            return null;
        }
    }

    public void eliminarBiblioteca(Long id) {
        bibliotecaRepository.deleteById(id);
    }
}


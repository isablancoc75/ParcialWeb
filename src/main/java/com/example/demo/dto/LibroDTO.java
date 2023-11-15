// LibroDTO.java
public class LibroDTO {
    private String nombre;
    private String autor;
    private Long bibliotecaId;

    // Constructores
    public LibroDTO() {
    }

    public LibroDTO(String nombre, String autor, Long bibliotecaId) {
        this.nombre = nombre;
        this.autor = autor;
        this.bibliotecaId = bibliotecaId;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Long getBibliotecaId() {
        return bibliotecaId;
    }

    public void setBibliotecaId(Long bibliotecaId) {
        this.bibliotecaId = bibliotecaId;
    }
}


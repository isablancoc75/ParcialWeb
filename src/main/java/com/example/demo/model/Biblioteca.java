import javax.persistence.*;
import java.util.List;

@Entity
public class Biblioteca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String direccion;
    private String ciudad;

    @OneToMany(mappedBy = "biblioteca")
    private List<Libro> libros;

    // Constructores, getters y setters

    // Constructores
    public Biblioteca() {
    }

    public Biblioteca(String nombre, String direccion, String ciudad) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }
}

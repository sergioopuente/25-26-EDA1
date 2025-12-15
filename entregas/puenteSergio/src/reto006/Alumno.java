package reto006;

public class Alumno {
    private String id;
    private String nombre;
    private String email;

    public Alumno(String id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Alumno{" + "id='" + id + '\'' + ", nombre='" + nombre + '\'' + '}';
    }
}

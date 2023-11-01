

package Clases;

/**
 *
 * @author Frank.Santos
 */
public class Fosil {
private String nombre;
private int profundidadDescubierto;
private String yacimiento;
private Dinosaurio pertenece;

    public Fosil(String nombre, int profundidadDescubierto, String yacimiento, Dinosaurio pertenece) {
        this.nombre = nombre;
        this.profundidadDescubierto = profundidadDescubierto;
        this.yacimiento = yacimiento;
        this.pertenece = pertenece;
    }

    @Override
    public String toString() {
        return "Fosil{" + "nombre=" + nombre + ", profundidadDescubierto=" + profundidadDescubierto + ", yacimiento=" + yacimiento + ", pertenece=" + pertenece + '}';
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getProfundidadDescubierto() {
        return profundidadDescubierto;
    }

    public void setProfundidadDescubierto(int profundidadDescubierto) {
        this.profundidadDescubierto = profundidadDescubierto;
    }

    public String getYacimiento() {
        return yacimiento;
    }

    public void setYacimiento(String yacimiento) {
        this.yacimiento = yacimiento;
    }

    public Dinosaurio getPertenece() {
        return pertenece;
    }

    public void setPertenece(Dinosaurio pertenece) {
        this.pertenece = pertenece;
    }


}

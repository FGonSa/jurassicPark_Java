

package Clases;

import java.util.List;

/**
 *
 * @author Frank.Santos
 */
public class Dinosaurio {
private String nombre;
private String especie;
private float altura;
private float peso;
private int cantidadFosiles;
private List<Fosil> fosiles;

    public Dinosaurio(String nombre, String especie, float altura, float peso) {
        this.nombre = nombre;
        this.especie = especie;
        this.altura = altura;
        this.peso = peso;
    }

    public Dinosaurio(String nombre, String especie, float altura, float peso, int cantidadFosiles, List<Fosil> fosiles) {
        this.nombre = nombre;
        this.especie = especie;
        this.altura = altura;
        this.peso = peso;
        this.cantidadFosiles = cantidadFosiles;
        this.fosiles = fosiles;
    }

    @Override
    public String toString() {
        return "Dinosaurio{" + "nombre=" + nombre + ", especie=" + especie + ", altura=" + altura + ", peso=" + peso + ", cantidadFosiles=" + cantidadFosiles + ", fosiles=" + fosiles + '}';
    }
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public int getCantidadFosiles() {
        return cantidadFosiles;
    }

    public void setCantidadFosiles(int cantidadFosiles) {
        this.cantidadFosiles = cantidadFosiles;
    }

    public List<Fosil> getFosiles() {
        return fosiles;
    }

    public void setFosiles(List<Fosil> fosiles) {
        this.fosiles = fosiles;
    }


}



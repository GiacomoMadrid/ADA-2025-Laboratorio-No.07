/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Giacomo
 */

public class TablaHashLineal {
    private Cliente[] tabla;
    private int capacidad;
    private int tamaño;
    private long tiempoInsercion;
    private long tiempoBusqueda;

    public TablaHashLineal(int capacidad) {
        this.capacidad = capacidad;
        this.tabla = new Cliente[capacidad];
        this.tamaño = 0;
    }

    private int funcionHash(String clave) {
        // Hash basado en nombres y apellidos
        String claveCompleta = clave.toLowerCase();
        int hash = 0;
        for (int i = 0; i < claveCompleta.length(); i++) {
            hash = (31 * hash + claveCompleta.charAt(i)) % capacidad;
        }
        return hash;
    }

    public void insertar(Cliente cliente) {
        long inicio = System.nanoTime();
        
        if (tamaño >= capacidad * 0.75) {
            rehash();
        }
        
        String clave = cliente.getNombres() + cliente.getApellidos();
        int indice = funcionHash(clave);
        
        while (tabla[indice] != null) {
            indice = (indice + 1) % capacidad; // Reasignación lineal
        }
        
        tabla[indice] = cliente;
        tamaño++;
        
        tiempoInsercion = System.nanoTime() - inicio;
    }

    public Cliente buscar(String nombres, String apellidos) {
        long inicio = System.nanoTime();
        
        String clave = nombres + apellidos;
        int indice = funcionHash(clave);
        int intentos = 0;
        
        while (tabla[indice] != null && intentos < capacidad) {
            if (tabla[indice].getNombres().equalsIgnoreCase(nombres) && 
                tabla[indice].getApellidos().equalsIgnoreCase(apellidos)) {
                tiempoBusqueda = System.nanoTime() - inicio;
                return tabla[indice];
            }
            indice = (indice + 1) % capacidad; // Reasignación lineal
            intentos++;
        }
        
        tiempoBusqueda = System.nanoTime() - inicio;
        return null;
    }

    private void rehash() {
        capacidad *= 2;
        Cliente[] tablaVieja = tabla;
        tabla = new Cliente[capacidad];
        tamaño = 0;
        
        for (Cliente cliente : tablaVieja) {
            if (cliente != null) {
                insertar(cliente);
            }
        }
    }

    public long getTiempoInsercion() { return tiempoInsercion; }
    public long getTiempoBusqueda() { return tiempoBusqueda; }
}
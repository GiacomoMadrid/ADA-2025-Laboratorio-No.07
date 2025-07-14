/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Giacomo
 */
public class TablaHashArbol {
    private NodoArbol[] tabla;
    private int capacidad;
    private int tamaño;
    private long tiempoInsercion;
    private long tiempoBusqueda;

    public TablaHashArbol(int capacidad) {
        this.capacidad = capacidad;
        this.tabla = new NodoArbol[capacidad];
        this.tamaño = 0;
    }

    private int funcionHash(String clave) {
        // Misma función hash que en la tabla lineal para comparación justa
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
        
        tabla[indice] = insertarEnArbol(tabla[indice], cliente);
        tamaño++;
        
        tiempoInsercion = System.nanoTime() - inicio;
    }

    private NodoArbol insertarEnArbol(NodoArbol nodo, Cliente cliente) {
        if (nodo == null) {
            return new NodoArbol(cliente);
        }
        
        String claveNodo = nodo.cliente.getNombres() + nodo.cliente.getApellidos();
        String claveNueva = cliente.getNombres() + cliente.getApellidos();
        
        if (claveNueva.compareToIgnoreCase(claveNodo) < 0) {
            nodo.izquierdo = insertarEnArbol(nodo.izquierdo, cliente);
        } else if (claveNueva.compareToIgnoreCase(claveNodo) > 0) {
            nodo.derecho = insertarEnArbol(nodo.derecho, cliente);
        }
        
        return nodo;
    }

    public Cliente buscar(String nombres, String apellidos) {
        long inicio = System.nanoTime();
        
        String clave = nombres + apellidos;
        int indice = funcionHash(clave);
        
        Cliente resultado = buscarEnArbol(tabla[indice], nombres, apellidos);
        tiempoBusqueda = System.nanoTime() - inicio;
        
        return resultado;
    }

    private Cliente buscarEnArbol(NodoArbol nodo, String nombres, String apellidos) {
        if (nodo == null) {
            return null;
        }
        
        String claveNodo = nodo.cliente.getNombres() + nodo.cliente.getApellidos();
        String claveBusqueda = nombres + apellidos;
        
        if (claveBusqueda.equalsIgnoreCase(claveNodo)) {
            return nodo.cliente;
        } else if (claveBusqueda.compareToIgnoreCase(claveNodo) < 0) {
            return buscarEnArbol(nodo.izquierdo, nombres, apellidos);
        } else {
            return buscarEnArbol(nodo.derecho, nombres, apellidos);
        }
    }

    private void rehash() {
        capacidad *= 2;
        NodoArbol[] tablaVieja = tabla;
        tabla = new NodoArbol[capacidad];
        tamaño = 0;
        
        for (NodoArbol nodo : tablaVieja) {
            if (nodo != null) {
                insertarDesdeArbol(nodo);
            }
        }
    }

    private void insertarDesdeArbol(NodoArbol nodo) {
        if (nodo != null) {
            insertar(nodo.cliente);
            insertarDesdeArbol(nodo.izquierdo);
            insertarDesdeArbol(nodo.derecho);
        }
    }

    public long getTiempoInsercion() { return tiempoInsercion; }
    public long getTiempoBusqueda() { return tiempoBusqueda; }
}

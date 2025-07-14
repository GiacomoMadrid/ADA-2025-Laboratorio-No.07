/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Giacomo
 */
public class NodoArbol {
    Cliente cliente;
    NodoArbol izquierdo;
    NodoArbol derecho;

    public NodoArbol(Cliente cliente) {
        this.cliente = cliente;
        this.izquierdo = null;
        this.derecho = null;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p72enriquediaz;

/**
 *
 * @author Enrique
 */
public class Grupos {

    private String grupo;

    public Grupos(String grupo) {
        this.grupo = grupo;
    }

    public Grupos() {
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    @Override
    public String toString() {
        return grupo;
    }

}

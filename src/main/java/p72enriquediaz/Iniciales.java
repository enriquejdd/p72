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
public class Iniciales {

    private String inicialesProf;

    public Iniciales(String inicialesProf) {
        this.inicialesProf = inicialesProf;
    }

    public Iniciales() {
    }

    public String getInicialesProf() {
        return inicialesProf;
    }

    public void setInicialesProf(String inicialesProf) {
        this.inicialesProf = inicialesProf;
    }

    @Override
    public String toString() {
        return inicialesProf;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p72enriquediaz;

import java.util.Objects;

/**
 *
 * @author Enrique
 */
public class Horario {

    private String curso;
    private String nombreProf;
    private String asignatura;
    private String aula;
    private int dia;
    private int hora;

    public Horario() {
    }

    public Horario(String curso, String nombreProf, String asignatura, String aula, int dia, int hora) {
        this.curso = curso;
        this.nombreProf = nombreProf;
        this.asignatura = asignatura;
        this.aula = aula;
        this.dia = dia;
        this.hora = hora;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getNombreProf() {
        return nombreProf;
    }

    public void setNombreProf(String nombreProf) {
        this.nombreProf = nombreProf;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return curso + ", " + nombreProf + ", " + asignatura + ", " + aula + ", " + dia + ", " + hora;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.curso);
        hash = 83 * hash + Objects.hashCode(this.nombreProf);
        hash = 83 * hash + Objects.hashCode(this.asignatura);
        hash = 83 * hash + Objects.hashCode(this.aula);
        hash = 83 * hash + this.dia;
        hash = 83 * hash + this.hora;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Horario other = (Horario) obj;
        if (this.dia != other.dia) {
            return false;
        }
        if (this.hora != other.hora) {
            return false;
        }
        if (!Objects.equals(this.asignatura, other.asignatura)) {
            return false;
        }
        if (!Objects.equals(this.aula, other.aula)) {
            return false;
        }
        if (!Objects.equals(this.curso, other.curso)) {
            return false;
        }
        if (!Objects.equals(this.nombreProf, other.nombreProf)) {
            return false;
        }
        return true;
    }
    
    
}

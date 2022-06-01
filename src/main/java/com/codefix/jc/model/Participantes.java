package com.codefix.jc.model;

public class Participantes {

    private int id;
    private String nombres;
    private String apellidos;
    private String seminarios;
    private int confirmado;
    private int id_semi;

    public Participantes(int id, String nombres, String apellidos, String seminarios, int confirmado, int id_seminario) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.seminarios = seminarios;
        this.confirmado = confirmado;
        this.id_semi = id_seminario;
    }

    public Participantes() {
        this.id = 0;
        this.nombres = "";
        this.apellidos = "";
        this.seminarios = "";
        this.confirmado = 0;
        this.id_semi = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getSeminarios() {
        return seminarios;
    }

    public void setSeminarios(String seminarios) {
        this.seminarios = seminarios;
    }

    public int getConfirmado() {
        return confirmado;
    }

    public void setConfirmado(int confirmado) {
        this.confirmado = confirmado;
    }
    public int getId_seminario() {
        return this.id_semi;
    }

    public void setId_seminario(int id_seminario) {
        this.id_semi = id_seminario;
    }


}

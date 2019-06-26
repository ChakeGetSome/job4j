package ru.job4j.profession;

class Surgeon extends Doctor {

    public Surgeon() {
    }

    public int countOperation;
    public boolean decision;

    public int getCountOperation() {
        return countOperation;
    }

    public boolean operate() {
        return decision;
    }

    public Diagnose heal(Pacient pacient) {
        return Diagnose;
    }
}
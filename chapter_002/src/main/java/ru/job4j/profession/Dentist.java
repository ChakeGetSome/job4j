package ru.job4j.profession;

class Dentist extends Doctor {

    public Dentist() {
    }

    public boolean decision;
    public int CountCuredTeeth;

    public int getCountCuredTeeth() {
        return CountCuredTeeth;
    }

    public boolean removeTooth() {
        return decision;
    }
}
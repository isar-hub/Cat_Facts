package com.example.catfacts;

public class Model
{

    String fact;
    int length;

    public Model(int length, String fact)
    {
        this.length = length;
        this.fact = fact;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }
}

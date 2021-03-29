package Model;

import java.util.Comparator;

public class Monomial implements Comparator<Monomial>{
    public int coef; // coefficient for the variable x^i
    public int power; // power i of the term x^i
    public boolean visited = false; // for sorting


    public int compare(Monomial monom1, Monomial monom2)
    {
        return monom2.power - monom1.power; // sorting in descending order
    }
}
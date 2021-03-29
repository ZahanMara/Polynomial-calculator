package Model;

import java.util.Comparator;

public class Monomial_double implements Comparator<Monomial_double>
{
    public int power; // power i of the term x^i
    public double coef; // coefficient for the variable x^i

    public int compare(Monomial_double arg0, Monomial_double arg1) {
        return arg1.power - arg0.power; // sorting in descending order
    }
}

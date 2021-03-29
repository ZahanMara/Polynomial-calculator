package Controller;

import Model.*;
import javax.swing.*;
import java.util.Collections;

public class Controller {


   // this method takes the entered polynomials and and does the sum between them
    public Polynomial addPolynomials(Polynomial p1, Polynomial p2, JTextField tf1, JTextField tf2) {

        Polynomial result = new Polynomial();

        p1 = Polynomial.stringToPolynomial(tf1);
        // convert into polynomial what is written in the first textfield
        p2 =  Polynomial.stringToPolynomial(tf2);
        // convert into polynomial what is written in the second textfield

        Collections.sort(p1.polynom, new Monomial()); // for sorting the polynomial in ascending order
        Collections.sort(p2.polynom, new Monomial()); // according to the power

        result = Operations.add(p1, p2);
        return result;
    }

    // this method takes the entered polynomials and and does the difference between them
    public Polynomial substractPolynomials(Polynomial p1, Polynomial p2, JTextField tf1, JTextField tf2) {

        Polynomial result = new Polynomial();

        p1 = Polynomial.stringToPolynomial(tf1);
        p2 = Polynomial.stringToPolynomial(tf2);

        Collections.sort(p1.polynom, new Monomial());
        Collections.sort(p2.polynom, new Monomial());

        result = Operations.substract(p1, p2);
        return result;
    }

    // this method takes the entered polynomials and and does the product between them
    public Polynomial productPolynomials(Polynomial p1, Polynomial p2, JTextField tf1, JTextField tf2) {

        Polynomial result = new Polynomial();

        p1 = Polynomial.stringToPolynomial(tf1);
        p2 = Polynomial.stringToPolynomial(tf2);

        Collections.sort(p1.polynom, new Monomial());
        Collections.sort(p2.polynom, new Monomial());

        result = Operations.product(p1, p2);
        return result;
    }

    // this method takes the entered polynomials and and does the division between them
    public Divided dividePolynomials(Polynomial p1, Polynomial p2, JTextField tf1, JTextField tf2) {

        Divided result = new Divided();

        p1 = Polynomial.stringToPolynomial(tf1);
        p2 = Polynomial.stringToPolynomial(tf2);

        Collections.sort(p1.polynom, new Monomial());
        Collections.sort(p2.polynom, new Monomial());

        result = Operations.division(p1, p2, result);
        return result;

    }

    // this method takes the first polynomial and and calculates its derivative
    public Polynomial derivatePolynomials(Polynomial pol, JTextField tf) {

        Polynomial derivative = new Polynomial();
        pol = Polynomial.stringToPolynomial(tf);
        derivative = Operations.derivation(pol);
        return derivative;

    }

    // this method takes the first polynomial and and calculates its integration
    public Polynomial_double integratePolynomials(Polynomial_double pol, JTextField tf) {

        Polynomial_double result = new Polynomial_double();
        pol = Polynomial_double.stringToPolynomial(tf);
        result = Operations.integration(pol);
        return result;
    }



}



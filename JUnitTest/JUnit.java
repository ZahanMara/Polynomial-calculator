package JUnitTest;

import Model.*;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class JUnit {

    Polynomial generatePolynomial1()
    {
        Polynomial pol1 = new Polynomial();
        int i = 1;
        while(i < 5)
        {
            Monomial aux = new Monomial();
            aux.coef = 6-i;
            aux.power = 5-i;
            pol1.polynom.add(aux);
            i++;
        }
        return pol1; // 5x^4 + 4x^3 + 3x^2 + 2x
    }

    Polynomial generatePolynomial2()
    {
        Polynomial pol2 = new Polynomial();
        int i = 1;
        while(i < 5)
        {
            Monomial aux = new Monomial();
            aux.coef = 6-i;
            aux.power = 4-i;
            pol2.polynom.add(aux);
            i++;
        }
        return pol2; // 5x^3 + 4x^2 + 3x + 2
    }

    Polynomial_double generatePolynomial_double()
    {
        Polynomial_double pol = new Polynomial_double();
        int i = 5;
        while(i != 1)
        {
            Monomial_double aux = new Monomial_double();
            aux.coef = i;
            aux.power = i-1;
            pol.polynom.add(aux);
            i--;
        }
        return pol;
    }

    @Test
    public void testAdd() {
        Polynomial a, b, sum = new Polynomial();
        Polynomial expected = new Polynomial();
        a = generatePolynomial1();
        b = generatePolynomial2();
        int i;
        // a = 5x^4 + 4x^3 + 3x^2 + 2x
        // b = 5x^3 + 4x^2 + 3x + 2
        // expected : 5x^4 + 9x^3 + 7x^2 + 5x + 2
        expected.polynom.add(Polynomial.stringToMonomial("5x^4"));
        expected.polynom.add(Polynomial.stringToMonomial("9x^3"));
        expected.polynom.add(Polynomial.stringToMonomial("7x^2"));
        expected.polynom.add(Polynomial.stringToMonomial("5x^1"));
        expected.polynom.add(Polynomial.stringToMonomial("2x^0"));

        sum = Operations.add(a, b);
        for(i = 0; i < 5; i++)
        {
            assertEquals(sum.polynom.get(i).coef, expected.polynom.get(i).coef);
            assertEquals(sum.polynom.get(i).power, expected.polynom.get(i).power);
        }
    }

    @Test
    public void testSubstract() {
        Polynomial a, b, diff = new Polynomial();
        Polynomial expected = new Polynomial();
        a = generatePolynomial1();
        b = generatePolynomial2();
        int i;

        // a = 5x^4 + 4x^3 + 3x^2 + 2x
        // b = 5x^3 + 4x^2 + 3x + 2
        // expected : 5x^4 - x^3 - x^2 - x - 2
        expected.polynom.add(Polynomial.stringToMonomial("5x^4"));
        expected.polynom.add(Polynomial.stringToMonomial("-x^3"));
        expected.polynom.add(Polynomial.stringToMonomial("-x^2"));
        expected.polynom.add(Polynomial.stringToMonomial("-x^1"));
        expected.polynom.add(Polynomial.stringToMonomial("-2x^0"));
        diff = Operations.substract(a, b);

        for(i = 0; i < 5; i++)
        {
            assertEquals(diff.polynom.get(i).coef,expected.polynom.get(i).coef);
            assertEquals(diff.polynom.get(i).power,expected.polynom.get(i).power);
        }
    }

    @Test
    public void testProd() {
        Polynomial a, b, prod = new Polynomial();
        Polynomial expected = new Polynomial();
        a = generatePolynomial1();
        b = generatePolynomial2();
        int i;
        // a = 5x^4 + 4x^3 + 3x^2 + 2x
        // b = 5x^3 + 4x^2 + 3x + 2
        // expected : 25x^7 + 40x^6 + 30x^5 + 44x^4 + 17x^3 + 12x^2 + 4x

        expected.polynom.add(Polynomial.stringToMonomial("25x^7"));
        expected.polynom.add(Polynomial.stringToMonomial("40x^6"));
        expected.polynom.add(Polynomial.stringToMonomial("46x^5"));
        expected.polynom.add(Polynomial.stringToMonomial("44x^4"));
        expected.polynom.add(Polynomial.stringToMonomial("25x^3"));
        expected.polynom.add(Polynomial.stringToMonomial("12x^2"));
        expected.polynom.add(Polynomial.stringToMonomial("4x^1"));
        prod = Operations.product(a, b);

        for(i = 0; i < 7; i++)
        {
            assertEquals(prod.polynom.get(i).coef,expected.polynom.get(i).coef);
            assertEquals(prod.polynom.get(i).power,expected.polynom.get(i).power);
        }
    }


    @Test
    public void testDeriv() {
        Polynomial a, deriv = new Polynomial();
        Polynomial expected = new Polynomial();
        a = generatePolynomial1();

        int i;
        // a = 5x^4 + 4x^3 + 3x^2 + 2x

        expected.polynom.add(Polynomial.stringToMonomial("20x^3"));
        expected.polynom.add(Polynomial.stringToMonomial("12x^2"));
        expected.polynom.add(Polynomial.stringToMonomial("6x^1"));
        expected.polynom.add(Polynomial.stringToMonomial("2x^0"));

        deriv = Operations.derivation(a);

        for(i = 0; i < 4; i++)
        {
            assertEquals(deriv.polynom.get(i).coef,expected.polynom.get(i).coef);
            assertEquals(deriv.polynom.get(i).power,expected.polynom.get(i).power);
        }
    }



    @Test
    public void testInteg() {
        Polynomial_double a, integ = new Polynomial_double();
        Polynomial_double expected = new Polynomial_double();
        a = generatePolynomial_double();

        int i;
        // a = 5x^4+4x^3+3x^2+2x^1

        expected.polynom.add(Polynomial_double.stringToMonomial("x^5"));
        expected.polynom.add(Polynomial_double.stringToMonomial("x^4"));
        expected.polynom.add(Polynomial_double.stringToMonomial("x^3"));
        expected.polynom.add(Polynomial_double.stringToMonomial("x^2"));

        integ = Operations.integration(a);

        for(i = 0; i < 4; i++)
        {
            assertEquals(integ.polynom.get(i).power,expected.polynom.get(i).power);
        }
    }
}



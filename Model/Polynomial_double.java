package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JTextField;

public class Polynomial_double
{
    public List<Monomial_double> polynom = new ArrayList<Monomial_double>();

    public static Monomial_double stringToMonomial(String s) // convert string to monomial(type double)
    {
        Monomial_double x = new Monomial_double();
        if(s.startsWith("x") || s.startsWith("+x"))
            x.coef = 1;
        else
            if(s.startsWith("-x"))
                x.coef = -1;
            else
                x.coef = Double.parseDouble(s.substring(0, s.indexOf('x')));
        x.power = Integer.parseInt(s.substring(s.indexOf('^')+1,s.length()));
        return x;
    }

    public static Polynomial_double stringToPolynomial(JTextField text) // // convert text into polynomial(type double), monomialwise
    {
        String txt1;
        txt1 = text.getText();
        Polynomial_double p1 = new Polynomial_double();
        String mono = null;
        int j;
        while(txt1.isEmpty() == false)
        {
            char c;
            j = txt1.indexOf("x") + 2;
            if(j < txt1.length())
                c = txt1.charAt(j);
            else
                c = 'a';

            while (Character.isDigit(c) == true)
            {
                j++;
                if(j >= txt1.length())
                    c = 'a';
                else
                    c = txt1.charAt(j);
            }
            if(j >= txt1.length())
                j = txt1.length();
            mono = txt1.substring(0, j);
            Monomial_double x = new Monomial_double();
            x = stringToMonomial(mono);
            p1.polynom.add(x);
            txt1 = txt1.substring(j);
            j = 0;
        }

        return p1;
    }



    public static String polynomialToString(Polynomial_double p)
    {
        Collections.sort(p.polynom, new Monomial_double());
        String a = "";
        for(Monomial_double x : p.polynom)
        {
            if(x.coef != 0)
            {
                if(x.coef > 0 && a.equals("") == false) // it won't put a '+' in front of the first monomial
                    a = a.concat("+");
                if(x.coef != 1)
                    if(x.coef == -1)
                        a = a.concat("-");
                    else
                        a = a.concat(String.valueOf(Math.floor(x.coef * 100) / 100)); // to display only 2 decimals
                if(x.power != 0)
                {
                    a = a.concat("x");
                    if(x.power != 1)
                    {
                        a = a.concat("^");
                        a = a.concat(String.valueOf(x.power));
                    }
                }
                else if(x.power == 0)
                {
                    if(x.coef == 1 || x.coef == -1)
                        a = a.concat("1");

                }
            }
        }
        return a;
    }
}
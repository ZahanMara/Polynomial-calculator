package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JTextField;

public class Polynomial
{
    public List<Monomial> polynom = new ArrayList<Monomial>();

    public static Monomial stringToMonomial(String s) // this method converts a string to monomial
    {
        Monomial x = new Monomial();
        if(s.startsWith("x") || s.startsWith("+x"))
            x.coef = 1;
        else
            if(s.startsWith("-x"))
                x.coef = -1;
            else
                x.coef = Integer.parseInt(s.substring(0,s.indexOf('x')));

            x.power = Integer.parseInt(s.substring(s.indexOf('^')+1,s.length()));
        return x;
    }

    public static Polynomial stringToPolynomial(JTextField text) // convert text into polynomial, monomialwise
    {
        String txt1;
        txt1 = text.getText();
        Polynomial p1 = new Polynomial();
        String mono = null;
        int j;

        while(txt1.isEmpty() == false) // there is a polynomial entered in the text field
        {
            char c;
            j = txt1.indexOf("x")+2;
            if(j < txt1.length())
                c = txt1.charAt(j);
            else c = 'a';
            while (Character.isDigit(c) == true)
            {
                j++;
                if(j >= txt1.length())
                    c='a';
                else
                    c=txt1.charAt(j);
            }
            if(j >= txt1.length())
                j = txt1.length();
            mono = txt1.substring(0, j);
            Monomial x = new Monomial();
            x = stringToMonomial(mono);
            p1.polynom.add(x);
            txt1 = txt1.substring(j);
            j = 0;
        }
        return p1;
    }


    public static String polynomialToString(Polynomial p) // converts a polynomial into string for printing
    {
        Collections.sort(p.polynom, new Monomial());
        String str = "";
        for(Monomial x : p.polynom)
        {
            if(x.coef != 0)
            {
                if(x.coef > 0 && str.equals("") == false) // it won't have a '+' in front of the first monomial
                    str = str.concat("+");
                if(x.coef != 1)
                    if(x.coef == -1)
                        str = str.concat("-");
                    else
                        str = str.concat(String.valueOf(x.coef));
                if(x.power != 0)
                {
                    str = str.concat("x");
                    if(x.power != 1)
                    {
                        str = str.concat("^");
                        str = str.concat(String.valueOf(x.power));
                    }
                }
                else if(x.power == 0)
                {
                    if(x.coef == 1 || x.coef == -1)
                        str = str.concat("1");
                }
            }
        }
        return str;
    }
}

package Model;

public class Operations {

    // This method calculates the sum between two polynomials
    public static Polynomial add(Polynomial a, Polynomial b)
    {
        Polynomial result = new Polynomial(); // result = a + b
        if(b.polynom.isEmpty() == false)
        {
            Monomial sum = new Monomial();
            for(Monomial itr : a.polynom){
                int powerOf_b = b.polynom.get(0).power; 
                int i = 1;
                int coefOf_b = b.polynom.get(0).coef;
                while(itr.power != powerOf_b && i != b.polynom.size()){
                    powerOf_b = b.polynom.get(i).power;
                    coefOf_b = b.polynom.get(i).coef;
                    i++;
                }
                
                if(i == b.polynom.size() && itr.power != powerOf_b) // if there is no monomial with the same power as b
                    sum = itr;
                else
                    {
                        Monomial x = new Monomial();
                        x.coef=itr.coef + coefOf_b;
                        x.power = itr.power;
                        sum = x;
                        b.polynom.get(i - 1).visited = true;
                    }
                result.polynom.add(sum);
            }
            
            for(Monomial x: b.polynom) // terms without pair in the other polynomial are added at the end of the result
                if(x.visited == false)
                    result.polynom.add(x);
        }
        return result;
    }
    
    // This method calculates the difference between two polynomials
    public static Polynomial substract(Polynomial a, Polynomial b)
    {
        Polynomial diff = new Polynomial();
        int i = 0;
        while(i < b.polynom.size())
        {
            b.polynom.get(i).coef *= -1;
            i++;
        }
        diff = add(a,b);
        return diff;
    }// calculate each coefficient of the polynomial b times (-1)
    // then do the sum between a and (-b)
    
    
    // This method calculates the product between two polynomials
    public static Polynomial product(Polynomial a, Polynomial b)
    {
        Polynomial product = new Polynomial();
        for(Monomial itr_a : a.polynom)
        {
            Polynomial term = new Polynomial();
            for(Monomial itr_b: b.polynom)
            {
                Monomial monomial = new Monomial();
                monomial.power = itr_a.power + itr_b.power;
                monomial.coef = itr_a.coef * itr_b.coef;
                term.polynom.add(monomial);
            }
            product = add(product, term);
        }
        return product;
    }

    // This method decides which of the two polynomials is greater
    static boolean greater(Polynomial a, Polynomial b) // return 1 if a is greater, -1 otherwise
    {
        int i = 0;
        int j = 0;

        while(i < a.polynom.size())
        {
            while(a.polynom.get(i).coef == 0)
                i++;
            while(b.polynom.get(j).coef == 0)
                j++;
            if(a.polynom.get(i).power > b.polynom.get(j).power)
                return true;
            if(a.polynom.get(i).power == b.polynom.get(j).power)
                if(Math.abs(a.polynom.get(i).coef) > Math.abs(b.polynom.get(j).coef))
                    return true;
            i++;
        }
        return false;
    }

    // This method calculates the division between two polynomials
    public static Divided division(Polynomial a, Polynomial b, Divided result)
    {
        Polynomial rest = new Polynomial(); // the rest of the division
        Polynomial cat = new Polynomial();
        Polynomial aux_a = a;
        Polynomial aux_b = b;
        Monomial imp = new Monomial(); // first term of the first polynomial over the first termm of the second polynomial
        int i = 0;
        int j = 0;
        while(aux_a.polynom.get(i).coef == 0)
            i++;
        while(aux_b.polynom.get(j).coef == 0)
            j++;
        if(j == b.polynom.size()) // if we divide by zero
            return null;
        if(i == a.polynom.size())
            return result;
        imp.coef = aux_a.polynom.get(i).coef / aux_b.polynom.get(j).coef;
        imp.power = aux_a.polynom.get(i).power - aux_b.polynom.get(j).power;
        result.cat.polynom.add(imp);

        Polynomial tool = new Polynomial(); // this allows us to calculate the product between a polynomial and a monomial
        tool.polynom.add(imp);
        cat = product(tool, b);
        rest = substract(a,cat);
        result.rest = rest;

        // if "cat" is less than the rest we continue the division
        if(greater(b, rest) == false)
        {
            division(rest, b, result); // substract the rest from a and continue with the division
        }
        return result;

    }

    // This method calculates the derivative of a polynomial
    public static Polynomial derivation(Polynomial a) // (x^n)' = n*x^(n-1)
    {
        Polynomial deriv = new Polynomial();
        for(Monomial x : a.polynom)
        {
            Monomial mono = new Monomial();
            mono.coef = x.coef * x.power;
            mono.power = x.power - 1;
            deriv.polynom.add(mono);
        }
        return deriv;
    }

    // This method calculates the integration of a polynomial
    public static Polynomial_double integration(Polynomial_double a) // |n*x^(n-1) = x^n
    {
        Polynomial_double integ = new Polynomial_double();
        for(Monomial_double x : a.polynom)
        {
            Monomial_double mono = new Monomial_double();
            mono.coef = x.coef / (x.power + 1);
            mono.power = x.power + 1;
            integ.polynom.add(mono);
        }
        return integ;
    }
}

package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import javax.swing.*;

import JUnitTest.JUnit;
import Model.*;
import Controller.*;
import JUnitTest.*;


public class UI
{
    private static final long serialVersionUID = 1L;

    JFrame frame = new JFrame();
    JPanel p = new JPanel();

    JButton add_button = new JButton("+");
    JButton substract_button = new JButton("-");
    JButton product_button = new JButton("*");
    JButton div_button = new JButton("/");
    JButton deriv_button = new JButton("Derivate");
    JButton integ_button = new JButton("Integrate");

    JTextField tf1 = new JTextField();
    JTextField tf2 = new JTextField();
    JTextField tf_result = new JTextField();

    JLabel pol = new JLabel("Enter the polynomials:");
    JLabel pol1 = new JLabel("Polynomial 1");
    JLabel pol2 = new JLabel("Polynomial 2");
    JLabel operation = new JLabel("Select the desired operation:");
    JLabel result = new JLabel("Result:");
    JLabel warning = new JLabel("(!) Do not use spaces!");
    JLabel warning1 = new JLabel("(!!) Please write the power for x^1 and x^0.");
    JLabel reminder = new JLabel("(*) Derivation and integration are done for Polynomial 1.");




    void frame()
    {
        add_button.setBounds(20, 200, 85, 40);
        substract_button.setBounds(100, 200, 85, 40);
        product_button.setBounds(180, 200, 85, 40);
        div_button.setBounds(260, 200, 85, 40);
        deriv_button.setBounds(340, 200, 100, 40);
        integ_button.setBounds(440, 200, 100, 40);


        warning.setFont(new Font("Courier Bold Italic", Font.PLAIN, 15));
        warning1.setFont(new Font("Courier Bold Italic", Font.PLAIN, 15));
        reminder.setFont(new Font("Courier Bold Italic", Font.PLAIN, 15));
        result.setFont(new Font("Courier Bold Italic", Font.PLAIN, 20));
        pol.setFont(new Font("Courier Bold Italic", Font.PLAIN, 20));
        pol1.setFont(new Font("Courier Bold Italic", Font.PLAIN, 15));
        pol2.setFont(new Font("Courier Bold Italic", Font.PLAIN, 15));
        operation.setFont(new Font("Courier Bold Italic", Font.PLAIN, 20));

        pol.setBounds(25, 10, 750, 40);
        pol1.setBounds(25, 50, 85, 40);
        pol2.setBounds(25, 100, 85, 40);
        operation.setBounds(25, 150, 300, 40);
        result.setBounds(25,250,200,40);
        warning.setBounds(25,330,500,40);
        warning1.setBounds(25,355, 500, 40);
        reminder.setBounds(25,380, 500, 40);

        tf1.setFont(new Font("Courier Bold Italic", Font.PLAIN, 20));
        tf2.setFont(new Font("Courier Bold Italic", Font.PLAIN, 20));
        tf_result.setFont(new Font("Courier Bold Italic", Font.PLAIN, 20));
        tf1.setBounds(150, 50, 350, 40);
        tf2.setBounds(150, 100, 350, 40);
        tf_result.setBounds(25, 290, 500, 40);
        tf_result.setEditable(false);

        add_button.setFont(new Font("Courier Bold Italic", Font.BOLD, 20));
        substract_button.setFont(new Font("Courier Bold Italic", Font.BOLD, 20));
        product_button.setFont(new Font("Courier Bold Italic", Font.BOLD, 20));
        div_button.setFont(new Font("Courier Bold Italic", Font.BOLD, 20));
        integ_button.setFont(new Font("Courier Bold Italic", Font.BOLD, 10));
        deriv_button.setFont(new Font("Courier Bold Italic", Font.BOLD, 10));


        add_button.setBackground(new Color(250,230,200));
        substract_button.setBackground(new Color(250,230,200));
        product_button.setBackground(new Color(250,230,200));
        div_button.setBackground(new Color(250,230,200));
        integ_button.setBackground(new Color(250,230,200));
        deriv_button.setBackground(new Color(250,230,200));


        class ButtonListenerAdd implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                Polynomial p1 = new Polynomial();
                Polynomial p2 = new Polynomial();
                Polynomial result = new Polynomial();
                Controller ctrl = new Controller();
                result = ctrl.addPolynomials(p1, p2, tf1, tf2);
                String display;
                display = Polynomial.polynomialToString(result);
                tf_result.setText(display);
            }
        }

        class ButtonListenerSubstract implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                Polynomial p1 = new Polynomial();
                Polynomial p2 = new Polynomial();
                Polynomial result = new Polynomial();
                Controller ctrl = new Controller();
                result = ctrl.substractPolynomials(p1, p2, tf1, tf2);
                String display;
                display = Polynomial.polynomialToString(result);
                tf_result.setText(display);
            }
        }

        class ButtonListenerProduct implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                Polynomial p1 = new Polynomial();
                Polynomial p2 = new Polynomial();
                Polynomial result = new Polynomial();
                Controller ctrl = new Controller();
                result = ctrl.productPolynomials(p1, p2, tf1, tf2);
                String display;
                display = Polynomial.polynomialToString(result);
                tf_result.setText(display);
            }
        }

        class ButtonListenerDivision implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                Polynomial p1 = new Polynomial();
                Polynomial p2 = new Polynomial();
                Divided p3 = new Divided();

                p1 =  Polynomial.stringToPolynomial(tf1);
                p2 =  Polynomial.stringToPolynomial(tf2);

                Collections.sort(p1.polynom, new Monomial());
                Collections.sort(p2.polynom, new Monomial());

                Controller ctrl = new Controller();
                p3 = ctrl.dividePolynomials(p1, p2, tf1, tf2);
                String display = "Cat: ";
                display = display.concat( Polynomial.polynomialToString(p3.cat));
                display = display.concat(" Rest: ");
                display = display.concat( Polynomial.polynomialToString(p3.rest));
                tf_result.setText(display);

            }
        }

        class ButtonListenerDeriv implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                Polynomial p1 = new Polynomial();
                Polynomial derivative = new Polynomial();
                Controller ctrl = new Controller();
                derivative = ctrl.derivatePolynomials(p1, tf1);
                String display;
                display = Polynomial.polynomialToString(derivative);
                tf_result.setText(display);
            }
        }

        class ButtonListenerInteg implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
                Polynomial_double p1 = new Polynomial_double();
                Polynomial_double result = new Polynomial_double();
                Controller ctrl = new Controller();
                result = ctrl.integratePolynomials(p1, tf1);
                String display;
                display = Polynomial_double.polynomialToString(result);
                tf_result.setText(display);
            }
        }

        ButtonListenerAdd plus = new ButtonListenerAdd();
        ButtonListenerSubstract minus = new ButtonListenerSubstract();
        ButtonListenerProduct prod = new ButtonListenerProduct();
        ButtonListenerDivision div = new ButtonListenerDivision();
        ButtonListenerDeriv deriv = new ButtonListenerDeriv();
        ButtonListenerInteg integ = new ButtonListenerInteg();

        add_button.addActionListener(plus);
        substract_button.addActionListener(minus);
        product_button.addActionListener(prod);
        div_button.addActionListener(div);
        deriv_button.addActionListener(deriv);
        integ_button.addActionListener(integ);

        p.setLayout(null);
        p.add(warning1);
        p.add(reminder);
        p.add(warning);
        p.add(result);
        p.add(tf_result);
        p.add(add_button);
        p.add(substract_button);
        p.add(product_button);
        p.add(div_button);
        p.add(deriv_button);
        p.add(integ_button);
        p.add(operation);
        p.add(pol2);
        p.add(pol1);
        p.add(pol);
        p.add(tf1);
        p.add(tf2);
        frame.setSize(600, 460);
        frame.setContentPane(p);
        frame.setVisible(true);
    }
    public static void main( String[] args )
    {
        JUnit test = new JUnit();
        test.testAdd();
        test.testSubstract();
        test.testProd();
        test.testDeriv();
        test.testInteg();

        UI ui = new UI();
        ui.frame();

    }
}
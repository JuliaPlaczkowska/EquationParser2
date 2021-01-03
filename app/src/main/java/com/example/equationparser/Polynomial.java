package com.example.equationparser;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Polynomial implements Serializable {

    double[] factors;

    public Polynomial(double[] factors) {
        this.factors = factors;
    }

    public Polynomial(String equation){
        List<String> items = Arrays.asList(equation.split(","));
        factors = new double[items.size()];
        for (int i = 0; i <factors.length; i++) {
            factors[i]=Double.parseDouble(items.get(i));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int pow = factors.length;
        String sign = "";
        sb.append(factors[0]+"x^"+-pow);

        for (int i = 1; i <factors.length ; i++) {

            if (factors[i]>=0) {
                sign = "+";
            }
            else
                sign = "-";

            sb.append(sign+factors[i]+"x^"+-pow);
        }
        return sb.toString();
    }

    public String toSimplify(int x){
        StringBuilder sb = new StringBuilder();
        int pow = factors.length;
        String val = "("+x+")";
        String sign = "";
        sb.append(factors[0]+val+"^"+-pow);

        for (int i = 1; i <factors.length ; i++) {

            if (factors[i]>=0) {
                sign = "+";
            }
            else
                sign = "-";

            sb.append(sign+factors[i]+val+"^"+-pow);
        }
        return sb.toString();
    }


}

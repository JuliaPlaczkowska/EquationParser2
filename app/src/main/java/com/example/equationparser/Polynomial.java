package com.example.equationparser;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Polynomial implements Serializable {

    int[] factors;

    public Polynomial(int[] factors) {
        this.factors = factors;
    }

    public Polynomial(String equation){
        List<String> items = Arrays.asList(equation.split(","));
        factors = new int[items.size()];
        for (int i = 0; i <factors.length; i++) {
            factors[i]=Integer.parseInt(items.get(i));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(factors[0]+"x^"+(factors.length-1));

        for (int i = 1; i<factors.length ; i++) {

            if (factors[i]>0) {
                sb.append("+"+factors[i]+"x^"+(factors.length-i-1));
            }
            else if(factors[i]>=0){}
            else
                sb.append(factors[i]+"x^"+(factors.length-i-1));

        }
        return sb.toString();
    }

    public String toSimplify(int x){
        StringBuilder sb = new StringBuilder();
        String val = "("+x+")";
        sb.append(factors[0]+val+"^"+(factors.length-1));

        for (int i = 1; i<factors.length ; i++) {

            if (factors[i]>0) {
                sb.append("+"+factors[i]+val+"^"+(factors.length-i-1));
            }
            else if(factors[i]>=0){}
            else
                sb.append(factors[i]+val+"^"+(factors.length-i-1));

        }
        return sb.toString();
    }


}

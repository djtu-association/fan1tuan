package com.fan1tuan.test;

/**
 * Created by Li He on 2014/11/27.
 *
 */
public class Main {
    public static void main(String[] args) {
        String input = "The serum estrogen concentrations of  prot0-  +  prot1-treated rats decreased by 50%, while those of the  prot2 -treated rats increased (0.2- to 5-fold).";

        String output = input.replaceAll("\\d+(\\.\\d+)?%?", "##");

        System.out.println(output);
    }
}

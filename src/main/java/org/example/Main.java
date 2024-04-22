package org.example;

import java.util.Scanner;
import static org.example.RpnSolution.rpnSolve;
import static org.example.ConvertToRpn.convertToRpn;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        System.out.println(convertToRpn(text));
    }
}



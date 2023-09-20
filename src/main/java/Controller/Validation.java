/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Candidate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class Validation {

    private Scanner in = new Scanner(System.in);
    private String phoneValid = "^\\d{10}\\d*$";
    private String emailValid = "^[A-Za-z0-9.+-_%]+@[A-Za-z.-]+\\.[A-Za-z]{2,4}$";

    public int checkInputIntLimit(int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Range number in [" + min + ", " + max + "]");
                System.out.print("Enter again: ");
            }
        }
    }

    public String checkInputString() {
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty!!!");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    public String checkInputPhone() {
        while (true) {
            String result = checkInputString();
            if (result.matches(phoneValid)) {
                return result;
            } else {
                System.err.println("Phone is number with minimum 10 characters!!!");
                System.out.print("Enter again: ");
            }
        }
    }

    public String checkInputEmail() {
        while (true) {
            String result = checkInputString();
            if (result.matches(emailValid)) {
                return result;
            } else {
                System.err.println("Email with format <account name>@<domain>");
                System.out.print("Enter again: ");
            }
        }
    }

    public String checkInputGraduationRank() {
        while (true) {
            String result = checkInputString();
            if (result.equalsIgnoreCase("Excellence")
                    || result.equalsIgnoreCase("Good")
                    || result.equalsIgnoreCase("Fair")
                    || result.equalsIgnoreCase("Poor")) {
                return result;
            } else {
                System.err.println("Please input string: Excellence, Good, Fair, Poor.");
                System.out.print("Enter again: ");
            }
        }
    }

    public boolean checkIdExist(ArrayList<Candidate> candidates, String id) {
        for (Candidate candidate : candidates) {
            if (candidate.getId().equalsIgnoreCase(id)) {
                System.err.println("Id exist.");
                return false;
            }
        }
        return true;
    }

    public int checkInputExprience(int birthDate) {
        int yearCurrent = Calendar.getInstance().get(Calendar.YEAR);
        int age = yearCurrent - birthDate;
        while (true) {
            int expInYear = checkInputIntLimit(0, 100);
            if (expInYear > age) {
                System.err.println("Experience must be smaller than age");
            } else {
                return expInYear;
            }
        }
    }

    public boolean checkInputYorN() {
        while (true) {
            String result = checkInputString();
            if (result.equalsIgnoreCase("Y")) {
                return true;
            } else if (result.equalsIgnoreCase("N")) {
                return false;
            }
            System.err.println("Please input y/Y or n/N.");
            System.out.print("Enter again: ");
        }
    }

}

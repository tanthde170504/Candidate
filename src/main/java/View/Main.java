/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.Management;
import Model.Candidate;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class Main {
    public static void main(String[] args) {
        ArrayList<Candidate> candidates = new ArrayList<>();
        Management management = new Management();
  
    while (true) {
            int choice = management.menu();
            switch (choice) {
                case 1:
                    management.createCandidate(candidates, 0);
                    break;
                case 2:
                    management.createCandidate(candidates, 1);
                    break;
                case 3:
                    management.createCandidate(candidates, 2);
                    break;
                case 4:
                    management.searchCandidate(candidates);
                    break;
                case 5:
                    return;
            }
        }
    }
}

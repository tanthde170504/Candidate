/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Candidate;
import Model.Experience;
import Model.Fresher;
import Model.Intern;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author DELL
 */
public class Management {

    Validation validation = new Validation();

    public int menu() {
        System.out.println("1. Experience");
        System.out.println("2. Fresher");
        System.out.println("3. Internship");
        System.out.println("4. Searching");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
        int choice = validation.checkInputIntLimit(1, 5);
        return choice;
    }

    public void createCandidate(ArrayList<Candidate> candidates,
            int type) {
        while (true) {
            System.out.print("Enter id: ");
            String id = validation.checkInputString();

            System.out.print("Enter first name: ");
            String firstName = validation.checkInputString();

            System.out.print("Enter last name: ");
            String lastName = validation.checkInputString();

            System.out.print("Enter birth date: ");
            int birthDate = validation.checkInputIntLimit(1900, Calendar.getInstance().get(Calendar.YEAR));

            System.out.print("Enter address: ");
            String address = validation.checkInputString();

            System.out.print("Enter phone: ");
            String phone = validation.checkInputPhone();

            System.out.print("Enter email: ");
            String email = validation.checkInputEmail();

            Candidate candidate = new Candidate(id, firstName, lastName,
                    birthDate, address, phone, email, type);

            if (validation.checkIdExist(candidates, id)) {
                switch (type) {
                    case 0:
                        createExperience(candidates, candidate);
                        break;
                    case 1:
                        createFresher(candidates, candidate);
                        break;
                    case 2:
                        createIntern(candidates, candidate);
                        break;
                }
            } else {
                return;
            }
            System.out.print("Do you want to continue (Y/N): ");

            if (!validation.checkInputYorN()) {
                return;
            }
        }
    }

    public void createExperience(ArrayList<Candidate> candidates, Candidate candidate) {
        System.out.print("Enter year of experience: ");
        int expInYear = validation.checkInputExprience(candidate.getBirthDate());
        System.out.print("Enter professional skill: ");
        String proSkill = validation.checkInputString();
        candidates.add(new Experience(expInYear, proSkill,
                candidate.getId(),
                candidate.getFirstName(), candidate.getLastName(),
                candidate.getBirthDate(), candidate.getAddress(),
                candidate.getPhone(), candidate.getEmail(),
                candidate.getTypeCandidate()));
        System.out.println("Create success!!!");
    }

    public void createFresher(ArrayList<Candidate> candidates, Candidate candidate) {
        System.out.print("Enter graduation date: ");
        String graduationDate = validation.checkInputString();
        System.out.print("Enter graduation rank: ");
        String graduationRank = validation.checkInputGraduationRank();
        System.out.print("Enter education: ");
        String education = validation.checkInputString();
        candidates.add(new Fresher(graduationDate, graduationRank, education, candidate.getId(),
                candidate.getFirstName(), candidate.getLastName(),
                candidate.getBirthDate(), candidate.getAddress(),
                candidate.getPhone(), candidate.getEmail(),
                candidate.getTypeCandidate()));
        System.out.println("Create success!!!");
    }

    public void createIntern(ArrayList<Candidate> candidates, Candidate candidate) {
        System.out.print("Enter major: ");
        String major = validation.checkInputString();
        System.out.print("Enter semester: ");
        String semester = validation.checkInputString();
        System.out.print("Enter university: ");
        String university = validation.checkInputString();
        candidates.add(new Intern(major, semester, university, candidate.getId(),
                candidate.getFirstName(), candidate.getLastName(),
                candidate.getBirthDate(), candidate.getAddress(),
                candidate.getPhone(), candidate.getEmail(),
                candidate.getTypeCandidate()));
        System.out.println("Create success!!!");
    }

    public void searchCandidate(ArrayList<Candidate> candidates) {
        printListNameCandidate(candidates);
        System.out.print("Enter Candidate name (First name or Last name): ");
        String nameSearch = validation.checkInputString();
        System.out.print("Enter type of candidate: ");
        int typeCandidate = validation.checkInputIntLimit(0, 2);
        for (Candidate candidate : candidates) {
            if (candidate.getTypeCandidate() == typeCandidate
                    && candidate.getFirstName().contains(nameSearch)
                    || candidate.getLastName().contains(nameSearch)) {
                System.out.println(candidate.toString());
            }
        }
    }

     public void printListNameCandidate(ArrayList<Candidate> candidates) {
        System.out.println("========Experience Candidate========");
        for (Candidate candidate : candidates) {
            if (candidate instanceof Experience) {
                System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
            }
        }
        
        System.out.println("========Fresher Candidate========");
        for (Candidate candidate : candidates) {
            if (candidate instanceof Fresher) {
                System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
            }
        }
        System.out.println("========Intern Candidate========");
        for (Candidate candidate : candidates) {
            if (candidate instanceof Intern) {
                System.out.println(candidate.getFirstName() + " " + candidate.getLastName());
            }
        }
    }

}

package com.dbc.application;

import com.dbc.entities.BankAccount;
import com.dbc.entities.Donate;
import com.dbc.entities.Request;
import com.dbc.entities.user.Institution;
import com.dbc.entities.user.Person;
import com.dbc.entities.user.User;
import com.dbc.enums.Categories;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        start();

        Scanner scanner = new Scanner(System.in);
        String str;

        do {
            clear();
            System.out.println("--------------VAKINHA--------------");
            System.out.println("1 - Cria usuario");
            System.out.println("2 - Lista usuario(s)");
            System.out.println("3 - Edita usuario");
            System.out.println("4 - Remove usuario");
            System.out.println("5 - Cria vakinha");
            System.out.println("6 - Lista vakinha(s)");
            System.out.println("7 - Lista vakinha(s) por categoria");
            System.out.println("8 - Doar valor");
            System.out.println("0 - Sair");
            System.out.println();
            System.out.print(" -> ");
            str = scanner.nextLine();

            switch (str){
                case "1":
                    clear();
                    break;
                case "2":
                    clear();
                    User.listPrint();
                    System.out.println();
                    System.out.println("Pressione 2x [ENTER] para continuar");
                    scanner.nextLine();
                    break;
                case "3":
                    clear();
                    break;
                case "4":
                    clear();
                    break;
                case "5":
                    clear();
                    break;
                case "6":
                    clear();
                    Request.getAllRequests();
                    System.out.println();
                    System.out.println("Pressione 2x [ENTER] para continuar");
                    scanner.nextLine();
                    break;
                case "7":
                    clear();
                    System.out.println("\t CATEGORIAS");
                    Categories.listCategories();
                    System.out.println();
                    System.out.print(" Informer a categoria -> ");
                    str = scanner.nextLine();
                    clear();
                    switch (str){
                        case "1" -> Request.getRequestsByCategory(Categories.COMBATE_A_FOME);
                        case "2" -> Request.getRequestsByCategory(Categories.CRIANÇAS);
                        case "3" -> Request.getRequestsByCategory(Categories.ENFERMOS);
                        case "4" -> Request.getRequestsByCategory(Categories.COMBATE_A_COVID_19);
                        case "5" -> Request.getRequestsByCategory(Categories.CAUSAS_AMBIENTAIS);
                        case "6" -> Request.getRequestsByCategory(Categories.SOBREVIVENTES_DE_GUERRA);
                        case "7" -> Request.getRequestsByCategory(Categories.ANIMAIS);
                        case "8" -> Request.getRequestsByCategory(Categories.SONHOS);
                        case "9" -> Request.getRequestsByCategory(Categories.POBREZA);
                        case "10" -> Request.getRequestsByCategory(Categories.OUTROS);
                    }
                    System.out.println();
                    System.out.println("Pressione [ENTER] para continuar");
                    scanner.nextLine();
                    break;
                case "8":
                    clear();
                    new Donate().createDonate();
                    break;
            }

        }while (!str.equals("0"));

        scanner.close();
    }

    private static void start() {
        new Person().createUser("nicolas", "nicolas@email.com", "123.456.789-00");
        new Institution().createUser("LucasEnterprise", "contato@lucasenterprise.com", "99.999.999/9999-99");

        Request request = new Request(
                User.getUserById(0),
                new BankAccount("999999-5", "0005"),
                Categories.OUTROS,
                "ME QUEBREI!",
                "ANDEI DE BIKE E OLHA NO QUE DEU",
                50000.);
    }

    public static void clear () {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }
}

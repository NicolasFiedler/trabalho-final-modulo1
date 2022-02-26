package com.dbc.entities;

import java.util.Scanner;

public class Donate {
    private String nameDonator;
    private String cpfDonator;
    private String emailDonator;
    private Request request;
    private Double donateValue;
    private String description, accoutInformation;

    public Donate(){

    }

    public Donate(String nameDonator, String cpfDonator, String emailDonator, Request request, Double donateValue, String descripition, String accoutInformation){
        this.setNameDonator(nameDonator);
        this.setCpfDonator(cpfDonator);
        this.setEmailDonator(emailDonator);
        this.setRequest(request);
        this.setDonateValue(donateValue);
        this.setDescription(descripition);
        this.setAccoutInformation(accoutInformation);
    }

    public Boolean createDonate() {
       Donate donate = new Donate();
       Scanner scanner = new Scanner(System.in);
       Integer id= scanner.nextInt();
       scanner.nextLine();


       //TODO VERIFICAR ISSO COM O LUCAS
      donate.setRequest(donate.getRequest().getRequestById(id));


        String payStatus = scanner.nextLine();

        if (BankAccount.simulatePayment(payStatus) || donate.getRequest()!=null) {

            donate.setNameDonator(scanner.nextLine());
            donate.setCpfDonator(scanner.nextLine());
            donate.setEmailDonator(scanner.nextLine());
            donate.setDonateValue(scanner.nextDouble());
            scanner.nextLine();
            donate.setAccoutInformation(scanner.nextLine());
            String description = scanner.nextLine();

            if (description.equalsIgnoreCase("sim")) {
                donate.setDescription(scanner.nextLine());
            } else {
                donate.setDescription(null);
            }
            donate.setAccoutInformation(scanner.nextLine());

            donate.getRequest().addNewDonate(donate);

            return true;
        }
        return false;
    }

    public Boolean donateRequest (Integer integer){
        return false;
    }

    public String getNameDonator() {
        return nameDonator;
    }

    public void setNameDonator(String nameDonator) {
        this.nameDonator = nameDonator;
    }

    public String getCpfDonator() {
        return cpfDonator;
    }

    public void setCpfDonator(String cpfDonator) {
        this.cpfDonator = cpfDonator;
    }

    public String getEmailDonator() {
        return emailDonator;
    }

    public void setEmailDonator(String emailDonator) {
        this.emailDonator = emailDonator;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public Double getDonateValue() {
        return donateValue;
    }

    public void setDonateValue(Double donateValue) {
        this.donateValue = donateValue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String descripition) {
        this.description = descripition;
    }

    public String getAccoutInformation() {
        return accoutInformation;
    }

    public void setAccoutInformation(String accoutInformation) {
        this.accoutInformation = accoutInformation;
    }
}
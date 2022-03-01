package com.dbc.entities;
import java.util.Scanner;

public class Donate {
    private String nameDonator;
    private String cpfDonator;
    private String emailDonator;
    private Double donateValue;
    private String description, accoutInformation;

    public Donate(){

    }

    public Donate(String nameDonator, String cpfDonator, String emailDonator, Double donateValue, String descripition, String accoutInformation){
        this.setNameDonator(nameDonator);
        this.setCpfDonator(cpfDonator);
        this.setEmailDonator(emailDonator);
        this.setDonateValue(donateValue);
        this.setDescription(descripition);
        this.setAccoutInformation(accoutInformation);
    }

    public Boolean createDonate() {

       Scanner scanner = new Scanner(System.in);
       Integer id= scanner.nextInt();
       scanner.nextLine();


        String payStatus = scanner.nextLine();

        if (BankAccount.simulatePayment(payStatus)) {

            this.setNameDonator(scanner.nextLine());
            this.setCpfDonator(scanner.nextLine());
            this.setEmailDonator(scanner.nextLine());
            this.setDonateValue(scanner.nextDouble());
            scanner.nextLine();
            this.setAccoutInformation(scanner.nextLine());
            String description = scanner.nextLine();

            if (description.equalsIgnoreCase("sim")) {
                this.setDescription(scanner.nextLine());
            } else {
                this.setDescription(null);
            }
            Request request=new Request().getRequestById(id);
            request.addNewDonate(this);
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
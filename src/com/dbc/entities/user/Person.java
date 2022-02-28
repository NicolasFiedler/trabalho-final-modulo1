package com.dbc.entities.user;

public class Person extends User {
    private String cpf;

    public Person(){}
    public Person(String name, String email, String cpf) {
        super(name, email);
        this.setCpf(cpf);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public Boolean createUser(String name, String email, String cpf) {
        for (User user :
                User.getUserDB()) {
            if (user instanceof Person) {
                Person person = (Person) user;
                if (person.getCpf().equalsIgnoreCase(cpf)){
                    return false;
                }
            }
        }
        new Person (name, email, cpf);
        return true;
    }

    @Override
    public void updateUser(Integer id) {

    }

    @Override
    public Boolean deleteUser(Integer id) {
        for (User user : User.getUserDB()) {
            if (user.getId().equals(id)){
                User.getUserDB().remove(user);
                if (!deleteUser(id)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", myRequestsList=" + getMyRequestsList() +
                "cpf='" + getCpf() + '\'' +
                '}';
    }
}

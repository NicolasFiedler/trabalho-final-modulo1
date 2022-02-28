package com.dbc.entities.user;

public class Institution extends User {
    private String cnpj;

    public Institution(String name, String email, String cnpj)  {
        super(name, email);
        this.setCnpj(cnpj);
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public Boolean createUser(String name, String email, String cnpj) {
        for (User user :
                User.getUserDB()) {
            if (user instanceof Institution) {
                Institution institution = (Institution) user;
                if (institution.getCnpj().equalsIgnoreCase(cnpj)){
                    return false;
                }
            }
        }
        new Person (name, email, cnpj);
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
                "cnpj='" + getCnpj() + '\'' +
                '}';
    }
}

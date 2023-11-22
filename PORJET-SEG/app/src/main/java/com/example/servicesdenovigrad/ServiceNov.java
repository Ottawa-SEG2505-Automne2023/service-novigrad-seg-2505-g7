package com.example.servicesdenovigrad;

public class ServiceNov {

    // les attributs que le client peut remplir

    private String Fullname;
    private String Address;
    private String Email;
    private String Phone;

    // les attributs des documents requis et du nom du service  modifiables par l

    private String Name;

    private String FirstD;
    private String SecondD;
    private String ThirdD;

    public String getFullname() {
        if(Fullname != null) {
            return Fullname;
        }
        return "Vide";
    }

    public String getAddress() {
        if ( Address != null) {
            return Address;
        }
        return "Vide";
    }

    public String getEmail() {
        if ( Email != null) {
            return Email;
        }
        return "Vide";
    }

    public String getPhone() {
        if ( Phone != null) {
            return Phone;
        }
        return "Vide";
    }

    public String getFirstD() {
        return FirstD;
    }

    public String getSecondD() {
        return SecondD;
    }

    public String getThirdD() {
        return ThirdD;
    }

    public String getName() {
        return Name;
    }

    // le constructeur pour créer un service


    public ServiceNov(String name, String firstD, String secondD, String thirdD) {
        Name = name;
        FirstD = firstD;
        SecondD = secondD;
        ThirdD = thirdD;
    }

    public void setFullname(String fullname) {
        Fullname = fullname;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }


}

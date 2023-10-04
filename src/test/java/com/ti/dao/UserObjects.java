package com.ti.dao;

public class UserObjects {
   public String strUserFirstName;
 public   String strUserLastName;
  public String strCompany;
    public  String strAddress1;
    public String strAddress2;
    public String strCity;

    public String strState;

    public String strZipecode;

    public String strCountry;

    public  String strPhoneNumber;

    public UserObjects(String strUserFirstName, String strUserLastName, String strCompany, String strAddress1, String strAddress2, String strCity, String strState, String strZipecode, String strCountry, String strPhoneNumber) {
        this.strUserFirstName = strUserFirstName;
        this.strUserLastName = strUserLastName;
        this.strCompany = strCompany;
        this.strAddress1 = strAddress1;
        this.strAddress2 = strAddress2;
        this.strCity = strCity;
        this.strState = strState;
        this.strZipecode = strZipecode;
        this.strCountry = strCountry;
        this.strPhoneNumber = strPhoneNumber;
    }


    public String getStrUserFirstName() {
        return strUserFirstName;
    }

    public void setStrUserFirstName() {
        this.strUserFirstName = strUserFirstName;
    }

    public String getStrUserLastName() {
        return strUserLastName;
    }

    public void setStrUserLastName() {
        this.strUserLastName = strUserLastName;
    }

    public String getStrCompany() {
        return strCompany;
    }

    public void setStrCompany() {
        this.strCompany = strCompany;
    }

    public String getStrAddress1() {
        return strAddress1;
    }

    public void setStrAddress1() {
        this.strAddress1 = strAddress1;
    }

    public String getStrAddress2() {
        return strAddress2;
    }

    public void setStrAddress2() {
        this.strAddress2 = strAddress2;
    }

    public String getStrCity() {
        return strCity;
    }

    public void setStrCity() {
        this.strCity = strCity;
    }

    public String getStrState() {
        return strState;
    }

    public void setStrState() {
        this.strState = strState;
    }

    public String getStrZipecode() {
        return strZipecode;
    }

    public void setStrZipecode() {
        this.strZipecode = strZipecode;
    }

    public String getStrCountry() {
        return strCountry;
    }

    public void setStrCountry() {
        this.strCountry = strCountry;
    }

    public String getStrPhoneNumber() {
        return strPhoneNumber;
    }

    public void setStrPhoneNumber() {
        this.strPhoneNumber = strPhoneNumber;
    }
}

package com.app.pharmacy.dto;

public class CustomerDTO extends PersonDTO {

    private Integer amka;
    private Integer afm;

    public CustomerDTO(Integer amka, Integer afm) {
        this.amka = amka;
        this.afm = afm;
    }

    public CustomerDTO() {
    }

    public Integer getAmka() {
        return amka;
    }

    public void setAmka(Integer amka) {
        this.amka = amka;
    }

    public Integer getAfm() {
        return afm;
    }

    public void setAfm(Integer afm) {
        this.afm = afm;
    }

}


package com.easyconference.domain.entities;
/**
 * Clase Conference que representa los detalles de una conferencia, incluyendo nombre, tema, entidad organizadora, 
 * ubicación, fechas importantes y métricas de evaluación de artículos.
 * 
 * @author Maria Paula Barrera
 * @author Ashlee Vanessa Campaz
 * @author Monica Alejandra Castellanos
 * @author Karold Dirley Delgado
 * @author William Andres Serna
 * @version 1.0
 * @since 2024
 */
public class Conference {
    String name;
    String theme;
    String organizingEntity;
    String country;
    String state;
    String city;
    String address;
    String startDate;
    String endDate;
    String evaluationDate;
    String receptionDate;
    int numReseption;
    int numAcceptedArticles;
    float minCalification;

    public Conference(String name, String theme, String organizingEntity, String country, String state, String city, String address, String startDate, String endDate, String evaluationDate, String receptionDate, int numReseption, int numAcceptedArticles, float minCalification) {
        this.name = name;
        this.theme = theme;
        this.organizingEntity = organizingEntity;
        this.country = country;
        this.state = state;
        this.city = city;
        this.address = address;
        this.startDate = startDate;
        this.endDate = endDate;
        this.evaluationDate = evaluationDate;
        this.receptionDate = receptionDate;
        this.numReseption = numReseption;
        this.numAcceptedArticles = numAcceptedArticles;
        this.minCalification = minCalification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getOrganizingEntity() {
        return organizingEntity;
    }

    public void setOrganizingEntity(String organizingEntity) {
        this.organizingEntity = organizingEntity;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getEvaluationDate() {
        return evaluationDate;
    }

    public void setEvaluationDate(String evaluationDate) {
        this.evaluationDate = evaluationDate;
    }

    public String getReceptionDate() {
        return receptionDate;
    }

    public void setReceptionDate(String receptionDate) {
        this.receptionDate = receptionDate;
    }

    public int getNumReseption() {
        return numReseption;
    }

    public void setNumReseption(int numReseption) {
        this.numReseption = numReseption;
    }

    public int getNumAcceptedArticles() {
        return numAcceptedArticles;
    }

    public void setNumAcceptedArticles(int numAcceptedArticles) {
        this.numAcceptedArticles = numAcceptedArticles;
    }

    public float getMinCalification() {
        return minCalification;
    }

    public void setMinCalification(float minCalification) {
        this.minCalification = minCalification;
    }
    

}
    
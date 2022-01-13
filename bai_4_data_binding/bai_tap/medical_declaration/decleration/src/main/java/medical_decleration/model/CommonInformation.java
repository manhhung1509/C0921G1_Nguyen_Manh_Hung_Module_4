package medical_decleration.model;

import java.util.Arrays;

public class CommonInformation {
    String name;
    Integer birthday;
    String gender;
    String country;
    String id;
    String city;
    String district;
    String commune;
    String address;
    String phone;
    String email;
    TravelInformation travelInformation;
    String[] symptom;
    String[] exposure;

    public CommonInformation() {
    }

    public CommonInformation(String name, Integer birthday, String gender, String country, String id, String city, String district, String commune, String address, String phone, String email, TravelInformation travelInformation, String[] symptom, String[] exposure) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.country = country;
        this.id = id;
        this.city = city;
        this.district = district;
        this.commune = commune;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.travelInformation = travelInformation;
        this.symptom = symptom;
        this.exposure = exposure;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBirthday() {
        return birthday;
    }

    public void setBirthday(Integer birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCommune() {
        return commune;
    }

    public void setCommune(String commune) {
        this.commune = commune;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TravelInformation getTravelInformation() {
        return travelInformation;
    }

    public void setTravelInformation(TravelInformation travelInformation) {
        this.travelInformation = travelInformation;
    }

    public String[] getSymptom() {
        return symptom;
    }

    public void setSymptom(String[] symptom) {
        this.symptom = symptom;
    }

    public String[] getExposure() {
        return exposure;
    }

    public void setExposure(String[] exposure) {
        this.exposure = exposure;
    }
}

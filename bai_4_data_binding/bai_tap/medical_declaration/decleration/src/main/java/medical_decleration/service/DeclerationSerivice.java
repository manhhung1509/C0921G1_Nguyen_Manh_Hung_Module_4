package medical_decleration.service;

import java.util.List;

public interface DeclerationSerivice {
    List<String> getCountry();

    List<String> getCity();

    List<String> getDistrict();

    List<Integer> getYear();

    List<String> getGender();

    List<String> getCommune();

    List<String> getVehicle();
}

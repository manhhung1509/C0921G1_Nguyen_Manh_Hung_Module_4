package medical_decleration.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeclerationSeriviceImpl implements DeclerationSerivice{
    public static List<Integer> yearList = new ArrayList<>();
    public static List<String> genderList = new ArrayList<>();
    public static List<String> countryList = new ArrayList<>();
    public static List<String> vehicleList = new ArrayList<>();
    public static List<String> cityList = new ArrayList<>();
    public static List<String> districtList = new ArrayList<>();
    public static List<String> communeList = new ArrayList<>();
    static {
        for (int i = 1990; i<2022; i++){
            yearList.add(i);
        }

        genderList.add("Nam");
        genderList.add("Nữ");

        countryList.add("Việt Nam");
        countryList.add("Trung Quốc");
        countryList.add("Thái Lan");
        countryList.add("Hàn Quốc");
        countryList.add("Mỹ");

        vehicleList.add("Tàu bay");
        vehicleList.add("Tàu Thuyền");
        vehicleList.add("Ô tô");
        vehicleList.add("Khác(Ghi rõ)");

        cityList.add("Quảng Bình");
        cityList.add("Đà Nẵng");

        districtList.add("Hải Châu");
        districtList.add("Liên Chiểu");

        communeList.add("Hòa Khánh");
        communeList.add("Hòa Cầm");
    }

    @Override
    public List<String> getCountry(){
        return countryList;
    }

    @Override
    public List<String> getCity(){
        return cityList;
    }

    @Override
    public List<String> getDistrict(){
        return districtList;
    }

    @Override
    public List<Integer> getYear(){
        return yearList;
    }

    @Override
    public List<String> getGender(){
        return genderList;
    }

    @Override
    public List<String> getCommune(){
        return communeList;
    }

    @Override
    public List<String> getVehicle(){
        return vehicleList;
    }

}

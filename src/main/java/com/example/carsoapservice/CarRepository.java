package com.example.carsoapservice;

import io.spring.guides.gs_producing_web_service.Car;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Component
public class CarRepository {

    private static final String CAR_FILE = "src/main/resources/car_info.txt";
    public static final String MARKA = "marka";
    public static final String MODEL = "model";
    public static final String SINIF = "sinif";
    public static final String HEPSI = "hepsi";

    public List<Car> getRestCarList(String searchCriteria, String key) {
        List<Car> carList = readCarFile();
        return getSearchedList(carList,searchCriteria,key);
    }

    public List<Car> readCarFile() {
        List<Car> carList = new ArrayList<>();
        Car car;
        try (BufferedReader br = new BufferedReader(new FileReader(CAR_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                car = new Car();
                String[] carArray = line.split(";");
                car.setMarka(carArray[0].toLowerCase());
                car.setModel(carArray[1].toLowerCase());
                car.setSinif(carArray[2].toLowerCase());

                carList.add(car);
            }

            return carList;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Car> getSearchedList(List<Car> carList, String searchCriteria, String key) {
        List<Car> carModelList = new ArrayList<>();
        if (searchCriteria.equals(MARKA) || searchCriteria.equals(MODEL) ||
                searchCriteria.equals(SINIF) || searchCriteria.equals(HEPSI)) {

            carList.forEach(car -> {
                if (searchCriteria.equals(MARKA) && car.getMarka().contains(key)) {
                    carModelList.add(car);
                } else if (searchCriteria.equals(MODEL) && car.getModel().contains(key)) {
                    carModelList.add(car);
                } else if (searchCriteria.equals(SINIF) && car.getSinif().contains(key)) {
                    carModelList.add(car);
                } else if (searchCriteria.equals(HEPSI) &&
                        (car.getModel().contains(key) || car.getMarka().contains(key) || car.getSinif().contains(key))) {
                    carModelList.add(car);
                }
            });

        }
        return carModelList;
    }
}

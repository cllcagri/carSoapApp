package com.example.carsoapservice;

import io.spring.guides.gs_producing_web_service.Car;
import io.spring.guides.gs_producing_web_service.CarList;
import io.spring.guides.gs_producing_web_service.GetCarSearchRequest;
import io.spring.guides.gs_producing_web_service.GetCarSearchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;

@Endpoint
public class CarEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    private CarRepository carRepository;

    @Autowired
    public CarEndpoint(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCarSearchRequest")
    @ResponsePayload
    public GetCarSearchResponse getCars(@RequestPayload GetCarSearchRequest request) {
        GetCarSearchResponse response = new GetCarSearchResponse();
        CarList carList = new CarList();
        List<Car> searchedCarList =  carRepository.getRestCarList(request.getSearchCriteria().toLowerCase(),request.getKey().toLowerCase());
        for(Car car : searchedCarList){
            carList.getCars().add(car);
        }
        response.setCarList(carList);

        return response;
    }





}

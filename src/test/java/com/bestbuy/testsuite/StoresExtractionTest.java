package com.bestbuy.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class StoresExtractionTest {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/stores")
                .then().statusCode(200);
    }


//1. Extract the limit

    @Test
    public void extractTheLimit() {

        int limit = response.extract().path("limit");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + limit);
        System.out.println("------------------End of Test---------------------------");
    }


    //2. Extract the total
    @Test
    public void extractTheTotal() {

        int total = response.extract().path("total");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The Total value is : " + total);
        System.out.println("------------------End of Test---------------------------");
    }


//3. Extract the name of 5th store

    @Test
    public void extractTheName() {

        String storeName = response.extract().path("data[4].name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The name of 5th store is : " + storeName);
        System.out.println("------------------End of Test---------------------------");
    }


//4. Extract the names of all the store

    @Test
    public void extractTheNameOfAllStore() {

        List<String> allStoreName = response.extract().path("data.name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The  names of all the store is : " + allStoreName);
        System.out.println("------------------End of Test---------------------------");
    }


//5. Extract the storeId of all the store


    @Test
    public void extractTheIdOfAllStore() {

        List<Integer> allStoreId = response.extract().path("data.services.storeservices.storeId");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The storeId of all the store is: " + allStoreId);
        System.out.println("------------------End of Test---------------------------");
    }


//6. Print the size of the data list


    @Test
    public void sizeOfTheData() {

        List<Integer> listOfId = response.extract().path("data.Id");
        int size = listOfId.size();

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The size of the data list is : " + size);
        System.out.println("------------------End of Test---------------------------");

    }


    //7. Get all the value of the store where store name = St Cloud
    @Test
    public void allTheValueOdStoreName() {

        List<HashMap<String, ?>> values = response.extract().path("data.findAll{it.name=='St Cloud'}");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All the value of the store where store name = St Cloud is : " + values);
        System.out.println("------------------End of Test---------------------------");

    }


    //8. Get the address of the store where store name = Rochester
    @Test
    public void addressOfTheStore() {
        List<HashMap<String, ?>> address = response.extract().path("data.findAll{it.name == 'Rochester'}.address");


        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The address of the store where store name = Rochester : " + address);
        System.out.println("------------------End of Test---------------------------");


    }


    //9. Get all the services of 8th store
    @Test
    public void getAllOfTheServices() {

        List<?> listOfServices = response.extract().path("data[7].services");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println(" All the services of 8th store is : " + listOfServices);
        System.out.println("------------------End of Test---------------------------");

    }


//10. Get storeServices of the store where service name = Windows Store

    @Test
    public void getStoreServicesOfTheStore() {

        List<HashMap<String, ?>> storeServices = response.extract().path("data.services*.findAll{it.name == 'Windows Store'}.storeservices");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println(" All the storeservices of the store where service name = Windows Store is : " + storeServices);
        System.out.println("------------------End of Test---------------------------");
    }


    //11. Get all the storeId of all the store
    @Test
    public void getAllStoreID() {
        List<Integer> storeId = response.extract().path("data.services.storeservices.storeId");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All the storeId of all the store is : " + storeId);
        System.out.println("------------------End of Test---------------------------");

    }


//12. Get id of all the store

    @Test
    public void getIdOfAllStore() {
        List<Integer> IdStore = response.extract().path("data.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Id of all the store is : " + IdStore);
        System.out.println("------------------End of Test---------------------------");

    }

//13. Find the store names Where state = ND

    @Test
    public void getStoreNames() {

        List<String> storeNames = response.extract().path("data.findAll{it.state =='ND'}.name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Id of all the store is : " + storeNames);
        System.out.println("------------------End of Test---------------------------");

    }


    //14. Find the Total number of services for the store where store name = Rochester
    @Test
    public void testFindTheTotalNumber() {
        List<Object> services = response.extract().path("data.findAll{it.name == 'Rochester'}.services");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The Total number of services for the store where store name = Rochester is : " + services.size());
        System.out.println("------------------End of Test---------------------------");
    }


    //15. Find the createdAt for all services whose name = Windows Store”“
    @Test
    public void getAllServices() {

        List<HashMap<String, ?>> createdAt = response.extract().path("data.services*.findAll{it.name == 'Windows Store'}.createdAt");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println(" The createdAt for all services whose name = Windows Store : " + createdAt);
        System.out.println("------------------End of Test---------------------------");
    }


//            16. Find the name of all services Where store name = “Fargo”


    @Test
    public void allServices() {

        List<HashMap<String, ?>> allServices = response.extract().path("data.findAll{it.name == 'Fargo'}.services.name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println(" The name of all services Where store name = “Fargo” : " + allServices);
        System.out.println("------------------End of Test---------------------------");
    }


//            17. Find the zip of all the store

    @Test
    public void allZipOfStore() {

        List<HashMap<String, ?>> allZip = response.extract().path("data.zip");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println(" The zip of all the store : " + allZip);
        System.out.println("------------------End of Test---------------------------");
    }

//18. Find the zip of store name = Roseville


    @Test
    public void findZipOfStoreName() {

        List<Integer> zipOfStore = response.extract().path("data.findAll{it.name == 'Roseville'}.zip");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println(" The zip of store name = Roseville : " + zipOfStore);
        System.out.println("------------------End of Test---------------------------");
    }


//19. Find the storeservices details of the service name = Magnolia Home Theater

    @Test
    public void storeservicesDetails() {

        List<HashMap<String, ?>> storeservicesDetails = response.extract().path("data.services*.findAll{it.name == 'Magnolia Home Theater'}.storeservices");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println(" The storeservices details of the service name = Magnolia Home Theater: " + storeservicesDetails);
        System.out.println("------------------End of Test---------------------------");
    }


//20. Find the lat of all the stores

    @Test
    public void findLatOfAllStores() {

        List<HashMap<String, ?>> latOfStores = response.extract().path("data.lat");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println(" The lat of all the stores : " + latOfStores);
        System.out.println("------------------End of Test---------------------------");
    }


}


























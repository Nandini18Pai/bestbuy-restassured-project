package com.bestbuy.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.HashMap;
import java.util.List;
import static io.restassured.RestAssured.given;

public class ProductsExtractionTest {

    static ValidatableResponse response;


    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/products")
                .then().statusCode(200);

    }

    @Test
    //21. Extract the limit
    public void extractTheLimit() {
        int limit = response.extract().path("limit");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The limit  is : " + limit);
        System.out.println("------------------End of Test---------------------------");

    }


    @Test
    //22. Extract the total
    public void extractTheTotal() {
        int total = response.extract().path("total");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The Total  is : " + total);
        System.out.println("------------------End of Test---------------------------");
    }

    @Test
    //23. Extract the name of 5th product
    public void extractTheNameOfProduct() {
        String nameOfProduct = response.extract().path("data[4].name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The name of 5th product : " + nameOfProduct);
        System.out.println("------------------End of Test---------------------------");

    }

    //24. Extract the names of all the products
    @Test
    public void extractTheNameOfAllProduct() {
        List<String> nameOfAllProduct = response.extract().path("data.name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The names of all the products is : " + nameOfAllProduct);
        System.out.println("------------------End of Test---------------------------");

    }


//25. Extract the productId of all the products

    @Test

    public void extractAllProduct() {
        List<Integer> extractAllProductId = response.extract().path("data.id");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The productId of all the products  is : " + extractAllProductId);
        System.out.println("------------------End of Test---------------------------");


    }


//26. Print the size of the data list

    @Test
    public void sizeOfData() {
        List<Integer> dataSize = response.extract().path("data.id");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The productId of all the products  is : " + dataSize.size());
        System.out.println("------------------End of Test---------------------------");


    }


//27. Get all the value of the product where product name = Energizer - MAX Batteries AA (4-Pack)

    @Test
    public void valueOfTheProduct() {

        List<HashMap<String, ?>> valueOfProduct =  response.extract().path("data.findAll{it.name =='Energizer - MAX Batteries AA (4-Pack)'}");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All the value of the product where product name = Energizer - MAX Batteries AA (4-Pack)  is : " + valueOfProduct);
        System.out.println("------------------End of Test---------------------------");

    }


//28. Get the model of the product where product name = Energizer - N Cell E90 Batteries (2-Pack)

    @Test
    public void modelOfTheProduct() {
        List<HashMap<String, ?>> modelOfProduct =  response.extract().path("data.findAll{it.name =='Energizer - N Cell E90 Batteries (2-Pack)'}.model");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("the model of the product where product name = Energizer - N Cell E90 Batteries (2-Pack)  is : " + modelOfProduct);
        System.out.println("------------------End of Test---------------------------");

    }


//29. Get all the categories of 8th products

    @Test
    public void getAllTheCategories() {
        List<HashMap<String, ?>> allCategories = response.extract().path("data[7].categories");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The productId of all the products  is : " + allCategories);
        System.out.println("------------------End of Test---------------------------");
    }



//30. Get categories of the store where product id = 150115

    @Test
    public void getTheCategoriesOfProduct() {


        List<HashMap<String, ?>> allCategories = response.extract().path("data.findAll{it.id=='150115'}.categories");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The categories of product id = 150115 is : " + allCategories);
        System.out.println("------------------End of Test---------------------------");
    }




//31. Get all the descriptions of all the products

    @Test
    public void getAllTheDescriptionOfAllTheProducts() {

        List<HashMap<String, ?>> descriptionsOfAllProducts = response.extract().path("data.description");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("All the descriptions of all the products is : " + descriptionsOfAllProducts);
        System.out.println("------------------End of Test---------------------------");

    }


    //32. Get id of all the all categories of all the products
    @Test
    public void getIdOfAllTheCategoriesOfAllTheProducts() {

        List<HashMap<String, ?>> allCategories = response.extract().path("data.categories.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Id of all the all categories of all the products is : " + allCategories);
        System.out.println("------------------End of Test---------------------------");

    }


//33. Find the product names Where type = HardGood

    @Test
    public void findTheProductName() {
        List<HashMap<String, ?>> productName = response.extract().path("data.findAll{it.type = 'HardGood'}.name");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The product names Where type = HardGood is : "+productName);
        System.out.println("------------------End of Test---------------------------");

    }


//34. Find the Total number of categories for the product where product name = Duracell - AA 1.5V CopperTop Batteries (4-Pack)

    @Test
    public void totalNumberOfCategories() {
        List<HashMap<String, ?>> totalNumberOfCategories = response.extract().path("data.findAll{it.name = 'Duracell - AA 1.5V CopperTop Batteries (4-Pack)'}.categories");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("Total number of categories for the product where product name = Duracell - AA 1.5V CopperTop Batteries (4-Pack) is : " + totalNumberOfCategories.size());
        System.out.println("------------------End of Test---------------------------");

    }

//35. Find the createdAt for all products whose price < 5.49

    @Test
    public void createdAtForAllProducts() {
        List<String> productName = response.extract().path("data.findAll{it.price < 5.49}.createdAt");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The createdAt for all products whose price < 5.49 is : " + productName);
        System.out.println("------------------End of Test---------------------------");
    }


//  36. Find the name of all categories Where product name = “Energizer - MAX Batteries AA (4-Pack)
@Test
public void nameOfAllCategories() {
    List<String> nameOfAllCategories = response.extract().path("data.findAll{it.name == 'Energizer - MAX Batteries AA (4-Pack)'}.categories.name");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The name of all categories Where product name = “Energizer - MAX Batteries AA (4- Pack)” is : " + nameOfAllCategories);
    System.out.println("------------------End of Test---------------------------");
}


// 37. Find the manufacturer of all the products

    @Test
    public void manufacturerOfAllCategories() {
        List<String> manufacturerOfAllCategories = response.extract().path("data.manufacturer");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The name of all categories Where product name = “Energizer - MAX Batteries AA (4- Pack)” is : " + manufacturerOfAllCategories);
        System.out.println("------------------End of Test---------------------------");

    }

//38. Find the image of products whose manufacturer is = Energizer

        @Test
        public void imageOfProducts() {
            List<String> productImage = response.extract().path("data.findAll{it.manufacturer == 'Energizer'}.image");
            System.out.println("------------------StartingTest---------------------------");
            System.out.println("The image of products whose manufacturer is = Energizer is : " + productImage);
            System.out.println("------------------End of Test---------------------------");
        }



//39. Find the createdAt for all categories products whose price > 5.99


    @Test
    public void createdAtForAllCategories() {
        List<String> createdAt = response.extract().path("data.findAll{it.price > 5.99}.categories.createdAt");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The createdAt for all products whose price < 5.49 is : " + createdAt);
        System.out.println("------------------End of Test---------------------------");
    }



//            40. Find the uri of all the products

    @Test
    public void urlOfAllTheProduct() {
        List<String> url = response.extract().path("data.url");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The uri of all the product is : " + url);
        System.out.println("------------------End of Test---------------------------");
    }





}
























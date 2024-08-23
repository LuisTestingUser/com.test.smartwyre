package com.smartwyre.tests;

import com.smartwyre.api.apiSetUp;
import com.smartwyre.utils.dto;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;


public class apiTests {
    String productId;
    private dto.ProductRequest productRequest;
    private apiSetUp apiSetup;
    @BeforeTest
    public void setUp() {
        productRequest = new dto.ProductRequest();
        productRequest.setData(new dto.ProductData());
        apiSetup = new apiSetUp();
    }
    @Test(priority = 1)
    public void postProduct() {
        System.out.println("Running test -> creating an object");
        productId = apiSetup.postProduct(productRequest);
    }

    @Test(priority = 2)
    public void getProductById() {
        System.out.println("Running test -> get response and do assertions");
        dto.ProductResponse retrievedProduct = apiSetup.getProductById(productId);
        assertEquals(productRequest.getName(), retrievedProduct.getName());
        assertEquals(productRequest.getData().getYear(), retrievedProduct.getData().getYear());
        assertEquals(productRequest.getData().getPrice(), retrievedProduct.getData().getPrice());
        assertEquals(productRequest.getData().getCpuModel(), retrievedProduct.getData().getCpuModel());
        assertEquals(productRequest.getData().getHardDiskSize(), retrievedProduct.getData().getHardDiskSize());

    }
}








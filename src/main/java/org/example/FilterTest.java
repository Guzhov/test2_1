package org.example;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class FilterTest {

    public static FilterCars filterCars;
    public static Cars cars;
    public static WebDriver driver;

    @BeforeClass
    public static void setup() {

        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));

        driver = new ChromeDriver();
        filterCars = new FilterCars(driver);
        cars = new Cars(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(ConfProperties.getProperty("webpage")); }



    @Test
    public void filterTest() {
        filterCars.clickAdvancedFilter();
        filterCars.clickToyotaBrand();
        filterCars.clickHarrierModel();
        filterCars.clickFuelHybrid();
        filterCars.clickNotSold();
        filterCars.clickYearsOld();
        filterCars.inputOdometer(ConfProperties.getProperty("odometer_km"));
        filterCars.clickShow();

        int count = Integer.parseInt(ConfProperties.getProperty("countPages"));
        while (count>0){

            Assert.assertEquals(ConfProperties.getProperty("expectedYear"),
                    cars.testYear(Integer.parseInt(ConfProperties.getProperty("year"))));
            Assert.assertEquals(ConfProperties.getProperty("expectedOdometer"), cars.testOdometer());
            Assert.assertEquals(ConfProperties.getProperty("expectedSold"), cars.testSold());

            cars.clickNextPage();
            count -= 1;
        }

    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

}

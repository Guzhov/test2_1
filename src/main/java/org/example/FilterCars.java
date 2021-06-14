package org.example;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;


public class FilterCars {


    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */
    public WebDriver driver;
    public FilterCars(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }


    /**
     * Определение локатора для расширенной фильтрации
     */
    @FindBy(xpath = "//span[text()='Расширенный поиск']")
    private WebElement advanced_filter;

    /**
     * Определение локатора для кнопки "Показать"
     */
    @FindBy(xpath = "//div[text()='Показать']")
    private WebElement show;


    /**
     * Определение локатора поля выбора марки
     */
    @FindBy(xpath = "//button[text()='Марка']")
    private WebElement brand;

    /**
     * Определение локатора Toyota из списка марок
     */
    @FindBy(xpath = "//div[contains(text(),'Toyota')]")
    private WebElement brandToyota;


    /**
     * Определение локатора поля выбора модели
     */
    @FindBy(xpath = "//button[text()='Модель']")
    private WebElement model;

    /**
     * Определение локатора модели Harrier из списка моделей
     */
    @FindBy(xpath = "//div[contains(text(),'Harrier')]")
    private WebElement modelHarrier;

    /**
     * Определение локатора поля выбора топлива
     */
    @FindBy(xpath = "//button[text()='Топливо']")
    private WebElement fuel;

    /**
     * Определение локатора Гибрид из списка видов топлива
     */
    @FindBy(xpath = "//div[contains(text(),'Гибрид')]")
    private WebElement fuelHybrid;



    /**
     * Определение локатора поля выбора статуса продажи
     */
    @FindBy(xpath = "//div[@class='css-7c6kz3 evlmb7l2']")
    private WebElement not_sold;


    /**
     * Определение локатора поля ввода пробега
     */
    @FindBy(xpath = "//input[@placeholder='от, км']")
    private WebElement odometer;


    /**
     * Определение локатора поля выбора года выпуска
     */
    @FindBy(xpath = "//button[text()='Год от']")
    private WebElement years_old;

    /**
     * Определение локатора 2007 из списка с годами выпуска
     */
    @FindBy(xpath = "//div[contains(text(),'2007')]")
    private WebElement year_2007;

    /**
     * метод для осуществления нажатия кнопки "Расширенный поиск"
     */
    public void clickAdvancedFilter() {
        advanced_filter.click();
    }

    /**
     * метод для ввода пробега авто
     */
    public void inputOdometer(String odmtr) {
        odometer.sendKeys(odmtr); }

    /**
     * метод для осуществления нажатия кнопки выбора марки Toyota
     */
    public void clickToyotaBrand(){
        brand.click();
        brandToyota.click();
    }

    /**
     * метод для осуществления нажатия кнопки выбора модели Harrier
     */
    public void clickHarrierModel(){
        model.click();
        modelHarrier.click();
    }


    /**
     * метод для осуществления нажатия кнопки выбора топлива Гибрид
     */
    public void clickFuelHybrid(){
        fuel.click();
        fuelHybrid.click();
    }

    /**
     * метод для осуществления нажатия на "Непроданные"
     */
    public void clickNotSold(){
        not_sold.click();
    }

    /**
     * метод для осуществления нажатия на "Непроданные"
     */
    public void clickYearsOld(){
        years_old.click();
        year_2007.click();
    }

    /**
     * метод для осуществления нажатия на кнопку "Показать"
     */
    public void clickShow(){
        show.click();
    }


}

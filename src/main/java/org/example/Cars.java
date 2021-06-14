package org.example;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;;
import java.util.List;


public class Cars {

    /**
     * конструктор класса, занимающийся инициализацией полей класса
     */
    public WebDriver driver;
    public Cars(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    /**
     * определение локатора автомобилей с перечеркнутым текстом
     */

    @FindBy(xpath = "//span[@data-crossed-bull]")
    private WebElement soldCars;

    /**
     * определение локатора автомобилей для поиска информации в блоке текста
     */
    @FindBy(xpath = "//div[@class='css-wsa6w e727yh30']")
    private List<WebElement> cars;

    /**
     * определение локатора автомобилей для поиска информации в блоке текста
     */
    @FindBy(xpath = "//a[@class='css-1to36mm e24vrp31']")
    private WebElement nextPage;


    /**
     * тест на наличие пробега в блоке информации об автомобиле
     */
    public String testOdometer(){
        int i = 0;
        String carName;
        while (i < 20) {
            carName = cars.get(i).getAttribute("textContent");

            int index1 = carName.indexOf("тыс. км");
            if (index1 == -1){
                System.out.println("Ошибка: Не указан пробег автомобился");
                return "Ошибка: Не указан пробег автомобиля";
            }
            i += 1;
    }
        System.out.println("Тест №1 пройден");
        return "1";
}

    /**
     * тест на наличие автомобилей неудовлетворяющих параметрам филтра по году выпуска
     */
    public String testYear(int year){
        int i = 0;
        String carName;
        while (i < 20) {
            carName = cars.get(i).getAttribute("textContent");
            int index = carName.indexOf(",");
            String s = carName.substring(index+2, index+6);
            if (Integer.parseInt(s)<year){
                System.out.println("Ошибка: Автомобиль имеет несоотвествующий год выпуска");
                return "Ошибка: Автомобиль имеет несоотвествующий год выпуска";
            }
            i += 1;
        }
        System.out.println("Тест №2 пройден");
        return "2";
    }

    /**
     * тест на наличие проданных автомобилей в списке
     */
    public String testSold(){
        try {
            soldCars.getText();
            return "Ошибка: В списке проданный автомобиль";
        }catch (Exception err){
            System.out.println("Тест №3 пройден");
            return "3";
        }

    }
    /**
     * Функция перехода на следующую страницу
     */
    public void clickNextPage(){
        nextPage.click();
    }


}

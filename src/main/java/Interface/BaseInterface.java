package Interface;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import util.ByPageSelector;

public interface BaseInterface {

    By findCustomElement(String element, ByPageSelector byPageSelector);
    WebElement findElement(By element);
}

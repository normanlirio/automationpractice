package Interface;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import util.BySelector;

public interface BaseInterface {

    By findCustomElement(String element, BySelector bySelector);
    WebElement findElement(By element);
}

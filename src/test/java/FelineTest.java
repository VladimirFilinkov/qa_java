
import com.example.Feline;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FelineTest {

    @Test //Проверяем, что кошачий (хищник) ест правильную еду для хищников
    public void eatMeatReturnFoodForPredators() throws Exception {
        Feline feline = new Feline();
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedFood, feline.eatMeat());
    }

    @Test //Проверяем, что кошачий - кошачий
    public void getFamilyReturnFelineFamily() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test //Проверяем, что метод getKittens() возвращает кол-ко котят, которое мы задали (1)
    public void getKittensReturnDeafultkittens() {
        Feline feline = new Feline();
        assertEquals(1, feline.getKittens());
    }

    @Test //Проверяем, что метод getKittens(int n) возвращает кол-ко котят, которое мы задали
    public void getKittensReturnNkittens() {
        Feline feline = new Feline();
        assertEquals(777, feline.getKittens(777));
    }
}

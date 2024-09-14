import com.example.Cat;
import com.example.Feline;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class CatTest {
    @Test //Проверяем что метот getSound возвращает мяуканье
    public void getSoundReturnMyao(){
        Feline feline = Mockito.mock(Feline.class);
        Cat cat = new Cat(feline);
        assertEquals("Мяу", cat.getSound());
    }

    @Test //Проверяем что мнетод getFood() возвращает правильную еду - для хищников
    public void getFoodReturnFoodForPredators() throws Exception {
        Feline feline = Mockito.mock(Feline.class);
        when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        Cat cat = new Cat(feline);
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedFood, cat.getFood());
    }
}

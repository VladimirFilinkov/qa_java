import com.example.Feline;
import com.example.Lion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class LionTest {

    @Mock
    private Feline feline; // Мок для зависимости Feline

    @BeforeEach // Инициализация моков перед каждым тестом
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test //Проверяем, что у льва есть грива
    public void lionHasManeWhenSexIsMale() throws Exception {
        Lion lion = new Lion("Самец");
        assertTrue(lion.doesHaveMane(), "У льва должна быть грива");
    }

    @Test // Проверяем  что у львицы нет гривы
    public void lionDoesNotHaveManeWhenSexIsFemale() throws Exception {
        Lion lion = new Lion("Самка");
        assertFalse(lion.doesHaveMane(), "У львицы не должно быть гривы");
    }

    @Test // Проверяем что нельзя создать льва с неверным полом
    public void lionThrowsExceptionForInvalidSex() {
        try {
            // Пытаемся создать экземпляр Lion с недопустимым значением
            new Lion("Недопустимое значение");
            fail("Всё сломалось, исключение не создано"); // Если исключение не выбрасывается, тест не проходит
        } catch (Exception e) {
            // Проверяем  что сообщение исключения соответствует ожидаемому
            assertEquals("Используйте допустимые значения пола животного - самец или самка", e.getMessage());
        }
    }

    @Test // Проверяем, что метод getKittens() возвращает N котят
    public void getKittensRetunNKittens() throws Exception {
        // Настраиваем мок-объект feline для возврата 3 котят
        when(feline.getKittens()).thenReturn(333);

        // Создаем экземпляр Lion, передавая мок Feline через инъекцию зависимости
        Lion lion = new Lion("Самец");
        lion.feline = feline;

        assertEquals(333, lion.getKittens());
    }

    @Test //проверяем, что метод getFood() возвращает правильную еду - для хищников
    public void getFoodReturnFoodForPredators() throws Exception {
        // Настраиваем мок-объект feline для возврата списка еды
        List<String> foodList = List.of("Мясо", "Рыба");
        when(feline.getFood("Хищник")).thenReturn(foodList);

        // Создаем экземпляр Lion, передавая мок Feline через инъекцию зависимости
        Lion lion = new Lion("Самец");
        lion.feline = feline;

        assertEquals(foodList, lion.getFood());
    }
}
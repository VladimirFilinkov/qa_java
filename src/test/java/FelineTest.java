
import com.example.Animal;
import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class FelineTest {

    private Feline feline;
    private Animal mockAnimal;

    @Before
    public void setUp() {
        // Создаем мок для класса Animal
        mockAnimal = Mockito.mock(Animal.class);
        // Создаем экземпляр Feline с мокированным Animal
        feline = new Feline() {
            @Override
            public List<String> getFood(String animalKind) throws Exception {
                return mockAnimal.getFood(animalKind);
            }
        };
    }

    @Test //Проверяем, что кошачий (хищник) ест правильную еду для хищников
    public void eatMeatReturnFoodForPredators() throws Exception {
        // Настройка мока
        when(mockAnimal.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> food = feline.eatMeat();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
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

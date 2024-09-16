import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class LionParameterizedTest {

    private final String sex;
    private final boolean expectedMane;
    private Feline felineMock;

    // Конструктор для передачи параметров
    public LionParameterizedTest(String sex, boolean expectedMane) {
        this.sex = sex;
        this.expectedMane = expectedMane;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {"Самец", true},
                {"Самка", false},
        });
    }

    @Before
    public void setUp() {
        felineMock = Mockito.mock(Feline.class);
    }

    @Test
    public void testLionManeStatus() throws Exception {
        Lion lion = new Lion(sex, felineMock);
        Assert.assertEquals(expectedMane, lion.doesHaveMane());
    }

    @Test
    public void testGetFeline() throws Exception {
        // Создаем объект Lion с моком Feline
        Lion lion = new Lion(sex, felineMock);
        // Проверяем, что getFeline возвращает мок объекта Feline
        Assert.assertEquals(felineMock, Lion.getFeline());
    }
}
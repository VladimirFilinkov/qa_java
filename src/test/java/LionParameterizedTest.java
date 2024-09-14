
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class LionParameterizedTest {

    private String sex;
    private boolean expectedMane;

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

    @Test
    public void testLionManeStatus() throws Exception {
        Lion lion = new Lion(sex);
        Assert.assertEquals(expectedMane, lion.doesHaveMane());
    }
}
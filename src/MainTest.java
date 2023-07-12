import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    static Main mainObject;
    @BeforeAll
    public static void setUp(){
        mainObject = new Main();
    }

    @Test
    public void reduceTest(){
        List<Integer> result = mainObject.reduceArray(null);

        assert result == null;

    }

    @Test
    public void filterOut(){
        List<Integer> result = mainObject.reduceArray(List.of(1,2,3,4,5,12));

        assertEquals(result, List.of(12));

    }

    @Test
    public void filterOut2(){
        List<Integer> result = mainObject.reduceArray(List.of(1,2,3,4,5,2));

        assertEquals(result, List.of());

    }
}

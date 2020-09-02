import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestRandoms {
    @Test
    public void testRandoms_IllegalConstructorArgs(){
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new Randoms(5, 4));
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new Randoms(4, 4));
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new Randoms(-4, 4));
    }

    @Test
    public void testNext_OkInterval(){
        int min = -1;
        int max = -1;
        int k = 0;
        for (int r : new Randoms(4, 5)){
            if (min < 0 || min > 0 && r < min)
                min = r;
            if (max < 0 || max > 0 && r > max)
                max = r;
            k++;
            if (k > 22)
                break;
        }
        Assertions.assertEquals(4, min);
        Assertions.assertEquals(5, max);
    }
}

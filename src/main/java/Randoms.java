import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Random;

public class Randoms implements Iterable<Integer>{
    protected Random random = new Random(LocalDateTime.now().getSecond());
    protected int min;
    protected int max;

    public Randoms(int min, int max) {
        if (min >= max || max < 0 || min < 0)
            throw new IllegalArgumentException();
        this.min = min;
        this.max = max;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public Integer next() {
                return random.nextInt(max - min + 1) + min;
            }
        };
    }
}

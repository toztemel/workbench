package concurrent.atomic;

import java.util.concurrent.atomic.AtomicBoolean;

public class AtomicCompare {

    private AtomicBoolean locked = new AtomicBoolean(false);

    public boolean lock() {
        return locked.compareAndSet(false, true);
    }

}

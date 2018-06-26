package concurrent.atomic;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Optimistic locking tends to work best with low to medium contention
 * on the shared memory. If the content is very high on the shared memory,
 * threads will waste a lot of CPU cycles copying and modifying the
 * shared memory only to fail writing the changes back to the shared
 * memory. But, if you have a lot of content on shared memory, you
 * should anyways consider redesigning your code to lower the contention.
 */
public class OptimisticLocking {

    private AtomicLong count = new AtomicLong(0);

    /**
     * Two threads try to increment count
     * Two threads read the same value
     * First thread increments the value
     * Second thread fails to increment the value
     * Second thread retries and succeeds
     */
    public void inc() {
        boolean updated = false;

        while(!updated){
            long prevCount = this.count.get();
            updated = this.count.compareAndSet(prevCount, prevCount + 1);
        }

    }

    public long count() {
        return this.count.get();
    }
}

package threads;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class Cacher<A, V> implements Computable<A, V> {
    private final ConcurrentMap<A, Future<V>> concHashMap = new ConcurrentHashMap<A, Future<V>>();
    private final Computable<A, V> computable;

    public Cacher(Computable<A, V> computable) {
        this.computable = computable;
    }

    public V compute(final A input) throws InterruptedException {
        while (true) {
            Future<V> future = concHashMap.get(input);
            if (future == null) {
                /*
                 * this is actual computation for input.
                 */
                Callable<V> eval = new Callable<V>() {
                    public V call() throws InterruptedException {
                        return computable.compute(input);
                    }
                };
                FutureTask<V> futureTask = new FutureTask<V>(eval);

                /*
                 * This code will handle the situation of not computing same
                 * input twice if called twice from two different threads.
                 */
                future = concHashMap.putIfAbsent(input, futureTask);
                if (future == null) {
                    future = futureTask;
                    futureTask.run();
                }
            }
            try {
                return future.get();
            } catch (CancellationException e) {
                concHashMap.remove(input, future);
            } catch (ExecutionException e) {
                concHashMap.remove(input, future);
            }
        }
    }
}

interface Computable<A, V> {
    V compute(A arg) throws InterruptedException;
}
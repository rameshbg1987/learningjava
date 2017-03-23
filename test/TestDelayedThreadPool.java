package test;
import java.util.concurrent.Delayed;

import threads.DelayedTask;
import threads.DelayedThreadPool;

/*
 * https://www.careercup.com/question?id=5140138881449984
 */
public class TestDelayedThreadPool
{

    /**
     * @param args
     */
    public static void main( String[] args )
    {
        DelayedThreadPool delayedThreadPool = new DelayedThreadPool();
        for( int i = 1; i <= 10; i++ )
        {
            delayedThreadPool.addTask( new DelayedTask<Delayed>(System.currentTimeMillis() + i*5000L)
                {
                    @Override
                    public void run()
                    {
                        System.out.println("current thread name: " +Thread.currentThread().getName()+" Time to execute "+ this.getTimeToExecute()+" CurrentTime "+System.currentTimeMillis());
                    }
                } );
        }
    }
}
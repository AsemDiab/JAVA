 class HoldIntegerSynchronized {
    private int sharedInt = -1;
    private boolean writeable = true; // condition variable
    // synchronized method allows only one thread at a time to invoke this method
    public synchronized void setSharedInt( int value )
    {
        while ( !writeable ) { // not the producer's turn
// thread that called this method must wait
            try {
                wait();
            }
// process Interrupted exception while thread waiting
            catch ( InterruptedException exception ) {
                exception.printStackTrace();
            }
        }
        System.err.println( Thread.currentThread().getName() +
                " setting sharedInt to " + value );
        sharedInt = value;
// indicate that producer cannot store another value until
// a consumer retrieve current sharedInt value
        writeable = false;
// tell a waiting thread to become ready
        notify();
    }
    public synchronized int getSharedInt()
    {
        while ( writeable ) { // not the consumer's turn
// thread that called this method must wait
            try {
                wait();
            }
// process Interrupted exception while thread waiting
            catch ( InterruptedException exception ) {
                exception.printStackTrace();
            }
        }
// indicate that producer cant store another value
// because a consumer just retrieved sharedInt value
        writeable = true;
// tell a waiting thread to become ready
        notify();
        System.err.println( Thread.currentThread().getName() +
                " retrieving sharedInt value " + sharedInt );
        return sharedInt;
    }
}
 class ProduceInteger extends Thread {
    static int count;
    static Object key=new Object();
     private HoldIntegerSynchronized sharedObject;
     public ProduceInteger( HoldIntegerSynchronized shared )
     {
         super( "ProduceInteger" );
         sharedObject = shared;
     }
     // ProduceInteger thread loops 10 times and calls
// sharedObject's setSharedInt method each time
     public void run()
     { for (  count = 1; count <= 10; count++ ) {
         synchronized (key){
         try {
             Thread.sleep( ( int ) ( Math.random() * 3000 ) );
         }
         catch( InterruptedException exception ) {
             System.err.println( exception.toString() );
         }}
// call sharedObject method from this thread of execution
         sharedObject.setSharedInt( count );
     }
         System.err.println(
                 getName() + " finished producing values" +
                         "\nTerminating " + getName() );
     }
 } //
  class ConsumeInteger extends Thread {
     private HoldIntegerSynchronized sharedObject;
     public ConsumeInteger( HoldIntegerSynchronized shared )
     {
         //super( "ConsumeInteger" );
         sharedObject = shared;
     }
     public void run()
     {
         int value, sum = 0;
         do {
             try {
                 Thread.sleep( (int) ( Math.random() * 3000 ) );
             }
             catch( InterruptedException exception ) {
                 System.err.println( exception.toString() );
             }
             value = sharedObject.getSharedInt();
             sum += value;
         } while ( value != 10 );
         System.err.println(
                 getName() + " retrieved values totaling: " + sum +
                         "\nTerminating " + getName() );
     }
 }
 public class UnSync {
     // execute application
     public static void main( String args[] )
     {
         HoldIntegerSynchronized sharedObject =
                 new HoldIntegerSynchronized();
// create threads
         ProduceInteger producer =
                 new ProduceInteger( sharedObject );
         ProduceInteger producer2 =
                 new ProduceInteger( sharedObject );
         ConsumeInteger consumer =
                 new ConsumeInteger( sharedObject );
         ConsumeInteger consumer2 =
                 new ConsumeInteger( sharedObject );
// start threads
         producer.start();
         producer2.start();
         consumer.start();
         consumer2.start();
     }
 }
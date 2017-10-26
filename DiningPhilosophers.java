public class DiningPhilosophers
{	public static int Num=5;
	public static Semaphore chopstick[]=new Semaphore[Num];
	public static Semaphore Mutex=new Semaphore(1);
	public static Philosophers philosophers[]=new Philosophers [Num];
	 public static void main(String args[])
	{	int i;
		for(i=0;i<Num;i++)
		{	chopstick[i]=new Semaphore(1);
			philosophers[i]=new Philosophers(i);
			philosophers[i].start();		}
		System.out.println("Phil. 1        Phil. 2        Phil. 3        Phil. 4        Phil. 5");		}	}
class P
{	public static void Print()
	{	for(int i=0;i<DiningPhilosophers.Num;i++)
			System.out.print(DiningPhilosophers.philosophers[i].Status+"       ");
		System.out.println("");		}	}
class Philosophers extends Thread
{	private int Id;
	public String Status;
	private int Factor=3000;
	public Philosophers (int x)
	{	Id=x;
		Status="IsHungry";	}
	public void run()
	{while(true)
		{
			DiningPhilosophers.Mutex.Wait();
		   DiningPhilosophers.chopstick[Id].Wait();
			DiningPhilosophers.chopstick[(Id+1)%(DiningPhilosophers.Num)].Wait();
			Status="IsEating";
			P.Print();
			int SleepTime=(int)(Math.random()*Factor);
			try
			{
				Thread.sleep(SleepTime);
			}
			catch (InterruptedException e)
			{
				System.exit(-1);
			} 
			DiningPhilosophers.chopstick[Id].Signal();
			DiningPhilosophers.chopstick[(Id+1)%(DiningPhilosophers.Num)].Signal();
			Status="Thinking";
			P.Print();
			DiningPhilosophers.Mutex.Signal();
			SleepTime=(int)(Math.random()*Factor);
			try
			{
				Thread.sleep(SleepTime);
			}
			catch (InterruptedException e)
			{
				System.exit(-1);
			}
			Status="IsHungry";
			P.Print();
		}			
	}
}
class Semaphore
{
	private int value;
	public Semaphore()
	{
		value=0;
	}
	public Semaphore(int i)
	{
		value=i;
	}
	public synchronized void Wait()
	{
		value--;
		if(value<0)
		{
			try
			{
				wait();
			}
			catch (InterruptedException e)
			{
				System.exit(-1);
			}
		}
	}
	public synchronized void Signal()
	{
		if(value<=0)
			notify();
	}
}

package Logger;



public class logger {
	public static logger getInstance()
	{
		logger log=new logger();
		return log;
	}
	
	public void getInput(Object message)
	{
		System.out.println(message);
	}
	
	public void debug(Object message)
	{
		System.out.println(message);
	}
	public void error(Object message)
	{
		System.err.println(message);
	}

}

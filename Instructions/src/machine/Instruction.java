package machine;

public abstract class Instruction {
	
	public abstract void execute(int[] registers, Machine car);
}
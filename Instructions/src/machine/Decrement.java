package machine;

public class Decrement extends Instruction{
	
	private int index;
	
	public Decrement(int index) {
		this.index = index;
	}
	
	@Override
	public void execute(int[] registers, Machine car) {
		registers[index]--;
		car.counter++;
	}



}

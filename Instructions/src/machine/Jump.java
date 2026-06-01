package machine;

public class Jump extends Instruction{
	private int index;
	
	public Jump(int index) {
		this.index = index;
	}
	
	
	@Override
	public void execute(int[] registers, Machine car) {
		car.counter = index;
	}

}

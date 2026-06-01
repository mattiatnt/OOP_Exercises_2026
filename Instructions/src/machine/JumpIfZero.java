package machine;

public class JumpIfZero extends Instruction{
	
	private int indexZero;
	private int index;
	
	JumpIfZero(int indexValue, int index) {
		indexZero = indexValue;
		this.index = index;
	}

	@Override
	public void execute(int[] registers, Machine car) {
		if (registers[indexZero] == 0) {
			car.counter = index;
		}
	}
	
	
}

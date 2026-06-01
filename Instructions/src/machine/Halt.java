package machine;

public class Halt extends Instruction{

	@Override
	public void execute(int[] registers, Machine car) {
		car.counter = -1;
	}

}

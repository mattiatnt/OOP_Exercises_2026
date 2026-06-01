package machine;

public class LoadConstant extends Instruction{
	
	private int index;
	private int value;
	
	LoadConstant(int index, int value){
		this.index = index;
		this.value = value;
	}

	@Override
	public void execute(int[] registers, Machine car) {
		registers[index] = value;
		car.counter++;
	}

}

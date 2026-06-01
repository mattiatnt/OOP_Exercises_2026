package machine;

public class Multiply extends Instruction{
	
	private int indexReplace;
	private int indexMultiply;
	
	public Multiply(int indexReplace, int indexMultiply){
		this.indexReplace = indexReplace;
		this.indexMultiply = indexMultiply;
	}

	@Override
	public void execute(int[] registers, Machine car) {
		registers[indexReplace] = registers[indexReplace]*registers[indexMultiply];
		car.counter++;
	}


}

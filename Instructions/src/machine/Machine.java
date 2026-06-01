package machine;

public class Machine {
	int counter;
	int[] registers;
	
	Machine(int[] registers) {
		this.registers = registers;
		this.counter = 0;
	}
	
	
	public void execute(Instruction[] instructions) {
		while (0 <= counter && counter < instructions.length) {
			instructions[counter].execute(registers, this);
		}
	}
}

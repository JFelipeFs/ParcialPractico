public class InstructionSet {
    public static void SET(Memory memory, int address, int value) {
        memory.write(address, value);
    }

    public static void LDR(CPU cpu, Memory memory, int address) {
        cpu.setAccumulator(memory.read(address));
    }

    public static void ADD(Memory memory, CPU cpu, int address1, int address2, int destination) {
        int operand1 = memory.read(address1);
        int operand2 = memory.read(address2);
        int result = operand1 + operand2;
        memory.write(destination, result);
    }

    public static void INC(CPU cpu, Memory memory, int address) {
        int value = memory.read(address);
        cpu.setAccumulator(value + 1);
    }

    public static void DEC(CPU cpu, Memory memory, int address) {
        int value = memory.read(address);
        cpu.setAccumulator(value - 1);
    }

    public static void STR(CPU cpu, Memory memory, int address) {
        memory.write(address, cpu.getAccumulator());
    }

    // Métodos para las otras instrucciones...

    // Implementar los métodos restantes según sea necesario
    public static void SHW(CPU cpu, Memory memory, String option, int address) {
        switch (option) {
            case "ACC":
                System.out.println("Valor en el acumulador: " + cpu.getAccumulator());
                break;
            case "ICR":
                System.out.println("Valor en el registro ICR: " + cpu.getIcr());
                break;
            case "MAR":
                System.out.println("Valor en el registro MAR: " + cpu.getMar());
                break;
            case "MDR":
                System.out.println("Valor en el registro MDR: " + cpu.getMdr());
                break;
            case "UC":
                System.out.println("Valor en la Unidad de Control: " + cpu.getControlUnit());
                break;
            default:
                System.out.println("Valor en la dirección de memoria " + address + ": " + memory.read(address));
                break;
        }
    }

    public static void PAUSE() {
        // Aquí podríamos agregar la lógica para pausar el ciclo de instrucción
    }

    public static void END() {
        // Aquí podríamos agregar la lógica para finalizar la lectura de instrucciones
    }
}


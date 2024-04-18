import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class main {
    public static void main(String[] args) {
        // Inicializar tu simulador, CPU, memoria.
        CPU cpu = new CPU();
        Memory memory = new Memory(1000);

        // Leer el archivo de texto plano
        try {
            FileReader fileReader = new FileReader("D:\\Felipe Universidad\\Miniproyecto 1 Ahoracado POE\\ParcialPracticoSO\\src\\programa1.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // Interpretar y ejecutar cada instrucción
                String[] tokens = line.split(" ");
                String instruction = tokens[0];
                switch (instruction) {
                    case "SET":
                        InstructionSet.SET(memory, Integer.parseInt(tokens[1].substring(1)), Integer.parseInt(tokens[2]));
                        break;
                    case "LDR":
                        InstructionSet.LDR(cpu, memory, Integer.parseInt(tokens[1].substring(1)));
                        break;
                    case "ADD":
                        if (tokens.length == 2) {
                            // ADD D1 NULL NULL
                            InstructionSet.ADD(memory, cpu, Integer.parseInt(tokens[1].substring(1)), 0, 0);
                        } else if (tokens.length == 3) {
                            // ADD D1 D3 NULL
                            InstructionSet.ADD(memory, cpu, Integer.parseInt(tokens[1].substring(1)), Integer.parseInt(tokens[2].substring(1)), 0);
                        } else if (tokens.length == 4) {
                            // ADD D1 D3 D4
                            InstructionSet.ADD(memory, cpu, Integer.parseInt(tokens[1].substring(1)), Integer.parseInt(tokens[2].substring(1)), Integer.parseInt(tokens[3].substring(1)));
                        }
                        break;
                    // Agregar casos para otras instrucciones
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Imprimir el valor en la dirección de memoria D2 como salida esperada
        System.out.println("Salida esperada: " + memory.read(2));  // Suponiendo que D2 es la dirección de memoria relevante
    }
}

public class Memory {
        private int[] data;

        public Memory(int size) {
            data = new int[size];
        }

        public int read(int address) {
            return data[address];
        }

        public void write(int address, int value) {
            data[address] = value;
        }
    }




    public class CPU {
        private int accumulator;

        private int mar;
        private int mdr;
        private int icr;
        private String controlUnit;

        // Getters y setters
        public void setAccumulator(int value){
            this.accumulator = value;
        }
        public int getAccumulator() {
            return accumulator;
        }
        public int getIcr() {
            return icr;
        }
        public int getMar() {
            return mar;
        }
        public int getMdr() {
            return mdr;
        }
        public String getControlUnit() {
            return controlUnit;
        }
    }



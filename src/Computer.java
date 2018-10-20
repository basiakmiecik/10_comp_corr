public class Computer {
        Processor processor;
        Disc disc;
        Memory memory;

        public Computer(Processor processor, Disc disc, Memory memory) {
                this.processor = processor;
                this.disc = disc;
                this.memory = memory;
        }

        public Processor getProcessor() {
                return processor;
        }

        public void setProcessor(Processor processor) {
                this.processor = processor;
        }

        public Disc getDisc() {
                return disc;
        }

        public void setDisc(Disc disc) {
                this.disc = disc;
        }

        public Memory getMemory() {
                return memory;
        }

        public void setMemory(Memory memory) {
                this.memory = memory;
        }
}

import java.util.ArrayList;
import java.util.List;

public class DataBase {

    public DataBase() {
    }

    public List<Computer> componets(){
        List<Computer>comp=new ArrayList<>();
    Processor processor=new Processor("Intel","123-456",
            "123",3000,40,120);
    Memory memory=new Memory("Asus","000-456",
            "456",1066,40,120,4096);
    Disc disc= new Disc("Samsung","u123","9876",128);

    Computer computer= new Computer(processor,disc,memory);
    comp.add(computer);

   return comp;}
}

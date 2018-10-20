import java.util.ArrayList;
import java.util.List;

public class DataBase {

    public DataBase() {
    }

    public List<AssemblyComputer> componets(){
        List<AssemblyComputer>comp=new ArrayList<>();
    Processor processor=new Processor("Intel","123-456",
            "123",3000,40,120);
    comp.add(processor);
    Memory memory=new Memory("Asus","000-456",
            "456",1066,40,120,4096);
    comp.add(memory);
    Disc disc= new Disc("Samsung","u123","9876",128);
    comp.add(disc);

   return comp;}
}

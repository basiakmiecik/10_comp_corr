public class Test {
    public static void main(String[] args) {

        AssemblyComputer processor=new Processor("Intel","123-456",
                "123",3000,40,120);
        AssemblyComputer memory=new Memory("Asus","000-456",
                "456",1066,40,120,4096);
        AssemblyComputer disc= new Disc("Samsung","u123","9876",128);

        System.out.println( ((Processor) processor).getWorkTemp());
        Methods methods= new Methods(processor,memory);
        try{
            methods.clockingIncrease(200,1);

        }catch (TempertureToHighException e){
           System.err.println("Temperatura za wysoka może ona uszkodzić komputer!");
        }finally {
            System.out.println(" clocking: "+((Processor) processor).getClocking()+" tempWork: "+
                    ((Processor) processor).getWorkTemp());
        }
    }
}

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        Scanner scanner= new Scanner(System.in);

        AssemblyComputer processor=new Processor("Intel","123-456",
                "123",3000,40,120);
        AssemblyComputer memory=new Memory("Asus","000-456",
                "456",1066,40,120,4096);
        AssemblyComputer disc= new Disc("Samsung","u123","9876",128);

        Methods methods= new Methods(processor,memory);
        methods.fabricValue();
        System.out.println("Jeżeli chcesz zwiększyć taktowanie procesora wpisz 1, a jeżeli memory wpisz 2");
        int choice=scanner.nextInt();
        scanner.nextLine();
        System.out.println("O jaką wartość chcesz zwiększyć takowanie? ");
        int addClocking=scanner.nextInt();

        try{
            methods.clockingIncrease(addClocking,choice);

        }catch (TempertureToHighException e){
           System.err.println("Temperatura za wysoka może ona uszkodzić komputer!");
        }finally {
            System.out.println(" Processor clocking: "+((Processor) processor).getClocking()+" tempWork: "+
                    ((Processor) processor).getWorkTemp());
            System.out.println(" Memory clocking: "+((Memory) memory).getClocking()+" tempWork: "+
                    ((Memory) memory).getWorkTemp());
        }
    }
}

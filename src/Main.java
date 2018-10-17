import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public void main() {
        DataBase dataBase = new DataBase();
        //List<AssemblyComputer>components= new ArrayList<>();

        AssemblyComputer processor = dataBase.componets().get(0);

        AssemblyComputer memory=dataBase.componets().get(1);


        Scanner scanner = new Scanner(System.in);
        Methods methods = new Methods(processor, memory);
        methods.fabricValue();


        System.out.println("Co chcesz zrobić? Zwiększyć czy zmniejszyć taktowanie? Jeżeli zwiększyć wpisz 1," +
                " jeżeli zmniejszyć wpisz 2");
        int changeClockig = scanner.nextInt();
        System.out.println("Jeżeli chcesz  zmienić taktowanie procesora wpisz 1, a jeżeli memory wpisz 2");
        int choice = scanner.nextInt();
        scanner.nextLine();
        System.out.println("O jaką wartość chcesz zmienić takowanie? ");
        int addClocking = scanner.nextInt();

        try {
            switch (changeClockig) {
                case 1:
                    methods.clockingIncrease(addClocking, choice);
                    break;
                case 2:
                    methods.clockingDecrease(addClocking, choice);
                    break;
                default:
                    System.out.println("Nie wybrałeś żadnej opcji!");
            }

        } catch (TempertureToHighException e) {
            System.err.println("Temperatura za wysoka może ona uszkodzić komputer!");
        } finally {
            System.out.println(" Processor clocking: " + ((Processor) processor).getClocking() + " tempWork: " +
                    ((Processor) processor).getWorkTemp() +
                    " \nMemory clocking: " + ((Memory) memory).getClocking() + " tempWork: " +
                    ((Memory) memory).getWorkTemp());
        }
    }
}


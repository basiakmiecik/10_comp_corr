import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public void main() {
        DataBase dataBase = new DataBase();
        List<AssemblyComputer> components = dataBase.componets();

        Processor processor = (Processor) components.get(0);
        Memory memory = (Memory) components.get(1);


        Scanner scanner = new Scanner(System.in);
        String koniec;
        boolean end=false;
        String choice="";
        int changeClocking=0;
        int mhz=0;


        do {
            System.out.println("Czy chcesz zmienić taktowanie wybranego komponentu (tak albo nie)");
            koniec=scanner.nextLine();
            switch (koniec) {
                case "tak": {
                    System.out.println("Jeżeli chcesz  zmienić taktowanie procesora wpisz 'p', a jeżeli memory wpisz 'm'. ");
                    choice = scanner.nextLine();
                    System.out.println("\nJeżeli zwiększyć taktowanie wpisz 1, jeżeli zmniejszyć taktowanie wpisz 2");
                    changeClocking = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("\nO jaką wartość chcesz zmienić takowanie? ");
                    mhz = scanner.nextInt();
                    scanner.nextLine();
                    try {
                        switch (choice) {
                            case "p": {
                                switch (changeClocking) {
                                    case 1:
                                        processor.overClock(mhz);
                                        break;
                                    case 2:
                                        processor.decreaseClock(mhz);
                                        break;
                                    default:
                                        System.out.println("Nie wiadomo czy zwiększyć czy zmniejszyć taktowanie procesora, " +
                                                "wybierz ponownie");
                                }
                            }
                            break;
                            case "m":{
                                switch (changeClocking) {
                                    case 1:
                                        memory.overClock(mhz);
                                        break;
                                    case 2:
                                        memory.decreaseClock(mhz);
                                        break;
                                    default:
                                        System.out.println("Nie wiadomo czy zmniejszyć czy zwiększyć taktowanie pamięci," +
                                                " wybierz ponownie");
                                }

                            }
                            break;
                            default:
                                System.out.println("Nie wybrałeś żadnej opcji!");
                        }

                    } catch (TempertureToHighException e) {
                        System.err.println("Temperatura za wysoka może ona uszkodzić komputer!");
                    } finally {
                        System.out.println(" Processor clocking: " + processor.getClocking() + " tempWork: " +
                                processor.getWorkTemp() +
                                " \nMemory clocking: " + memory.getClocking() + " tempWork: " +
                                memory.getWorkTemp());

                    }
                    break;
                }
                case "nie":
                    end = true;
                    break;
            }
        } while (!end);
    }
}

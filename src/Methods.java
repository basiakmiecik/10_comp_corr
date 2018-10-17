public class Methods implements ClockingChange{
    //AssemblyComputer assemblyComputer;
    AssemblyComputer processor;
    AssemblyComputer memory;

    public Methods(AssemblyComputer processor, AssemblyComputer memory) {
        this.processor = processor;
        this.memory = memory;
    }

    double pclockingBase=3000;

    //((Processor) processor).getWorkTemp();
    double mclockingBase=((Memory)memory).getClocking();
    double clocking=0;
    int NewTemp=0;//

    @Override
    public double clockingIncrease(int addClocking,int choice){

        double clockingMax= Math.round(pclockingBase+((Processor) processor).getMaxTemp()-
                ((Processor) processor).getWorkTemp()*100/10);
        System.out.println(clockingMax);
        double mclockingMax= Math.round(pclockingBase+(((Processor) processor).getMaxTemp()-
                ((Processor) processor).getWorkTemp())*100/10);
        if(choice==1){
            ((Processor) processor).setClocking(pclockingBase+addClocking);
           NewTemp=((Processor) processor).getWorkTemp()+(addClocking/15);
           ((Processor) processor).setWorkTemp(NewTemp);
            if(((Processor) processor).getClocking()>clockingMax){
                throw new TempertureToHighException();
            }
        }else if(choice ==2){
            ((Memory) memory).setClocking(mclockingBase+addClocking);
            NewTemp=((Memory) memory).getWorkTemp()+(addClocking/15);
            ((Memory) memory).setWorkTemp(NewTemp);
            if(((Memory) memory).getClocking()>mclockingMax){
                throw new TempertureToHighException();
            }
        }
        return clocking;
    }

    @Override
    public double clockingDecrease(int diffClocking,AssemblyComputer assemblyComputer) {
        if(assemblyComputer==processor){
            ((Processor) processor).setClocking(pclockingBase-diffClocking);
            if(((Processor) processor).getClocking()<pclockingBase){
                ((Processor) processor).setClocking(pclockingBase);
                clocking=((Processor) processor).getClocking();
            }
        }else if(assemblyComputer==memory){
            ((Memory) memory).setClocking(mclockingBase+diffClocking);
            if(((Memory) memory).getClocking()<mclockingBase){
                ((Memory) memory).setClocking(mclockingBase);
                clocking=((Memory) memory).getClocking();
            }
        }
        return clocking;
    }

}

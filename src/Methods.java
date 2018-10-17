public class Methods implements ClockingChange{
    //AssemblyComputer assemblyComputer;
    AssemblyComputer processor;
    AssemblyComputer memory;

    double clocking=0;
    int NewTemp=0;
    double pclockingBase;
    double mclockingBase;

    public Methods(AssemblyComputer processor, AssemblyComputer memory) {
        this.processor = processor;
        this.memory = memory;
    }

    @Override
    public void fabricValue() {
        pclockingBase=((Processor)processor).getClocking();
        mclockingBase=((Memory)memory).getClocking();
    }

    @Override
    public double clockingIncrease(int addClocking,int choice){
        mclockingBase=((Memory)memory).getClocking();
        double clockingMax= pclockingBase+Math.round((((Processor) processor).getMaxTemp()-
                ((Processor) processor).getWorkTemp())*10);
        System.out.println("Max Clocking procssor: "+clockingMax);
        double mclockingMax= Math.round(mclockingBase+((((Memory)memory).getMaxTemp()-
                ((Memory) memory).getWorkTemp()))*10);
        System.out.println("Max Clocking memory: "+mclockingMax);
        if(choice==1){
            ((Processor) processor).setClocking(pclockingBase+addClocking);
           NewTemp=((Processor) processor).getWorkTemp()+(addClocking/10);
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

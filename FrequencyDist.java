public class FrequencyDist {
    private ClassInterval[] classes;

    FrequencyDist(int[] dataSet, int width, int classCount, int minimum){
        classes = new ClassInterval[classCount];
        addClasses(width, classCount, minimum);
        addFrequencies(dataSet);
        addRelFreq(dataSet.length);
        addCumFreq();
        addRelCumFreq(dataSet.length);
        printTable(classCount);
    }
    
    private void addClasses(int width, int classCount, int minimum){
        int a = minimum;
        classes[0] = new ClassInterval(); // create a first line class limit
        classes[0].setA(a);
        classes[0].setB(a + width - 1);
        for(int i = 1; i < classCount; i++){
            classes[i] = new ClassInterval();
            a+=width;
            classes[i].setA(a);
            classes[i].setB(a + width - 1);
        }
    }

    private void printTable(int classCount){
        System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s %-15s\n", "------------", "---------", "--------", "----------", "-------", "-----------", "--------------");
        System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s %-15s\n", "Class Limits", "Frequency", "Rel Freq", "Percentage", "CumFreq", "Rel CumFreq", "Cumulative Pct");
        System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s %-15s\n", "------------", "---------", "--------", "----------", "-------", "-----------", "--------------");
        for(int i = 0; i < classCount; i++){
            System.out.printf("%-15s %-15s %-15.3f %-15.2f %-15s %-15.3f %-15.1f\n",classes[i].getA() +  " - " +  classes[i].getB(), classes[i].getTally(), classes[i].getRelFreq(), classes[i].getPercentage(), 
                                                                                    classes[i].getCumFreq(), classes[i].getRelCumFreq(), classes[i].getCumPct() );
        }
        System.out.printf("%-15s\n", "-------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-15s %-15s %-15.3f %-15.1f\n", "", "Sum = " + getTotalFrequencies(), getTotalRelFreq(), getTotalPct());
    }

    private void addFrequencies(int[] dataSet){
        int x, a, b;
        for(int i = 0; i < dataSet.length; i++){
            x = dataSet[i];
            for(int j = 0 ; j < classes.length; j++){
                a = classes[j].getA();
                b = classes[j].getB();
                if(x >= a && x <= b){
                    classes[j].addtally();
                    break;
                }
            }
        }
    }

    private void getFrequencies(){
        System.out.println("\n    Frequencies");
        for(int i = 0; i < classes.length; i++){
            System.out.println("    " + classes[i].getTally());
        }
    }

    private int getTotalFrequencies(){
        int sum = 0;
        for(int i = 0 ; i < classes.length; i++){
            sum+= classes[i].getTally();
        }
        return sum;
    }

    private double getTotalRelFreq(){
        double sum = 0;
        for(int i = 0 ; i < classes.length; i++){
            sum+= classes[i].getRelFreq();
        }
        // return Math.ceil(sum);
        return sum;
    }

    private double getTotalCumRelFreq(){
        double sum = 0;
        for(int i = 0 ; i < classes.length; i++){
            sum+= classes[i].getCumFreq();
        }
        return sum;
    }

    private void addRelFreq(int length){
        for(int i = 0; i < classes.length; i++){
            classes[i].setRelFreq(length);
        }
    }

    private double getTotalPct(){
        double sum = 0;
        for(int i = 0 ; i < classes.length; i++){
            sum+= classes[i].getPercentage();
        }
        // return Math.ceil(sum);
        return sum;
    }

    private void addCumFreq(){
        classes[0].setCumFreq();
        for(int i = 1; i < classes.length; i++){
            classes[i].setCumFreq(classes[i].getTally() + classes[i-1].getCumFreq());
        }
    }

    private void addRelCumFreq(int length){
        for(int i = 0; i < classes.length; i++){
            classes[i].setRelCumFreq(length);
        }
    }
}

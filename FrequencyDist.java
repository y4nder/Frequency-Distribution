public class FrequencyDist {
    private ClassInterval[] classes;

    FrequencyDist(int[] dataSet, int width, int classCount, int minimum){
        classes = new ClassInterval[classCount];
        addClasses(width, classCount, minimum);
        addFrequencies(dataSet);
        addCumFreq(); 
        addRelCumFreq(dataSet.length);
        printTable(classCount, dataSet.length);
    }
    
    private void addClasses(int width, int classCount, int minimum){
        int a = minimum;
        classes[0] = new ClassInterval(a, (a + width - 1)); // create a first line class limit
        for(int i = 1; i < classCount; i++){
            a+=width;
            classes[i] = new ClassInterval(a, (a + width - 1));
        }
    }

    private void printTable(int classCount, int totalData){
        System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s %-15s\n", "------------", "---------", "--------", "----------", "-------", "-----------", "--------------");
        System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s %-15s\n", "Class Limits", "Frequency", "Rel Freq", "Percentage", "CumFreq", "Rel CumFreq", "Cumulative Pct");
        System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s %-15s\n", "------------", "---------", "--------", "----------", "-------", "-----------", "--------------");
        for(int i = 0; i < classCount; i++){
            classes[i].getClassData(totalData);
        }
        System.out.printf("%-15s\n", "-------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-15s %-15s %-15.3f %-15.1f\n", "", "Sum = " + getTotalFrequencies(), getTotalRelFreq(totalData), getTotalPct());
    }

    private void addFrequencies(int[] dataSet){
        int x, a, b;
        for(int i = 0; i < dataSet.length; i++){
            x = dataSet[i];
            for(int j = 0 ; j < classes.length; j++){
                a = classes[j].getA();
                b = classes[j].getB();
                if(x >= a && x <= b){
                    classes[j].incrementTally();
                    break;
                }
            }
        }
    }

    private int getTotalFrequencies(){
        int sum = 0;
        for(int i = 0 ; i < classes.length; i++){
            sum+= classes[i].getTally();
        }
        return sum;
    }

    private double getTotalRelFreq(int totalData){
        double sum = 0;
        for(int i = 0 ; i < classes.length; i++){
            sum+= classes[i].getRelFreq(totalData);
        }
        // return Math.ceil(sum);
        return sum;
    }

    private double getTotalPct(){
        double sum = 0;
        for(int i = 0 ; i < classes.length; i++){
            sum+= classes[i].getPercentage();
        }
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

package FrequencyDistFiles;
public class FrequencyDistributionTable extends FrequencyDistibution{
    private ClassInterval[] classIntervals;
    private CentralTendencyGrouped tendency;

    public FrequencyDistributionTable(int[] dataSet, int classes){
        tendency = new CentralTendencyGrouped(); //for computing central tendencies
        this.classIntervals = new ClassInterval[classes];
        getWidth(dataSet, classes);
        generateTable(dataSet, width, classes, lowestElem);
    }
    
    public void generateTable(int[] dataSet, int width, int classCount, int minimum){
        addClasses(width, classCount, minimum);
        addFrequencies(dataSet);
        addCumFreq(); 
        addMidpoints();
        addDistances(width, dataSet.length);
        printTable(classCount, dataSet.length);
    }

    private void addClasses(int width, int classCount, int minimum){
        int a = minimum;
        classIntervals[0] = new ClassInterval(a, (a + width - 1)); // create a first line class limit
        for(int i = 1; i < classCount; i++){
            a+=width;
            classIntervals[i] = new ClassInterval(a, (a + width - 1));
        }
    }

    private void printTable(int classCount, int totalData){
        System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s %-15s\n",       "------------", "---------", "---------", "-------", "-------", "--------", "------------");
        System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s %-15s\n",       "Class Limits", "Frequency", "Mid Point", "FreqMid", "CumFreq", "distance", "freqDistance");
        System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s %-15s\n",       "------------", "---------", "---------", "-------", "-------", "--------", "------------");
        for(int i = 0; i < classCount; i++){
            classIntervals[i].getClassData(totalData);
        }
        System.out.printf("%-15s\n", "-------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s %-15s\n", "", "Sum = " + getTotalFrequencies(), "", "fM: " + getTotalFM(totalData), "", "", "fD: " + getTotalFreqDistances());
        printTendencies();
    }

    private void printTendencies(){
        System.out.println("\n-----MEASURES OF CENTRAL TENDENCY-----");
        System.out.printf("     Mean (Midpoint)   : %.2f \n", tendency.getmeanMidpoint() );
        System.out.printf("     Mean (Deviation)  : %.2f \n", tendency.getmeanDeviation() );
        System.out.printf("     Median            : %.2f \n", tendency.getMedian() );
        System.out.printf("     Mode              : %.2f \n", tendency.getMode() );
    }

    private void addFrequencies(int[] dataSet){
        int x, a, b;
        for(int i = 0; i < dataSet.length; i++){
            x = dataSet[i];
            for(int j = 0 ; j < classIntervals.length; j++){
                a = classIntervals[j].getA();
                b = classIntervals[j].getB();
                if(x >= a && x <= b){
                    classIntervals[j].incrementTally();
                    break;
                }
            }
        }
    }

    private int getTotalFrequencies(){
        int sum = 0;
        for(int i = 0 ; i < classIntervals.length; i++){
            sum+= classIntervals[i].getTally();
        }
        return sum;
    }

    // private double getTotalRelFreq(int totalData){
    //     double sum = 0;
    //     for(int i = 0 ; i < classIntervals.length; i++){
    //         sum+= classIntervals[i].getRelFreq(totalData);
    //     }
    //     return sum;
    // }

    // private double getTotalPct(){
    //     double sum = 0;
    //     for(int i = 0 ; i < classIntervals.length; i++){
    //         sum+= classIntervals[i].getPercentage();
    //     }
    //     return sum;
    // }

    private void addCumFreq(){
        classIntervals[0].setCumFreq();
        for(int i = 1; i < classIntervals.length; i++){
            classIntervals[i].setCumFreq(classIntervals[i].getTally() + classIntervals[i-1].getCumFreq());
        }
    }

    private void addRelCumFreq(int length){
        for(int i = 0; i < classIntervals.length; i++){
            classIntervals[i].setRelCumFreq(length);
        }
    }

    private void addMidpoints(){
        for(int i = 0; i < classIntervals.length; i++){
            classIntervals[i].setMidpoint();
        }
    }

    private int getTotalFM(int totalData){
        int sum = 0;
        for(int i = 0; i < classIntervals.length; i++){
            sum += classIntervals[i].getFreqMid();
        }
        tendency.setMeanMidpoint(totalData, sum);
        return sum;
    }

    private void addDistances(int width, int totalData){
        //find largest freq index
        int highestFreqIndex = 0;
        for(int i = 1; i < classIntervals.length; i++){
            if(classIntervals[i].getTally() > classIntervals[highestFreqIndex].getTally())
            highestFreqIndex = i;
        }
        
        //set distance 0 to highest frequency class interval
        classIntervals[highestFreqIndex].setDistance(0);
        
        //iterate two loops
        int j = -1, k = 1;
        for(int i = highestFreqIndex - 1; i >= 0; i--){
            classIntervals[i].setDistance(j);
            j--;
        }

        for(int i = highestFreqIndex + 1; i < classIntervals.length; i++){
            classIntervals[i].setDistance(k);
            k++;
        }

        //finding mean using deviation
        tendency.setMeanDeviation(classIntervals[highestFreqIndex].getMidpoint(), getTotalFreqDistances(), totalData, width);
    
        //finding median
        tendency.setMedian(classIntervals[highestFreqIndex].getA() - 0.5, totalData, getCf(totalData), width, classIntervals[highestFreqIndex].getTally());

        //finding mode
        int d1 = classIntervals[highestFreqIndex].getTally() - classIntervals[highestFreqIndex - 1].getTally();
        int d2 = classIntervals[highestFreqIndex].getTally() - classIntervals[highestFreqIndex + 1].getTally();
        tendency.setMode(classIntervals[highestFreqIndex].getA() - 0.5, d1, d2, width);
    }

    private int getCf(int totalData){
        int nhalf = totalData / 2;
        int cf = classIntervals[0].getCumFreq(); 
        int i = 1;
        while(classIntervals[i].getCumFreq() <= nhalf ){
            if(i == classIntervals.length- 1) break;

            cf = classIntervals[i].getCumFreq(); 
            i++;

        }
        return cf;
    }



    private int getTotalFreqDistances(){
        int sum = 0;
        for(int i = 0; i < classIntervals.length; i++){
            sum += classIntervals[i].getFreqDistance();
        }
        return sum;
    }

}

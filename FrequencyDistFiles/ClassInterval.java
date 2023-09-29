package FrequencyDistFiles;
public class ClassInterval {
    protected int a;
    protected int b;
    protected int tally;
    protected double relativeFrequency;
    protected double percentage;
    protected int cumulativeFrequency;
    protected double relativeCumFreq;
    protected double cumPercentage;

    protected int midpoint;
    protected int freqMidpoint;
    protected int distance;
    protected int freqDistance;

    public ClassInterval(int a, int b){
        this.a = a;
        this.b = b;
        tally = 0;
        relativeFrequency = 0;
        percentage = 0;
        cumulativeFrequency = 0;
        relativeCumFreq = 0;
        cumPercentage = 0;
    }

    public int getA(){
        return a;
    }

    public int getB(){
        return b;
    }

    public int getTally(){
        return tally;
    }

    public double getRelFreq(int totalData){
        relativeFrequency = (tally + 0.0)/totalData;
        setPercentage();
        return relativeFrequency;
    }

    public double getPercentage(){
        percentage = relativeFrequency * 100;
        return percentage;
    }

    private void setPercentage(){
        percentage = relativeFrequency * 100;
    }

    public int getCumFreq(){
        return cumulativeFrequency;
    }

    public double getRelCumFreq(int totalData){
        relativeCumFreq = (cumulativeFrequency + 0.0) / totalData;
        setCumPct();
        return relativeCumFreq;
    }

    private void setCumPct(){
        cumPercentage = relativeCumFreq * 100;
    }

    public double getCumPct(){
        return cumPercentage;
    }

    public void incrementTally(){
        tally++;
    }

    public void setCumFreq(int x){
        cumulativeFrequency = x;
    }

    public void setCumFreq(){
        cumulativeFrequency = tally;
    }

    public void setRelCumFreq(int totalData){
        relativeCumFreq = (cumulativeFrequency + 0.0) / totalData;
        setCumPct();
    }

    //new methods for central tendencies
    public void setMidpoint(){
        midpoint = (a+b) / 2;
        setFreqMid();
    }

    public int getMidpoint(){
        return midpoint;
    }

    public void setFreqMid(){
        freqMidpoint = tally * midpoint;
    }

    public int getFreqMid(){
        return freqMidpoint;
    }

    public void setDistance(int distance){
        this.distance = distance;
        setFreqDistance();
    }

    public void setFreqDistance(){
        freqDistance = tally * distance;
    }

    public int getFreqDistance(){
        return freqDistance;
    }

    public void getClassData(int totalData){
        System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s %-15s\n",a +  " - " +  b, tally, midpoint, freqMidpoint,
                                                                                cumulativeFrequency, distance, freqDistance );
    }
}

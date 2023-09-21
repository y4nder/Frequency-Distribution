public class ClassInterval {
    private int a;
    private int b;
    private int tally;
    private double relativeFrequency;
    private double percentage;
    private int cumulativeFrequency;
    private double relativeCumFreq;
    private double cumPercentage;

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

    public void getClassData(int totalData){
        System.out.printf("%-15s %-15s %-15.3f %-15.2f %-15s %-15.3f %-15.1f\n",getA() +  " - " +  getB(), getTally(), getRelFreq(totalData), getPercentage(), 
                                                                                getCumFreq(), getRelCumFreq(totalData), getCumPct() );
    }
}

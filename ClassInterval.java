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

    public ClassInterval(){
        a = 0;
        b = 0;
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

    public double getRelFreq(){
        return relativeFrequency;
    }

    public double getPercentage(){
        return percentage;
    }

    public int getCumFreq(){
        return cumulativeFrequency;
    }

    public double getRelCumFreq(){
        return relativeCumFreq;
    }

    public double getCumPct(){
        return cumPercentage;
    }

    public void addtally(){
        tally++;
    }

    public void setA(int a){
        this.a = a;
    }

    public void setB(int b){
        this.b = b;
    }

    public void setRelFreq(int totalData){
        relativeFrequency = (tally + 0.0)/totalData;
        setPercentage();
    }

    private void setPercentage(){
        percentage = relativeFrequency * 100;
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

    private void setCumPct(){
        cumPercentage = relativeCumFreq * 100;
    }

}

package FrequencyDistFiles;
public class CentralTendencyGrouped {
    private double meanMidpoint;
    private double meanDeviation;
    private double mode;
    private double median;

    public double getmeanDeviation(){
        return meanDeviation;
    }

    public double getMode(){
        return mode;
    }

    public double getMedian(){
        return median;
    }

    public void setMeanMidpoint(int totalData, int totalFreqMidpoint){
        meanMidpoint = (0.0 + totalFreqMidpoint)/totalData;
    }

    public void setMeanDeviation(int highestMidFreq, int totalFreqDistance, int numberOfElements, int interval){
        meanDeviation = highestMidFreq + ( ( (0.0 + totalFreqDistance ) / numberOfElements)*interval ) ;
    }

    public void setMedian(double lowerLimit, int numberOfElements, int cf, int interval, int frqMedian){
        median = lowerLimit + ((( (0.0 + numberOfElements) / 2 - cf ) / frqMedian)*interval);
    }

    public void setMode(double lowerBoundary, int d1, int d2, int interval ){
        mode = lowerBoundary + (( d1/(0.0 + d1 + d2) ) * interval);
    }

    public double getmeanMidpoint(){
        return meanMidpoint;
    }

}

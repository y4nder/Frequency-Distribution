import FrequencyDistFiles.FrequencyDistributionTable;
public class Main {
    public static void main(String[] args){
        int[] dataSet = {
                            49, 52, 49, 54, 57, 52, 52, 53, 49, 47,
                            51, 48, 55, 53, 55, 47, 53, 43, 48, 46,
                            54, 46, 51, 48, 53, 56, 48, 47, 49, 57,
                            55, 53, 50, 47, 57, 49, 43, 58, 52, 44,
                            46, 59, 57, 47, 61, 60, 49, 53, 41, 48,
                            59, 53, 45, 45, 56, 40, 46, 49, 50, 57
                        };
        printArr(dataSet);
        //creating the table
        int classes = 5; //define class count
        FrequencyDistributionTable f = new FrequencyDistributionTable(dataSet, classes); //create the object
    }

    static void printArr(int[] arr){
        System.out.println("\n------------SET DATA------------");
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + ", ");
        }
        System.out.println("\n");
    }
}

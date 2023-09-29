package FrequencyDistFiles;
abstract class FrequencyDistibution {
    protected int highestElem;
    protected int lowestElem;
    protected int width;
    protected int classes;
    
    public void getWidth(int[] array, int classes){
        findHighAndLow(array);
        //compute for number of classes
        this.classes = classes;
        width = (highestElem - lowestElem) / this.classes;

        if(width % classes != 0){
            width++;
        }

    }
    
    public void findHighAndLow(int[] array){
        //initialize temporary lowest and highest element
        lowestElem = array[0];
        highestElem = array[array.length - 1];

        //indeces for highest and lowest element
        int i = 1, j = array.length - 2;
        
        while(i < array.length || j >= 0){

            //check if index i is the lowest element
            if(array[i] < lowestElem){
                lowestElem = array[i];
            }
            
            //check if index j is the highest element
            if(array[j] > highestElem){
                highestElem = array[j];
            }

            i++;
            j--;
        }
    }


}

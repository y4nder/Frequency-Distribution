public class Tester {
    public static void main(String[] args){
        int[] dataSet = {102, 124, 108, 86, 103, 82,
                        71, 104, 112, 118, 87, 95,
                        103, 116, 85, 122, 87, 100,
                        105, 97, 107, 67, 78, 125,
                        109, 99, 105, 99, 101, 92 
        };

        int[] dataSet2 = {57, 51, 53, 52, 50, 60, 51, 51, 52, 52,
                          44, 53, 45, 57, 39, 53, 58, 47, 51, 48,
                          49, 49, 44, 54, 46, 52, 55, 54, 47, 53,
                          49, 52, 49, 54, 57, 52, 52, 53, 49, 47,
                          51, 48, 55, 53, 55, 47, 53, 43, 48, 46,
                          54, 46, 51, 48, 53, 56, 48, 47, 49, 57, 
                          55, 53, 50, 47, 57, 49, 43, 58, 52, 44,
                          46, 59, 57, 47, 61, 60, 49, 53, 41, 48,
                          59, 53, 45, 45, 56, 40, 46, 49, 50, 57, 
                          47, 52, 48, 50, 45, 56, 47, 47, 48, 46,  
        };

        int[] dataSet3 = {152, 165, 164, 165, 177, 200, 217, 169,
                          192, 152, 124, 146, 167, 140, 155, 139,
                          167, 162, 160, 223, 205, 165, 142, 175, 
                          136, 198, 152, 133, 230, 187,
        };

        int[] x = dataSet2;
        int classes = 5;
        printArr(x);
        int high = findHigh(x);
        int low = findLow(x);
        int width = getWidth(high, low, classes);
        System.out.println("width = " + width);
        Classes CL = new Classes(x, width, classes, low);
    }

    static int getWidth(int high, int low, int classes){
        int width = 0;

        width = high - low;
        width /= classes;
        if(width % classes != 0) {
            width ++;
        }        
        return width;
    }

    static int findHigh(int[] arr){
        int high = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] > high) high = arr[i];
        }
        System.out.println("highest data = " + high);
        return high;
    }

    static int findLow(int[] arr){
        int low = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] < low) low = arr[i];
        }
        System.out.println("lowest data = " + low);
        return low;
    }

    static void printArr(int[] arr){
        System.out.println("\n                  SET DATA");
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + ", ");
        }
        System.out.println("\n");
    }
}

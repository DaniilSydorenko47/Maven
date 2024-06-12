package HW26;

public class Methods {
    public double average(int[] array) {
        int sum = 0;
        if(array == null){
            return -1;
        }
        if(array.length == 0){
            return -2;
        }
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum / array.length;
    }

    public boolean squareArray(int[][] array) {
        int counter = 0;
        if(array == null){
            return false;
        }
        if(array.length == 0){
            return false;
        }
        for (int i = 0; i < array.length; i++) {
            if(array.length == array[i].length){
                counter++;
            }
        }
        if(counter == array.length){
            return true;
        }
        return false;
    }
}
import java.util.Arrays;

public class task1 {
   public static void main(String[] args) {
   // Сортировка подсчетом
   // [1, 2, 3, 4, 5, 2, 3, 4, 5, 3, 4, 5, 4, 5, 5]
   // 1 -> 1
   // 2 -> 2
   // 3 -> 3
   // 4 -> 4
   // 5 -> 5
   // В исходный массив всталяем 1 единицу, 2 двойки, 3 тройки и т.д.
      int[] array = {1, 2, 3, 4, 5, 2, 3, 4, 5, 3, 4, 5, 4, 5, 5};
      countingSort(array);
      System.out.println("Finish" + Arrays.toString(array));
      System.out.println(" ");

      int[] array1 = {-10, 2, 10, 3, 4, 5, 2, 3, 4, -10, -3, -3, 5, 3, 4, 5, 4, 5, 5, 10, 10};
      countingSort(array1);
      System.out.println("Finish" + Arrays.toString(array1));
      System.out.println(" ");
   } 

   public static void countingSort(int[] array) {
      // System.out.println("Start array: " + Arrays.toString(array));
      int max = Integer.MIN_VALUE;
      int min = Integer.MAX_VALUE;
      for (int i = 0; i < array.length; i++) {
         if (max < array[i]) {
            max = array[i];
         }
         if (min > array[i]) {
            min = array[i];
         }
      }
      // System.out.println("max: " + max);
      // System.out.println("min: " + min);

      int[] buffer = new int[max - min + 1];
      // System.out.println("Init buffer: " + Arrays.toString(buffer));
      for (int i = 0; i < array.length; i++) {
         buffer[array[i] - min]++;
      }
      // System.out.println("Filling buffer: " + Arrays.toString(buffer));

      int arrayIndex = 0;
      for (int i = 0; i < buffer.length; i++) {
         for (int j = buffer[i]; j > 0; j--) {
            array[arrayIndex++] = i + min;
         }
      }
      // System.out.println("result array: " + Arrays.toString(array));
   }
}
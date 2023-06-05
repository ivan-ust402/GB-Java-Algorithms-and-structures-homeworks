import java.util.Arrays;

public class task1 {
    // Дано: отсортированный массив с повторяющимися элементами
    // например, 0, 0, 1, 1, 1, 2, 2, 3, 3, 4
    // Нужно: "схлопнуть" повторяющиеся элементы в ЭТОМ ЖЕ массиве
    // Оставшиеся элементы могут быть любыми
    // Должно получится так: 0, 1, 2, 3, 4, - 
    public static void main(String[] args) {
        int[] array = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        removeDuplicates(array);
        System.out.println(Arrays.toString(array));
    }

    public static void removeDuplicates(int[] array) {
        // O(n)
        int i = 0;
        for (int j = 1; j < array.length; j++) {
            if(array[j] != array[i]) {
                i += 1;
                array[i] = array[j];
                System.out.println(array[j]);
            }
        }
    }
}

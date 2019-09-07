class LowArray /* упорядоченный массив */ {
    private long[] a; // Ссылка на массив a

    public LowArray(int size) // Конструктор
    {
        a = new long[size];
    } // Создание массива

    private int a_length; /* длина массива */

    public void insert(long value) // Вставка элемента в массив
    {
        int j;
        for (j = 0; j < a_length; j++) // Определение позиции вставки
            if (a[j] > value) // (линейный поиск)
                break;
        for (int k = a_length; k > j; k--) // Перемещение последующих элементов
            a[k] = a[k - 1];
        a[j] = value; // Вставка
        a_length++; // Увеличение размера
    }

    public int find(long search_key) /* двоичный поиск - в упорядоченном массиве */
        /* функция ищет в массиве search_key и возвращает номер его позиции, иначе -1 */ {
        int lower_bound = 0; /* нижняя граница */
        int upper_bound = a_length - 1; /* верхняя граница */
        int cur_in; /* сепаратор */
        while (true) {
            cur_in = (lower_bound + upper_bound) / 2; /* устанавливаем сепаратор в середину */
            if (a[cur_in] == search_key) return cur_in; // Элемент найден
            else if (lower_bound > upper_bound)
                return -1; // Элемент не найден
            else {  // Деление диапазона
                if (a[cur_in] < search_key) lower_bound = cur_in + 1; // В верхней половине
                else upper_bound = cur_in - 1; // В нижней половине
            }
        }
    }

    public boolean delete(long value) { /* удаление элемента из массива */
        int j = find(value); /* определяем позицию элемента */
        if (j == -1) // Найти не удалось
            return false;
        else {  // Значение найдено
            for (int k = j; k < a_length; k++) // Сдвиг последующих элементов
                a[k] = a[k + 1];
            a_length--; // Уменьшение размера
            return true;
        }
    }
    public void print ()
    {
        System.out.println("length = " + a_length);
        for (int i = 0; i < a_length; i++) {
            System.out.println("arr[i] = " + a[i]);
        }
    }
}
    public class main {
	public static void main (String[] args) {
	    int size = 10;
	    int random_numbers = 3; /* количество случайных чисел */
	    int random_max = 666; /* максимум */
        LowArray arr = new LowArray (size);
        for (int i = 0; i < random_numbers; i++) {
            arr.insert ((long) (Math.random() * random_max));
        }
        arr.print();
        int search = -45;
        arr.insert (search);
        arr.print();
        int f = arr.find(search);
        System.out.println (search + " на " + f + " месте");
        arr.delete (search);
        arr.print();
        System.out.println( arr.find(search) + " - не нашли "+ search);
    }
}

package homework20;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
// 1. Создать пустой поток с двумя любыми промежуточными операциями и одной терминальной-которая напечатает
// результат коллекции;
        Stream.empty()
                .limit(15)
                .distinct()
                .forEach(System.out::println);

//2. Создать поток с Листом данных(на Ваше усмотрения), который будет иметь две промежуточные операции и
// результатом выполнения получить Набор данных;

        List<String> list = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9");
        Stream<String> stringStream = list.stream()
                .skip(1)
                .limit(5);
        stringStream.collect(Collectors.toSet());
//3. Создать поток Набора данных(на Ваше усмотрение), который не будет иметь промежуточных данных и результатом будет
// Лист данных;
        HashSet<String> stringHashSet = new HashSet<>();
        stringHashSet.add("123");
        stringHashSet.add("456");
        stringHashSet.add("789");
        stringHashSet.stream().collect(Collectors.toList());

//4. Создать Коллекцию в виде “ключ-значение”, наполнить, получив значение ключей пройтись по всем, напечатать их
// значение и результатом сохранить в виде коллекции;
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "Ivan");
        hashMap.put(2, "Nikolai");
        hashMap.put(3, "Oleg");
        hashMap.put(4, "Peter");

        List<String> names = hashMap.entrySet().stream()
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
        System.out.println(names);

//5. Cоздать коллекцию из 10 строчных значений в виде чисел. Используя стрим пропустить первое значение, указать
// лимит 8 значений, преобразовать все значения в int, отфильтровать значения только четных значения и собрать
// результат в коллекцию ТОЛЬКО уникальных значений;
        List<String> list1 = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
        List<Integer> newList = list1.stream()
                .skip(1)
                .limit(8)
                .map(Integer::parseInt)
                .filter(i -> i % 2 != 0)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(newList);

//6. Создать поток, сразу наполнив его данными(не из коллекции), преобразовать в многопоточный поток, отсортировать,
// задать фильтр(на свое усмотрение) и найти первый элемент, который попадется(как результат выполнения);
        Stream<Integer> streamFromValues = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Optional<Integer> first = streamFromValues
                .parallel()
                .filter(i -> (i > 3))
                .findFirst();
        System.out.println(first);
//7. Создать поток, в котором показать применения всех 4х возможных вызовов Ссылочных методов. На свое усмотрение,
// но должны быть примеры вызовов всех методов в одном потоке. Можно создавать свои классы и методы для примера вызова,
// можно использовать представленные уже в Java;
        List<String> list2 = Arrays.asList("Oleg", "2", "George", "4", "Kate", "6", "7", "John", "9", "10");
        Stream<Object> newList2 = list2.stream()
                .filter(string -> string.length() > 1)
                .map(String::valueOf) //containingObject::instanceMethodName - ссылка на нестатический метод конкретного объекта;
                .map(String::toLowerCase) //ContainingType::methodName - ссылка на нестатический метод любого объекта конкретного типа;
                .map(Integer::parseInt) //ContainingClass::staticMethodName - ссылка на статический метод
                .map(User::new);  //ClassName::new - ссылка на конструктор

        newList2.forEach(System.out::println); //containingObject::instanceMethodName - ссылка на нестатический метод конкретного объекта;




    }
}

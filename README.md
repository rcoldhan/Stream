### Stream
#### Исходные данные:

##### Класс "Мальчик"
```java
public class Boy {
    private String name;
    private int age;
    Boy(final String name, final int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {return name;}
    public int getAge() { return age;}
    @Override
    public String toString() { return name + "-" + age; }
}
```
##### Список мальчиков
```java
final ArrayList<Boy> boys = new ArrayList<>() {{
            add(new Boy("Николай", 68));
            add(new Boy("Пётр", 53));
            add(new Boy("Василий", 25));
            add(new Boy("Михаил", 19));
            add(new Boy("Алексей", 6));
            add(new Boy("Николай", 86));
            add(new Boy("Пётр", 35));
            add(new Boy("Михаил", 111));
            add(new Boy("Алексей", 22));
            add(new Boy("Михаил", 1));
            add(new Boy("Яков", 30));
        }};
```

#### Требования:

Используя только **STREAM API**, отфильтровать мальчиков по следующему принципу:
1. Собрать имена совершеннолетних;
2. Убрать дубли, отсортировать по алфавиту и оставить четверых;
3. Собрать получившиеся имена в мапу, где где **ключ** - имя мальчика, **значение** - количество его тёзок в списке;
4. Вывести результат в консоль;
5. Устранить все проблемы **CheckStyle** и **SpotBugs** (**magic numbers** в исходных данных можно игнорировать).

Результат должен получиться следующий (формат вывода может отличаться):
```java
{Василий=0, Алексей=1, Михаил=2, Николай=1}
```

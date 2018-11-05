var file = new java.io.File("z.txt");
var scanner = new java.util.Scanner(new java.io.FileReader(file));
var words = new java.util.ArrayList();
while (scanner.hasNext()) words.add(scanner.next());
var stream = words.stream();
stream.filter(function (s) {
    return s.length >= 12;
}).sorted(function (s1, s2) {
    return s1.compareTo(s2);
}).forEach(function (s) {
    print(s);
});

/*
т.к. используется JavaScript, ему неизвестно что такое Generics
поэтому приходится использовать обобщшенные коллекции

кроме того, JS не имеет лямбда-выражений в том представлении, в котором они
существуют в Java. поэтому вместо них передаются анонимные функции.
*/
package revision.array;

public class ArrayListController {
    public static void main(String[] args) {
        ModArrayList listx = new ModArrayList<>();

        listx.add(0);
        listx.add(10);
        listx.add(20);
        listx.add(100);

        System.out.println(listx.getUsingMod(1));
        System.out.println(listx.getUsingMod(-2));
        // 40 can be divided by 4 and has remainder 0, it should be 0
        System.out.println(listx.getUsingMod(40));
    }
}

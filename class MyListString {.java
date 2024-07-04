// without using generics
// class MyListString {
//     public String a;
//     public set(String a) {
//         this.a = a;
//     }
// }

// class MyListInt {
//     public Int a;
//     public set(Int a) {
//         this.a = a;
//     }
// }

// class MyListDouble {
//     public Double a;
//     public set(Double a) {
//         this.a = a;
//     }
// }

// class MyListBoolean {
//     public Boolean a;
//     public set(Boolean a) {
//         this.a = a;
//     }
// }

// benefit for using generics
class MyList<T> {
    public T a;
    public set(T a) {
        this.a = a;
    }
}

public static void main(String[] args) {
    MyList<Integer> l = new MyList<>();

    MyListString l3 = new MyListString();
    MyListInt l3 = new MyListInt();

    ArrayList<String> l2 = new ArrayList<>();
}

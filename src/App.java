import com.github.rioh1118.bst.Bst;

public class App {
    public static void main(String[] args) throws Exception {
        Bst<Integer, String> tree = new Bst<>();

        tree.insert(1, "one");
        tree.insert(2, "two");

        tree.printTree();

    }
}

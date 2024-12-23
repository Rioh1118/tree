import com.github.rioh1118.bst.Bst;
import java.util.Optional;

public class App {
    public static void main(String[] args) throws Exception {
        Bst<Integer, String> tree = new Bst<>();

        tree.insert(3, "three");
        tree.insert(1, "one");
        tree.insert(2, "two");
        tree.insert(5, "five");
        tree.insert(4, "four");

        tree.printTree();

        Optional<String> result = tree.search(5);
        if (result.isPresent()) {
            System.out.println(result.get());
        } else {
            System.out.println("Not found.");
        }

        tree.delete(3);
        tree.delete(5);

        tree.printTree();
    }
}

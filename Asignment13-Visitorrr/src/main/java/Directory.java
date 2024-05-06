import java.util.ArrayList;
import java.util.List;

public class Directory implements org.example.FileSystemElement {
    private String name;
    private List<org.example.FileSystemElement> elements;

    public Directory(String name) {
        this.name = name;
        this.elements = new ArrayList<>();
    }

    public void addElement(org.example.FileSystemElement element) {
        elements.add(element);
    }

    public String getName() {
        return name;
    }

    public List<FileSystemElement> getElements() {
        return elements;
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
        for (FileSystemElement element : elements) {
            element.accept(visitor);
        }
    }
}

public class SizeCalculatorVisitor implements org.example1.FileSystemVisitor {
    private double totalSize = 0;

    @Override
    public void visit(File file){
        totalSize += file.getSize();
    }
    @Override
    public void visit(Directory directory){

    }
    public double getTotalSize(){
        return totalSize;
    }
}

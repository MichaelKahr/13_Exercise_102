
import java.util.LinkedList;
import javax.swing.AbstractListModel;

public class FileModell extends AbstractListModel{

    private LinkedList<Datei> files = new LinkedList<>();
    @Override
    public int getSize() {
        return files.size();
    }

    @Override
    public Object getElementAt(int index) {
        return files.get(index);
    }

}

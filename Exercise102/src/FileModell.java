
import java.io.File;
import java.util.LinkedList;
import javax.swing.AbstractListModel;

public class FileModell extends AbstractListModel{

    private LinkedList<Datei> files = new LinkedList<>();
    
    public void add(Datei d){
        files.add(d);
        fireIntervalAdded(this, files.size()-1, files.size()-1);
    }
    
    @Override
    public int getSize() {
        return files.size();
    }

    public void listFiles(){
        File[] files = new File("/Users/mikeykahr/Desktop/Privat/SCHULE/POS/3.Klasse/Exercises/Exercise102/Exercise102r").listFiles();
        // this.add(new Datei("..."));
        for (File file : files){
            this.add(new Datei(file.getAbsolutePath()));
        }
    }
    
    @Override
    public Object getElementAt(int index) {
        return files.get(index);
    }
    
    public void clearList(){
        files.clear();
        fireContentsChanged(this, 0, files.size()-1);
    }

}

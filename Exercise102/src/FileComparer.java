
import java.util.Comparator;

public class FileComparer implements Comparator<Datei>{

    @Override
    public int compare(Datei o1, Datei o2) {
        if(o1.isDirectory() && o2.isFile()){
            return -1;
        }else if(o1.isFile() && o2.isDirectory()){
            return 1;
        }
        return o1.getName().compareTo(o2.getName());
    }
    
}

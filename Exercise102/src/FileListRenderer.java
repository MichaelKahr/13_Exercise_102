
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

public class FileListRenderer implements ListCellRenderer{

    @Override
    public Component getListCellRendererComponent(JList list, Object o, int i, boolean isSelected, boolean hasFocus) {
        JLabel label = new JLabel(o.toString());
        label.setOpaque(true); //macht den hintergrund nicht durchichtig
        if(o instanceof Datei){
            Datei item = (Datei)o;
            if(item.isDirectory()){
                label.setForeground(Color.red);
            }else{
                label.setForeground(Color.blue);
            }
            
        }
        label.setBackground(isSelected ? Color.lightGray:Color.white);
        
        return label;
    }

}

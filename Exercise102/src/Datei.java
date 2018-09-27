
import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class Datei extends File {

    private String name;
    private LocalDateTime last_changed;
    private int size;
    private String attributes;
    private boolean hidden;
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.YYYY ");

    public Datei(String pathname) {
        super(pathname);
        name = this.getName();
        last_changed = LocalDateTime.ofEpochSecond(this.lastModified() / 1000, 0, ZoneOffset.UTC);
        size = (int) this.length();
        attributes = setAttributes(this);
        hidden = this.isHidden();
    }

    public String setAttributes(File file) {
        StringBuilder sb = new StringBuilder();
        if (file.canRead()) {
            sb.append("R");
        }
        if (file.canWrite()) {
            sb.append("W");
        }
        if (file.canExecute()) {
            sb.append("X");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        if (this.isDirectory() || this.name.equals("..")) {
            return name;
        } else {
            return String.format("%s %s %d KB %s", name, last_changed + "", size, setAttributes(this), hidden);
        }
    }

}

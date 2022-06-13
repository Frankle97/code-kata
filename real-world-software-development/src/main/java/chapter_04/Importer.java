package chapter_04;

import javax.print.Doc;
import java.io.File;
import java.io.IOException;

public interface Importer {
    public static final String PATH = "path";
    public static final String WIDTH = "width";
    public static final String HEIGHT = "height";
    public static final String TYPE = "type";

    Document importFile(File file) throws IOException;
}

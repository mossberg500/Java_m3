package homework1.task2;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

@SaveToFile(str = "folderProject\\save2.txt")
public class TextContainer {
    private String st = "String  test text ";



    public TextContainer() {
    }

    @Saver
    public void save(String path) {
     //   File file1 = new File("1u.txt");
     //   writeFile(file1);
     //   System.out.println(file1.getPath());

        File file = new File(path);
        if (file.isFile()) {
            writeFile(file);
        } else {
            try {
                boolean createFile = file.createNewFile();
                if (createFile) {
                    writeFile(file);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void writeFile(File file) {
        try (FileWriter fr = new FileWriter(file)) {
            fr.write(st);
            fr.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}

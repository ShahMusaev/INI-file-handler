package Handler;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class INI {

    private HashSet<Section> sections;


    public INI(File file) throws FileNotFoundException, InvalidFormattingException {

        String format = getFileExtension(file);

        if (!format.equals("ini")) {
            throw new InvalidFormattingException();
        }

        sections = new HashSet<>();

        Section current = null;
        Scanner input = new Scanner(file);

        while (input.hasNext()) {

            String[] line = input.nextLine().split("\\s*=\\s*|\\s*;\\s*");

            if (line[0].equals("")) {
                continue;
            }

            if (line[0].matches("\\[\\w+]")) {
                current = new Section(line[0]);
                sections.add(current);
            }
            else if (current != null && line.length <=3 && line.length >=2 && line[0].matches("\\w+")) {
                current.add(line[0], line[1]);
            }
            else {
                throw new InvalidFormattingException(Arrays.toString(line)+" - Invalid Format");
            }

        }
    }


    public <Type> Type get(Class<Type> clazz, String parameter, String _section)
            throws Exception {

        Type result = null;

        for (Section section : sections) {
            if (section.name().equals(_section)) {
                if (section.get(parameter) == null) {
                    throw new Exception(parameter + " doesn't exist in " + section);
                }
                if (clazz == Integer.class) {
                    result = clazz.cast(Integer.parseInt(section.get(parameter)));
                }
                else if (clazz == Double.class) {
                    result = clazz.cast(Double.parseDouble(section.get(parameter)));
                }
                else {
                    result = clazz.cast(section.get(parameter));
                }
                break;
            }
        }

        if (result == null) {
            throw new Exception(_section + " doesn't exist");
        }

        return result;
    }

    private static String getFileExtension(File file) {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }
}

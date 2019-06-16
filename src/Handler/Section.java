package Handler;

import java.util.*;

public class Section {

    private String name;

    private Map<String, String> parameters;

    public Section(String name) {
        this.name = name;
        this.parameters = new HashMap<>();
    }


    public void add(String key, String value) {
        parameters.put(key, value);
    }



    public String name() {
        return name;
    }


    public String get(String key) {
        return parameters.get(key);
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Section section = (Section) o;
        return Objects.equals(name, section.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}


package it.ozimov.seldon.core;

import java.util.List;

import org.yaml.snakeyaml.Yaml;

public class PropertiesReader {

    private PropertiesReader() { }

    // https://bitbucket.org/asomov/snakeyaml/wiki/Documentation
    public void doSomething() {
        Yaml yaml = new Yaml();
        String document = "\n- Hesperiidae\n- Papilionidae\n- Apatelodidae\n- Epiplemidae";
        List<String> list = (List<String>) yaml.load(document);
        System.out.println(list);

        // ['Hesperiidae', 'Papilionidae', 'Apatelodidae', 'Epiplemidae']
    }

}

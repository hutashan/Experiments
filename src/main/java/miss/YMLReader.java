package miss;

import org.yaml.snakeyaml.Yaml;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


public class YMLReader {
    private static final String INCLUDES = "includes";
    private static final String configDirectory = "src/data";
    private static Map<String, Object> loaderConfig;

    private static void loadFile(String filePath, String configDir) throws FileNotFoundException {
        Yaml yaml = new Yaml();
        Path pathObj = Paths.get(configDir, filePath);
        Map configProperties  = yaml.loadAs(new FileReader(pathObj.toFile()), Map.class);
        System.out.println(configProperties.toString());

        final LinkedHashMap<String, Map<String,String>>  extractionFieldsExtractions = (LinkedHashMap<String, Map<String,String>>) configProperties.get("extraction_fields");
        Map<String,String> mp = extractionFieldsExtractions.get("host");
        for (Map.Entry<String,String> entry : mp.entrySet())
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());

    }

    public static Map<String, Object> loadConfigs(String filePath, String configDir) throws Exception, Exception {
        if (filePath != null && !filePath.isEmpty()){
            if (loaderConfig == null) {
                loaderConfig = new HashMap<>();
                loadFile(filePath, configDir);
            }

            return loaderConfig;
        } else {
            throw new Exception("Empty config file path: ");
        }
    }

    public static Map<String, Object> loadConfigs(String filePath) throws FileNotFoundException, Exception {
        return loadConfigs(filePath, configDirectory);
    }

    public static void main(String[] args) throws FileNotFoundException {
        loadFile("test.yml",configDirectory);
    }
}

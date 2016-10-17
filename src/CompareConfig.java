import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CompareConfig {

	public static void main(String[] args) throws IOException {

		List<String> list = new ArrayList<>();
		try (Stream<String> stream = Files.lines(Paths.get("/Users/Bethu/Documents/jconfig/batch-config.prop"))) {
			list = stream.filter(line -> !line.startsWith("#")).collect(Collectors.toList());
			Collections.sort(list);
			list.forEach(System.out::println);
			HashMap<String, String> hmap = new HashMap<>();
			list.forEach((temp) -> {
				if(temp.contains("=")){
				hmap.put(temp.substring(0, temp.indexOf("=")), temp.substring(temp.indexOf("="), (temp.length())));
				}
				});
			File file = new File("/Users/Bethu/Documents/jconfig/fileName.txt");
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			for(Map.Entry<String, String> entry : hmap.entrySet()){ System.out.printf("%s%s%n", entry.getKey(), entry.getValue());
			String text = entry.getKey()+entry.getValue();
			bw.append(text);
			bw.newLine();
			}
			bw.close();
			}
	}
}

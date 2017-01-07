import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Stream;


public class DataBase {

	private static Map<Integer, Map<String, String>> data;
	private static DataBase dataBase = new DataBase();
	private int wordsCount = 0;
	public static final String FILE_NAME = "words.txt";
	private UiElementFactory factory = new UiElementFactory();

	private DataBase() {
		load();
	}
	
	private void load(){
		data = new HashMap<Integer, Map<String, String>>();
		wordsCount = 0;

		// Load from file
		try (Stream<String> stream = Files.lines(Paths.get(DataBase.FILE_NAME))) {
			Iterator<String> iterator = stream.iterator();
			iterator.forEachRemaining(w -> {
				System.out.println(w);
				HashMap<String, String> wordsPair = new HashMap<String, String>();
				wordsPair.put(w, iterator.next());
				data.put(wordsCount, wordsPair);
				wordsCount++;
			});

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void createWordsPair(String wordPL, String wordENG) {
			Map<String, String> wordsPair = new HashMap<>();
			wordsPair.put(wordPL, wordENG);
			data.put(wordsCount, wordsPair);
			wordsCount++;
			save();
	}

	public Map<String, String> readWordsPair(int index) {
		return data.get(index);
	}

	public void updateWordsPair(int index, String wordPL, String wordENG) {
		Map<String, String> updatedMap = new HashMap<String, String>();
		updatedMap.put(wordPL, wordENG);
		data.replace(index, updatedMap);
		save();
	}

	public void deleteWordsPair(int index) {
		data.remove(index);
		save();
		load();
	}

	public int getSize() {
		return data.size();
	}

	public void save() {
		try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(DataBase.FILE_NAME))) {
			data.forEach((k, v) -> {
				v.forEach((x, z) -> {
					try {
						writer.write(x + "\n");
						writer.write(z + "\n");
					} catch (IOException e) {
						e.printStackTrace();
					}
				});
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public static DataBase getDataBase() {
		return dataBase;
	}

}

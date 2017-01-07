import java.util.Map;

public interface IDbOperations {

	public void create(String wordPL, String wordEng);
	public Map<String, String> read(int index);
	public void update(int index, String wordPL, String wordENG);
	public void delete(int index);
	public int getWordsCount();
	
}

import java.util.Map;

public interface IDbOperations {

	public void create(String str1,String str2);
	public Map<String,String> read(int int1);
	public void update(int int1,String str1, String str2);
	public void delete(int int1);
	public int getWordsCount();
	
}

import java.util.Map;

public class DbAdapter implements IDbOperations {

	private DataBase dataBase = DataBase.getDataBase();
	
	@Override
	public void create(String wordPL, String wordEng) {
		dataBase.createWordsPair(wordPL, wordEng);
		
	}

	@Override
	public Map<String, String> read(int index) {
		return dataBase.readWordsPair(index);
	}

	@Override
	public void update(int index, String wordPL, String wordENG) {
		dataBase.updateWordsPair(index, wordPL, wordENG);
	}

	@Override
	public void delete(int index) {
		dataBase.deleteWordsPair(index);
		
	}

	@Override
	public int getWordsCount() {
		return dataBase.getSize();
	}

	@Override
	public boolean polishWordExist(String wordPl) {
		
		return false;
	}
	
	

}

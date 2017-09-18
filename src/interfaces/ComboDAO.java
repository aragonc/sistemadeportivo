package interfaces;

import java.util.List;
import beans.ComboDTO;

public interface ComboDAO {
	public List<ComboDTO> listarCombo(String field);
	public List<ComboDTO> listarComboSql(String misql);
}

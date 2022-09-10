package manager.cellFactory;

import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;
import javafx.util.StringConverter;
import manager.models.TableModel;

public class CellFactory {

	// Cellstruktur
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Callback<TableColumn<TableModel, String>, TableCell<TableModel, String>> cellFactoryForMap = (
		TableColumn<TableModel, String> p) -> new TextFieldTableCell(new StringConverter<String>() {
			@Override
			public String toString(String t) {
				try {
					return t.toString();
				} catch (NullPointerException e) {
					System.out.println("Kein Wert gegeben!");
				}
				return null;
			}

			@Override
			public String fromString(String string) {
				return string;
			}
		});

}
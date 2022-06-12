package hust.soict.globalict.aims.gui.res;

import java.util.List;

import hust.soict.globalict.aims.media.Track;
import hust.soict.globalict.aims.order.Order;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AIMSResources {
	public static ObservableList<Track> cur_trackList = FXCollections.observableArrayList();
	public static ObservableList<String> request = FXCollections.observableArrayList();
	
	public static int currentItemIndex;
	
    public static final String MENU_REFRESH_SCREEN_REQUEST = "refreshScene";
    public static final String ADDITEM_REFRESH_TRACK_TABLE_REQUEST = "refreshTrackTableinAddItem";
    public static List<Order> orderList;
	public static int cur_OrderIndex;
	
}

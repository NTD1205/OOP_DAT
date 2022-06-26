package hust.soict.hedspi.aims;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import hust.soict.hedspi.aims.exceptions.CreateOrderException;
import hust.soict.hedspi.aims.exceptions.LuckyItemException;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.book.Book;
import hust.soict.hedspi.aims.media.disc.DigitalVideoDisc;
import hust.soict.hedspi.aims.order.Order;

public class MenuFrame extends JFrame{
	JButton createButton = new JButton("Create new Order");;
	JButton addButton = new JButton("Add item to the order");
	JButton deleteButton = new JButton("Delete item by Id");
	JButton displayButton =  new JButton("Display the items of list order ");
	JButton exitButton = new JButton("Exit");
	public static Order anOrder;
	
	public MenuFrame(JFrame frame) {
		// Draw frame
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,450);
		setResizable(false);
		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (int) ((dimension.getWidth() - 500))/2;
		int y = (int) ((dimension.getHeight() - 450))/2;
		setLocation(x, y);
		setVisible(true);
		setTitle("Order System");
		
		// Button Create new order
		createButton.setSize(300, 60);
		createButton.setLocation(100,20);
		createButton.setFocusPainted(false);
		createButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				try {
					anOrder = Order.createdOrder();
					JOptionPane.showMessageDialog(null,"Create new Order successfully");
				} catch (CreateOrderException e2) {
					JOptionPane.showMessageDialog(null, e2.getMessage(),"Warning",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		add(createButton);
		
		// Button add item into order
		addButton.setSize(300, 60);
		addButton.setLocation(100,100);
		addButton.setFocusPainted(false);
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(anOrder != null) {
					// Create Frame Dialog
					new AddMediaDialog();
				}else {
					JOptionPane.showMessageDialog(null,"Please create an order","Warning",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		add(addButton);
		
		// Button delete an item from order
		deleteButton.setSize(300, 60);
		deleteButton.setLocation(100,180);
		deleteButton.setFocusPainted(false);
		deleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(anOrder != null) {
					String strid = JOptionPane.showInputDialog(null,
				            "Moi ban nhap ID muon xoa: ",
				            "Delete ID",
				            JOptionPane.INFORMATION_MESSAGE);
					if(anOrder.removeMedia(strid) == true) {
						JOptionPane.showMessageDialog(null,"Delete Media have ID = "+ strid + " sucessfully");
					}
					else {
						JOptionPane.showMessageDialog(null,"Don't exist Media have ID = " + strid,"Warning",JOptionPane.WARNING_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(null,"Please create an order","Warning",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		add(deleteButton);
		
		displayButton.setSize(300, 60);
		displayButton.setLocation(100,260);
		displayButton.setFocusPainted(false);
		displayButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(anOrder != null) {
					// Create frame of dialog
					JDialog displayDialog = new JDialog();
					displayDialog.setSize(600,400);
					displayDialog.setLayout(null);
					displayDialog.setResizable(false);
					
					Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
					int x = (int) ((dimension.getWidth() - 600))/2;
					int y = (int) ((dimension.getHeight() - 400))/2;
					displayDialog.setLocation(x, y);
					
					displayDialog.setVisible(false);
					displayDialog.setModal(true);
					displayDialog.setTitle("List items of Order");
					
					String column_names[]= {"ID","Type","Title","Category","Cost($)"};
					List<Media> items = new ArrayList<Media>();
					items = anOrder.itemsOrdered;
					java.util.Collections.sort(items);
					DefaultTableModel model = new DefaultTableModel(null,column_names); 
					JTable table = new JTable(model);
					float cost = 0;
					Media temp = null;
					try {
						 temp = anOrder.getALuckyItem();
					} catch (LuckyItemException e2) {
						JOptionPane.showMessageDialog(null, e2.getMessage(), "WARNING", JOptionPane.WARNING_MESSAGE);
					}
					for(Media media: items) {
						String typeString ;
						if(media instanceof Book)
							typeString = "Book"; 
						else if (media instanceof DigitalVideoDisc) {
							typeString = "DVD"; 
						}
						else {
							typeString = "CD";
						}
						if(media == temp) {
							cost = media.getCost();
							model.addRow(new Object[]{media.getId(),typeString,
									media.getTitle(),media.getCategory(),0.0});
						}else {
							model.addRow(new Object[]{media.getId(),typeString,
									media.getTitle(),media.getCategory(), media.getCost()});
						}
					}
					
					model.addRow(new Object[] {"","","","Total: ",anOrder.totalCost() - cost});					
					table.setSize(500, 300);
					table.setLocation(50,30);
					displayDialog.setLayout(new BorderLayout());
					displayDialog.add(table.getTableHeader(), BorderLayout.PAGE_START);
					displayDialog.add(table, BorderLayout.CENTER);					
					TableColumn column = null;
					for (int i = 0; i < 5; i++) {
					    column = table.getColumnModel().getColumn(i);
					    if (i == 0) {
					        column.setPreferredWidth(50); 
					    } 
					    if (i == 1) {
					        column.setPreferredWidth(50); 
					    }
					    if (i == 2) {
					        column.setPreferredWidth(200); 
					    }
					    if (i == 3) {
					        column.setPreferredWidth(150); 
					    }
					    if (i == 4) {
					        column.setPreferredWidth(50); 
					    }
					    
					}
					displayDialog.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null,"Please create an order","Warning",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		add(displayButton);
		
		exitButton.setSize(300, 60);
		exitButton.setLocation(100,340);
		exitButton.setFocusPainted(false);
		exitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		add(exitButton);

		setVisible(true);
		
	}
	
}

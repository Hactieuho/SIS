package test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class AppletTest extends JFrame{
	
	/**
	 * <h1>Constructor for Crawler class.</h1>
	 * - Set Title is "First application".<br>
	 * - Set Size is 300x300 px.
	 */
	public AppletTest(){
		//Set Title is "First application".
		setTitle("Tỷ giá ngoại tệ ngân hàng Vietcombank");
		
		//Set Size is 300x300 px.
		setSize(800, 600);
		
		/*
		   Add a Window Listener.
		   class WindowAdapter overrides class WindowClosing.
		 */
		addWindowListener(new WindowAdapter() {
			
		/**
		 * <h1>Call the exit event</h1>
		 * @param e unused
		 */
			@SuppressWarnings("unused")
			public void exit(WindowEvent e){
				ExitApp();
			}
		});
	}
	
	/**
	 * <h1>Exit the app</h1>
	 */
	public void ExitApp(){
		System.exit(0);
	}
	
	//Setup file menu
	{
		//Add a MenuBar has name is "menubar".
		JMenuBar menubar = new JMenuBar();
		
		//Add a Menu has name is "File"
		JMenu menu = new JMenu("File");
		
		//Add a MenuItem has name is "Exit".
		JMenuItem menuitem = new JMenuItem("Exit");
		
		//Add File's hot key is [Alt + F].
		menu.setMnemonic(KeyEvent.VK_F);
		
		//Add Exit's hot key is [Alt + X].
		menuitem.setMnemonic(KeyEvent.VK_X);
		
		//Add a exit event.
		menuitem.addActionListener(new ActionListener(){
			
			//Override the Exit event
			public void actionPerformed(ActionEvent e){
				ExitApp();
			}
		});
		
		//Add menu item "Exit" into menu "File".
		menu.add(menuitem);
		
		//Add menu "File" into menu bar.
		menubar.add(menu);
		
		//Add menu bar into app.
		setJMenuBar(menubar);
	}
	
	
	/**
	 * <h1>Main method</h1>
	 * Create a Crawler obj has name is "First"
	 * and show it on the screen.
	 * @param args Nothing
	 * @param first The only Crawler obj
	 */
	public static void main(String args[]){
		AppletTest first = new AppletTest();
		first.show();
	}
}
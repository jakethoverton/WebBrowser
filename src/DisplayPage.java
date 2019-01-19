/** 
* @author Jake Overton
* 1/18/2019
*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
*This class reads a URL and displays the content on that URL.
*/
public class DisplayPage extends JFrame{
	
	private JTextField addressBar;
	private JEditorPane display;
	
	//constuctor
	public DisplayPage(){
		super("WebBrowser");
		
		addressBar = new JTextField("Enter a URL!");
		addressBar.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent event){
					loadPage(event.getActionCommand());
				}
			}
		);
		add(addressBar, BorderLayout.NORTH);
		
		display = new JEditorPane();
		display.setEditable(false);
		display.addHyperlinkListener(
			new HyperlinkListener(){
				public void hyperlinkUpdate(HyperlinkEvent event){
					if(event.getEventType()== HyperlinkEvent.EventType.ACTIVATED){
						loadPage(event.getURL().toString());
					}
				}
			}
		);
		add(new JScrollPane(display), BorderLayout.CENTER);
		setSize(500,300);
		setVisible(true);
	}
	
	//loads the page that displays on the screen
	private void loadPage(String userInput){
		try{
			display.setPage(userInput);
			addressBar.setText(userInput);
		} catch (Exception e){
			System.out.println("Malformed URL");
		}
	}
	
}
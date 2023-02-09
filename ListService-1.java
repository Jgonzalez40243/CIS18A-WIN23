// Demonstrate a simple JList.

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class ListService implements ListSelectionListener {

  JList<String> jlst;
  JLabel jlab;
  JScrollPane jscrlp;

//Create an array of services. 
String services[] = { "Bath ONLY - $50.00 " , "Bath & Haircut - $90.00 ", "Haircut ONLY - $40.00 ",
                    "Nail Buffing - $10.00 ", "Teeth Brushing - $10.00 ", "Nail Buffing & Teeth Brushing - $20.00 ",
                     "Bare Package (everything included w/o medication) - $110.00 ", 
                      "Medicated care (Bare package + tick/flea medication) - $105.00",
                      "Deluxe package (Bare package + Oat soak & scented shampoo) - $130.00 ", };

ListService()  {
   // Create a new JFrame container.
   JFrame jfrm = new JFrame("Mobile Dog Spa");
    
   // Specify a flow Layout.
   jfrm.setLayout(new FlowLayout());

   // Give the frame an initial size.
   jfrm.setSize(600, 640);

   // Terminate the program when the user closes the application.
   jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   // Create a JList.
   jlst = new JList<String>(services);

   // Set the list selection mode to single-selection.
   jlst.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

   // Add list to a scroll pane.
   jscrlp = new JScrollPane(jlst);

   // Set the preferred size of the scroll pane.
   jscrlp.setPreferredSize(new Dimension(500, 240));

   // Make a label that displays the selection.
   jlab = new JLabel("Please choose a service");

   // Add list selection handler.
   jlst.addListSelectionListener(this);

   // Add the list and label to the content pane.
   jfrm.add(jscrlp);
   jfrm.add(jlab);

   // Display the frame.
   jfrm.setVisible(true);
 }

// Handle list selection events.
public void valueChanged(ListSelectionEvent le)  {
   // Get the index of the changed item.
   int idx = jlst.getSelectedIndex();

   // Display selection, if item was selected.
   if(idx != -1)
      jlab.setText("Current selection: " + services[idx]);
   else // Otherwise, reprompt.
     jlab.setText("Please choose a service");
}

public static void main(String args[])  {
  // Create the frame on the event dispatching thread.
  SwingUtilities.invokeLater(new Runnable() {
    public void run() {
      new ListService();
      }
    });
  }
}


































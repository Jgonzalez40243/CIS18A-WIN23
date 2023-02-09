import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class ListAppointment implements ListSelectionListener {

  JList<String> jlst;
  JLabel jlab;
  JScrollPane jscrlp;

//Create an array of appointments. 
String appointments[] = { "Monday (8A.M-10A.M)" , "Monday (11A.M-1P.M) ", "Tuesday (8A.M-10A.M) ",
                    "Tuesday (11A.M-1P.M)", "Wednesday (8A.M-10A.M)", "Wednesday (11A.M-1P.M)",
                     "Thursday (8A.M-10A.M)", "Thursday (11A.M-1P.M)" };

ListAppointment()  {
   // Create a new JFrame container.
   JFrame jfrm = new JFrame("Mobile Dog Spa appointments");
    
   // Specify a flow Layout.
   jfrm.setLayout(new FlowLayout());

   // Give the frame an initial size.
   jfrm.setSize(500, 540);

   // Terminate the program when the user closes the application.
   jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   // Create a JList.
   jlst = new JList<String>(appointments);

   // Set the list selection mode to single-selection.
   jlst.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

   // Add list to a scroll pane.
   jscrlp = new JScrollPane(jlst);

   // Set the preferred size of the scroll pane.
   jscrlp.setPreferredSize(new Dimension(400, 240));

   // Make a label that displays the selection.
   jlab = new JLabel("Please choose an appointment");

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
      jlab.setText("Current selection: " + appointments[idx]);
   else // Otherwise, reprompt.
     jlab.setText("Please choose a appointment");
}

public static void main(String args[])  {
  // Create the frame on the event dispatching thread.
  SwingUtilities.invokeLater(new Runnable() {
    public void run() {
      new ListAppointment();
      }
    });
  }
}
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.awt.*;
import java.io.IOException;
import java.util.List;


import javax.swing.*;

public class Jframe extends JFrame {

    /**
     * This title label.
     *
     * @since 1.0
     */
    private JLabel lblTitle;

    /**
     * Scroll pane to hold the JTable, so a scroll bar is shown when the data exceeds the visible size.
     *
     * @since 1.0
     */
    private JScrollPane scrollPane;
    /**
     * Self explanatory...
     */
    private JTable jTable;

    /**
     * Manages the layout of the application.
     *
     * @since 1.0
     */
    private SpringLayout layout;

    private static ObjectMapper mapper = new ObjectMapper();

    public Jframe(List<Character> personajes)
    {
        //SETUP JTABLE
        String [] columnNames = {"Nombre", "Altura", "Anio Nacimiento"};

        String [][] data = new String[personajes.size()][3];

        for (int i = 0; i < personajes.size(); i++){
            data[i][0] = personajes.get(i).getName();
            data[i][1] = personajes.get(i).getHeight();
            data[i][2] = personajes.get(i).getBirth_year();
        }

        this.jTable = new JTable(data, columnNames);

        this.scrollPane = new JScrollPane(this.jTable);

        //SETUP TITLE
        this.lblTitle = new JLabel("JTable Test");
        this.lblTitle.setFont(new Font("sansserif", Font.BOLD, 24));

        //SET THE LAYOUT MANAGER
        this.layout = new SpringLayout();
        this.getContentPane().setLayout(this.layout);

        //ADD ELEMENTS TO SCREEN
        this.add(this.lblTitle);
        this.add(this.scrollPane);

        //PLACE THE ELEMENTS
        this.layout.putConstraint(SpringLayout.NORTH, this.lblTitle, 10, SpringLayout.NORTH, this.getContentPane());
        this.layout.putConstraint(SpringLayout.WEST, this.lblTitle, 10, SpringLayout.WEST, this.getContentPane());

        this.layout.putConstraint(SpringLayout.NORTH, this.scrollPane, 50, SpringLayout.NORTH, this.getContentPane());
        this.layout.putConstraint(SpringLayout.WEST, this.scrollPane, 10, SpringLayout.WEST, this.getContentPane());
        this.layout.putConstraint(SpringLayout.EAST, this.scrollPane, -10, SpringLayout.EAST, this.getContentPane());
        this.layout.putConstraint(SpringLayout.SOUTH, this.scrollPane, -10, SpringLayout.SOUTH, this.getContentPane());

        //SETUP THE JFRAME
        this.setTitle("JTable Test");
        this.setSize(600, 400);
        this.setMinimumSize(new Dimension(400, 200));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }//

}

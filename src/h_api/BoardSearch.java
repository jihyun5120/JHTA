package h_api;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;



import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class BoardSearch extends JInternalFrame {
   private JPanel panel;
   private JButton btnNewButton;
   private JScrollPane scrollPane;
   private JTextArea textArea;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               BoardSearch frame = new BoardSearch();
               frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   /**
    * Create the frame.
    */
   public BoardSearch() {
      super("Board Search", true, true, true, true);
      setBounds(100, 100, 318, 281);
      getContentPane().add(getPanel(), BorderLayout.NORTH);
      getContentPane().add(getScrollPane(), BorderLayout.CENTER);
      setVisible(true);
   }

   private JPanel getPanel() {
      if (panel == null) {
         panel = new JPanel();
         panel.setPreferredSize(new Dimension(35, 35));
         panel.add(getBtnNewButton());
      }
      return panel;
   }

   private JButton getBtnNewButton() {
      if (btnNewButton == null) {
         btnNewButton = new JButton("\uC870\uD68C!");
         btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//            	Collections.sort(
//            			Arrays.asList(BoardMain.data), new BoardComparator());
//            	
//            	textArea.setText("");
//            	for(int i=0; i<BoardMain.count; i++) {
//            		textArea.append(BoardMain.data[i].toString());
//            	}
            	
            	
            	
            	
            	
               // 3.BoardSearch.java(IntervalFrame)
               // -배열에 저장된 내용을 작성일순으로 내림차순 정렬하여 표시
               // BoardComparator


               BoardVo temp;
               int result = 0;

               for (int i = 0; i < BoardMain.count - 1; i++) {
                  for (int j = i + 1; j < BoardMain.count; j++) {

                     BoardVo o1 = BoardMain.data[i];
                     BoardVo o2 = BoardMain.data[j];

                     result = Objects.compare(o1, o2, new BoardComparator());

                     if (result > 0) {

                        temp = BoardMain.data[i];

                        BoardMain.data[i] = BoardMain.data[j];
                        BoardMain.data[j] = temp;

                     }

                  }

               } // For문의 끝

               textArea.setText("");
               for (int i = 0; i < BoardMain.count; i++) {

                  textArea.append(BoardMain.data[i] + "\n");

               }

            }

         });
      }
      return btnNewButton;
   }

   private JScrollPane getScrollPane() {
      if (scrollPane == null) {
         scrollPane = new JScrollPane();
         scrollPane.setViewportView(getTextArea());
      }
      return scrollPane;
   }

   private JTextArea getTextArea() {
      if (textArea == null) {
         textArea = new JTextArea();
      }
      return textArea;
   }
}
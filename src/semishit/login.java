package semishit;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class login extends JInternalFrame {
  public static String idck;
	private JLabel lblLogin;
   private JTextField textField;
   private JButton button;
   private JPasswordField passwordField;
   private JSeparator separator;
   private JButton button_1;
   private JButton button_2;
   private JButton button_3;

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               login frame = new login(); 
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
   public login() {
      super("login",true,false,true,true);
      getContentPane().setBackground(Color.WHITE);
      setVisible(true);
      setBounds(400, 200, 481, 355);
      getContentPane().setLayout(null);
      getContentPane().add(getLblLogin());
      getContentPane().add(getTextField());
      getContentPane().add(getButton());
      getContentPane().add(getPasswordField());
      getContentPane().add(getSeparator());
      getContentPane().add(getButton_1());
      getContentPane().add(getButton_2());
      getContentPane().add(getButton_3());

   }

   private JLabel getLblLogin() {
      if (lblLogin == null) {
         lblLogin = new JLabel("Login");
         lblLogin.setFont(new Font("12롯데마트행복Medium", Font.PLAIN, 30));
         lblLogin.setBounds(42, 25, 106, 34);
      }
      return lblLogin;
   }
   private JTextField getTextField() {
      if (textField == null) {
         textField = new JTextField();
         textField.addFocusListener(new FocusAdapter() {
         	@Override
         	public void focusGained(FocusEvent arg0) {
         		textField.setText("");
         	}
         });
         textField.setFont(new Font("12롯데마트드림Bold", Font.PLAIN, 14));
         textField.setText("\uC544\uC774\uB514");
         textField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
         textField.setColumns(10);
         textField.setBounds(64, 105, 241, 21);
      }
      return textField;
   }
   private JButton getButton() {
      if (button == null) {
         button = new JButton("LOGIN");
         button.setForeground(Color.WHITE);
         button.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 12));
         button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {//로그인성공
               joinDao dao = new joinDao();
               String id = textField.getText();
               String pw =passwordField.getText();
               idck=id; 
               SemiMain sm = new SemiMain();
               
               int r = dao.login(id, pw);
               
                   if(r == -1) {
                      
                   JOptionPane.showMessageDialog(login.this, "로그인 실패!");
                    
                      
                   }else if ( r == 0){
                
                        
                	   
                        JOptionPane.showMessageDialog(login.this, "로그인  성공");
                        sm.welcome = id;
                        sm.btnNewButton.doClick();
                     
                        dispose();
                        
                         
                        
                   }else {
                      
                      
                         JOptionPane.showMessageDialog(login.this, "아이디와 비밀번호가 일치하지 않습니다.!");
                         
                   }
               
            }
         });
         button.setBackground(Color.GRAY);
         button.setBounds(253, 244, 97, 23);
      }
      return button;
   }
   private JPasswordField getPasswordField() {
      if (passwordField == null) {
         passwordField = new JPasswordField();
         passwordField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
         passwordField.setBounds(64, 164, 241, 21);
      }
      return passwordField;
   }
   private JSeparator getSeparator() {
      if (separator == null) {
         separator = new JSeparator();
         separator.setBounds(12, 277, 438, 7);
      }
      return separator;
   }
   private JButton getButton_1() {
      if (button_1 == null) {
         button_1 = new JButton("\uD68C\uC6D0\uAC00\uC785");
         button_1.setBackground(Color.GRAY);
         button_1.setForeground(Color.WHITE);
         button_1.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 12));
         button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {//회원가입
               
                joinMem mm = new joinMem();
                   mm.show();
            
            }
         });
         button_1.setBounds(353, 244, 97, 23);
      }
      return button_1;
   }
   private JButton getButton_2() {
      if (button_2 == null) {
         button_2 = new JButton("\uC544\uC774\uB514 \uCC3E\uAE30");
         button_2.setBackground(Color.GRAY);
         button_2.setForeground(Color.WHITE);
         button_2.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 12));
         button_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {// 아이디찾기
               FindID mm = new FindID();
               mm.show();
               
            }
         });
         button_2.setBounds(213, 294, 106, 23);
      }
      return button_2;
   }
   private JButton getButton_3() {
      if (button_3 == null) {
         button_3 = new JButton("\uBE44\uBC00\uBC88\uD638 \uCC3E\uAE30");
         button_3.setBackground(Color.GRAY);
         button_3.setForeground(Color.WHITE);
         button_3.setFont(new Font("12롯데마트드림Light", Font.PLAIN, 12));
         button_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {//비밀번호찾기
               FindPwd mm  = new FindPwd();
               mm.show();
               
            }
         });
         button_3.setBounds(323, 294, 120, 23);
      }
      return button_3;
   }
}
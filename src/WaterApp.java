import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WaterApp extends JFrame implements ActionListener{
    private JLabel labelQuestion;
    private JLabel labelWeight;
    private JTextField fileWeight;
    private JButton buttonTellMe;

    public WaterApp() {
        super("Water Calculate"); // กำหนดtitle Jframe ที่extends

        initComponents();

        setSize(240, 150); // กำหนดกว้าง*สูง(px)
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // เมื่อกดกากบาทให้exit Jframe
    }

    private void initComponents() {
        labelQuestion = new JLabel("How much water u should drink?");

        labelWeight = new JLabel("Enter your weight in kg.");
        fileWeight = new JTextField(5); // ใส่ตัวเลขได้ 5 ตัวอักษร
        buttonTellMe = new JButton("Tell ME!");

        setLayout(new FlowLayout());// วางต่อๆกัน เมื่อกรอบกว้างขึ้นก็จะเรียงยาว

        add(labelQuestion);
        add(labelWeight);
        add(fileWeight);
        add(buttonTellMe);

        buttonTellMe.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String message = "Hey! ,u should drink %.1f L" + "of water a day"; //อย่าลืมการแสดงค่า %.f ==> %.1f
        float weight = Float.parseFloat(fileWeight.getText());
        float waterAmount = calWaterAmout(weight);
        message = String.format(message, waterAmount);

        JOptionPane.showMessageDialog(this, message);
    }

    private float calWaterAmout(float weight){
        return (weight / 10f) * 0.4f; //f เพื่อบอกว่าเป็น float
    }
}

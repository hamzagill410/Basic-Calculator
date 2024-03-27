import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class CalculatorMain implements ActionListener {

    JFrame frame;
    JTextField textField;
    JButton[] calcnumButtons = new JButton[10];
    JButton[] calcfuncButtons = new JButton[9];
    JButton plusButton,minusButton,prodButton,quotButton;
    JButton clearButton,delButton,decValButton,evalButton,sqrtButton;
    JPanel buttonPanel;//panel to hold buttons

    Font buttonFont = new Font("Arial",Font.ITALIC,30);

    double val1=0, val2 =0 ,solution=0;
    char calcOperator;
    CalculatorMain(){
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(550,550);
        frame.setLayout(null);
        textField = new JTextField();
        textField.setBounds(50,25,300,40);
        textField.setFont(buttonFont);
        //Creating buttons
        delButton = new JButton("Del");
        decValButton = new JButton(".");
        clearButton = new JButton("CLR");
        evalButton = new JButton("=");
        sqrtButton = new JButton("√");
        quotButton = new JButton("÷");
        prodButton = new JButton("x");
        minusButton = new JButton("-");
        plusButton = new JButton("+");
        //Adding buttons in their respective positions
        for(int x = 0;x<10;x++){
            calcnumButtons[x] = new JButton(String.valueOf(x));
            calcnumButtons[x].addActionListener(this);
            calcnumButtons[x].setFont(buttonFont);

        }
        //Adding functional buttons
        calcfuncButtons[0] = prodButton;
        calcfuncButtons[1] = quotButton;
        calcfuncButtons[2] = plusButton;
        calcfuncButtons[3] = minusButton;
        calcfuncButtons[4] = sqrtButton;
        calcfuncButtons[5] = decValButton;
        calcfuncButtons[6] = delButton;
        calcfuncButtons[7] = decValButton;
        calcfuncButtons[8] = evalButton;
        for(int i = 0;i<9;i++){
            calcfuncButtons[i].addActionListener(this);
            calcfuncButtons[i].setFont(buttonFont);

        }
        clearButton.setBounds(50,430,145,50);
        delButton.setBounds(205,430,145,50);
//        calcnumButtons[0] = new JButton(String.valueOf(0));
        buttonPanel = new JPanel();
        buttonPanel.setBounds(50,100,300,300);
        buttonPanel.setLayout(new GridLayout(5,5,10,10));

//        frame.getColorModel();//work on it
        buttonPanel.add(calcnumButtons[7]);
        buttonPanel.add(calcnumButtons[8]);
        buttonPanel.add(calcnumButtons[9]);
        buttonPanel.add(prodButton);
        buttonPanel.add(calcnumButtons[4]);
        buttonPanel.add(calcnumButtons[5]);
        buttonPanel.add(calcnumButtons[6]);
        buttonPanel.add(quotButton);
        buttonPanel.add(calcnumButtons[1]);
        buttonPanel.add(calcnumButtons[2]);
        buttonPanel.add(calcnumButtons[3]);
        buttonPanel.add(plusButton);
        buttonPanel.add(calcnumButtons[0]);
        buttonPanel.add(decValButton);
        buttonPanel.add(evalButton);
        buttonPanel.add(minusButton);
        buttonPanel.add(sqrtButton);
        frame.add(buttonPanel);
        frame.add(textField);
        frame.add(clearButton);
        frame.add(delButton);
        frame.setVisible(true);
        textField.setEditable(false);


    }
    public static void main(String[] args){

        CalculatorMain calculatorMain = new CalculatorMain();


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0;i <10;i++){
            if(e.getSource() == calcnumButtons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        //for Decimal button functionality
        if(e.getSource() == decValButton){
            textField.setText(textField.getText().concat("."));
        }
        if(e.getSource() == minusButton){
            val1 = Double.parseDouble(textField.getText());
            calcOperator = '-';
            textField.setText(null);
        }
        if(e.getSource() == plusButton){
            val1 = Double.parseDouble(textField.getText());
            calcOperator = '+';
            textField.setText(null);
        }
//        if (e.getSource() == plusButton) {
//            textField.setText("");
//        }
        if(e.getSource()==prodButton){
            val1 = Double.parseDouble(textField.getText());

            calcOperator = 'x';
            textField.setText(null);
        }
//        if(e.getSource() == prodButton){
//            textField.setText("");
//        }
        if(e.getSource() == quotButton){
            val1 = Double.parseDouble(textField.getText());

            calcOperator = '÷';
            textField.setText(null);
        }
//        if(e.getSource() == quotButton){
//            textField.setText("");
//        }
        if(e.getSource() == sqrtButton){
            val1 = Double.parseDouble(textField.getText());
            calcOperator = '√';
            textField.setText(null);
        }
        if(e.getSource()==evalButton){
            val2 = Double.parseDouble(textField.getText());
            if(calcOperator == 'x'){
                solution = val1 * val2;
            } else if (calcOperator == '÷') {
                solution = val1 / val2;

            } else if (calcOperator == '+') {
                solution = val1 + val2;

            } else if (calcOperator == '-') {
                solution = val1 - val2;

            } else if (calcOperator == '√') {
                solution = Math.sqrt(val1);
            }
            textField.setText(String.valueOf(solution));
            val1 = solution;
        }
        clearButton.addActionListener(this);
        if (e.getSource() == clearButton){
            textField.setText(null);
        }
        if(e.getSource() == delButton){
            String currentNum = textField.getText();
            if(!currentNum.isEmpty()){//will help removing the last number
                textField.setText(currentNum.substring(0,currentNum.length()-1));
            }

        }


        }

    }



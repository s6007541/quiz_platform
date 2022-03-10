import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class Quiz implements ActionListener {
    JFrame f = new JFrame();
    JPanel choice_panel = new JPanel();
    JPanel screen_panel = new JPanel();
    JButton choices[] = new JButton[4];
    JButton control_buttons[] = new JButton[3];
    JLabel question = new JLabel();

    int current_q;

    Question q1 = new Question("What's the Closest Planet to Earth?", "Venus", "Mars", "Mercury","Jupiter",1,0,false);
    Question q2 = new Question("What is the largest country on earth?", "Canada", "United State", "Russia","China",2,2,false);
    Question q3 = new Question("How many people is “two pairs of twins twice?", "2", "4", "6","8",3,3,false);
    Question q4 = new Question("What are the secondary colors of light?", "yellow", "cyan", "magenta","orange",4,3,false);
    Question q5 = new Question("Which countries have won the 2nd most World Cups?", "Italy", "Brazil", "France","Argentina",5,0,false);

    Quiz(){
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(1000,1000);
        f.getContentPane().setBackground(new Color(50,50,50));
        f.setLayout(new BorderLayout());
        f.setVisible(true);

        question.setBackground(new Color(25,25,25));
        question.setForeground(new Color(25,255,0));
        question.setFont(new Font("Ink free",Font.BOLD,100));
        question.setHorizontalAlignment(JLabel.CENTER);
        question.setText("Quiz time!!");
        question.setOpaque(true);


        for(int i = 0; i < 4; i++){
            choices[i] = new JButton();
            choice_panel.add(choices[i]);
            choices[i].setFont(new Font("Ink free", Font.BOLD, 50));
            choices[i].setFocusable(false);
            choices[i].addActionListener(this);
        }

        for(int i = 0; i < 3; i++){
            control_buttons[i] = new JButton();
            control_buttons[i].setFont(new Font("Ink free", Font.BOLD, 50));
            control_buttons[i].setFocusable(false);
            control_buttons[i].addActionListener(this);
        }       
        control_buttons[0].setText("Next");
        control_buttons[1].setText("Hint");
        control_buttons[2].setText("Previous");

        screen_panel.setLayout(new BorderLayout());
        choice_panel.setLayout(new GridLayout(4,1));
        choice_panel.setBackground(new Color(150,150,150));

        screen_panel.add(question,"North");
        screen_panel.add(control_buttons[0], "East");
        screen_panel.add(control_buttons[1], "Center");
        screen_panel.add(control_buttons[2], "West");

        f.add(screen_panel, "North");
        f.add(choice_panel);

        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println(e);
        }

        question.setFont(new Font("Ink free",Font.BOLD,50));
        question.setText(q1.question);
        choices[0].setText("A. " + q1.choiceA);
        choices[1].setText("B. " + q1.choiceB);
        choices[2].setText("C. " + q1.choiceC);
        choices[3].setText("D. " + q1.choiceD);

        current_q = 1;
        


    }   

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == control_buttons[0] && current_q != 5){
            current_q++;
            if(current_q == 2) move(q2);
            if(current_q == 3) move(q3);
            if(current_q == 4) move(q4);
            if(current_q == 5) move(q5);
            for(int i = 0; i < 4; i++){
                choices[i].setForeground(new Color(0,0,0));
            }
            
        }
        else if(current_q == 1 && q1.answered == false){
            if(e.getSource() == choices[q1.correct]){
                choices[q1.correct].setText(choices[q1.correct].getText() + " correct :)");
                choices[q1.correct].setForeground(new Color(0,150,0));
            }
            else{
                for(int i =0; i < 4; i++){
                    if(e.getSource() == choices[i]){
                        choices[q1.correct].setForeground(new Color(0,150,0));
                        choices[i].setForeground(new Color(150,0,0));
                        choices[i].setText(choices[i].getText() + " Wrong :(");
                    }
                }
            }
            q1.answered = true;
        }
        else if(current_q == 2 && q2.answered == false){
            if(e.getSource() == choices[q2.correct]){
                choices[q2.correct].setText(choices[q2.correct].getText() + " correct :)");
                choices[q2.correct].setForeground(new Color(0,150,0));
            }
            else{
                for(int i =0; i < 4; i++){
                    if(e.getSource() == choices[i]){
                        choices[q2.correct].setForeground(new Color(0,150,0));
                        choices[i].setForeground(new Color(150,0,0));
                        choices[i].setText(choices[i].getText() + " Wrong :(");
                    }
                }
            }
            q2.answered = true;
        }
        else if(current_q == 3 && q3.answered == false){
            if(e.getSource() == choices[q3.correct]){
                choices[q3.correct].setText(choices[q3.correct].getText() + " correct :)");
                choices[q3.correct].setForeground(new Color(0,150,0));
            }
            else{
                for(int i =0; i < 4; i++){
                    if(e.getSource() == choices[i]){
                        choices[q3.correct].setForeground(new Color(0,150,0));
                        choices[i].setForeground(new Color(150,0,0));
                        choices[i].setText(choices[i].getText() + " Wrong :(");
                    }
                }
            }
            q3.answered = true;
        }
        else if(current_q == 4 && q4.answered == false){
            if(e.getSource() == choices[q4.correct]){
                choices[q4.correct].setText(choices[q4.correct].getText() + " correct :)");
                choices[q4.correct].setForeground(new Color(0,150,0));
            }
            else{
                for(int i =0; i < 4; i++){
                    if(e.getSource() == choices[i]){
                        choices[q4.correct].setForeground(new Color(0,150,0));
                        choices[i].setForeground(new Color(150,0,0));
                        choices[i].setText(choices[i].getText() + " Wrong :(");
                    }
                }
            }
            q4.answered = true;
        }
        else if(current_q == 5 && q5.answered == false){
            if(e.getSource() == choices[q5.correct]){
                choices[q5.correct].setText(choices[q5.correct].getText() + " correct :)");
                choices[q5.correct].setForeground(new Color(0,150,0));
            }
            else{
                for(int i =0; i < 4; i++){
                    if(e.getSource() == choices[i]){
                        choices[q5.correct].setForeground(new Color(0,150,0));
                        choices[i].setForeground(new Color(150,0,0));
                        choices[i].setText(choices[i].getText() + " Wrong :(");
                    }
                }
            }
            q5.answered = true;
        }
    }

    public void move(Question q){
        question.setText(q.question);
        choices[0].setText("A. " + q.choiceA);
        choices[1].setText("B. " + q.choiceB);
        choices[2].setText("C. " + q.choiceC);
        choices[3].setText("D. " + q.choiceD);
    }




}
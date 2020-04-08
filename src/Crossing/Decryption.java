package Crossing;

import java.awt.GridLayout;            
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class Decryption extends JPanel implements ActionListener{       // ��ȣȭ Ŭ����
	StringBuffer code1 = new StringBuffer();
	StringBuffer code2 = new StringBuffer();
	StringBuffer key1 = new StringBuffer();
	StringBuffer key2 = new StringBuffer();
	char[][] snail = new char[16][8];
	JTextField t1[];
	JLabel l1[];
	JPanel p1;
	JButton b1;
	JButton b2;
	
	public Decryption() {
		p1 = new JPanel();
		t1 = new JTextField[3];
		l1 = new JLabel[3];
		p1.setLayout(new GridLayout(0,2));
		for(int i=0; i<3; i++) {
			l1[i] = new JLabel();
			t1[i] = new JTextField();
			p1.add(l1[i]);
			p1.add(t1[i]);
			
		}
		l1[0].setText("��ȣ�� �Է�");
		l1[1].setText("Ű �Է�");
		l1[2].setText("��");
		b1 = new JButton("��ȣȭ");
		p1.add(b1);
		b1.addActionListener(this);		
		
	}
	public void SnailArray(int num) {            // ������ �迭 ġȯ
		int x = 8;
		int y = 16;
		char c = 0;
		int i;
		int j;
		int cnt = 0;
		if(num == 0) {
			i = 0;
			j = 0;		
		while(c <128) {                    // ȸ�� 0

			for(; j< x; j++) {
				snail[i][j] = change(c);
				c++;
			}
			i++;
			j--;
			for(; i<y; i++) {
				snail[i][j] = change(c);
				c++;
			}
			i--;
			j--;
			for(; j>=cnt; j--) {
				snail[i][j] = change(c);
				c++;
			}
			j++;
			i--;
			cnt++;
			for(; i>=cnt; i--) {
				snail[i][j] = change(c);
				c++;
			}		
			i++;
			j++;
			x--;
			y--;
		}
		
	}
		else if(num == 1) {                   // ȸ�� 1
			i = 0;
			j = 7;
			while(c <128) {
				for(; i< y; i++) {
					snail[i][j] = change(c);
					c++;
				}
				i--;
				j--;
				for(; j>=cnt; j--) {
					snail[i][j] = change(c);
					c++;
				}
				j++;
				i--;
				for(; i>=cnt; i--) {
					snail[i][j] = change(c);
					c++;
				}
				i++;
				j++;
				x--;
				y--;
				for(; j<x; j++) {
					snail[i][j] = change(c);
					c++;
				}
				j--;
				i++;
				cnt++;
			}
			
		}
		else if(num == 2) {                  // ȸ�� 2
			i = 15;
			j = 7;
			while(c <128) {
				for(; j>=cnt; j--) {
					snail[i][j] = change(c);
					c++;
				}
				j++;
				i--;
				for(; i>=cnt; i--) {
					snail[i][j] = change(c);
					c++;
				}
				i++;
				j++;
				for(; j< x; j++) {
					snail[i][j] = change(c);
					c++;
				}
				j--;
				i++;
				x--;
				y--;
				for(; i<y; i++) {
					snail[i][j] = change(c);
					c++;
				}
				i--;
				j--;
				cnt++;
			}	
		}
		else if(num == 3) {                      // ȸ�� 3
			i = 15;
			j = 0;
			while(c <128) {
				for(; i>= cnt; i--) {
					snail[i][j] = change(c);
					c++;
				}
				i++;
				j++;
				for(; j<x; j++) {
					snail[i][j] = change(c);
					c++;
				}
				j--;
				i++;
				for(; i<y; i++) {
					snail[i][j] = change(c);
					c++;
				}
				i--;
				j--;
				cnt++;
				for(; j>= cnt; j--) {
					snail[i][j] = change(c);
					c++;
				}
				j++;
				i--;
				x--;
				y--;
			}
		}
	}
	
    public void first (String word, String key) {         // �ʱ�ܰ�, �� ����, Ű ����
	    int index = word.length()/2;
	    if(code1.length() >= 1) 
	        code1.delete(0, code1.length());
	    if(code2.length() >= 1)
	        code2.delete(0, code2.length());
	    if(key1.length() >= 1)
	        key1.delete(0, key1.length());
	    if(key2.length() >= 1)
	        key2.delete(0, key2.length());
	
	    if(((key.length() % 2) == 0) && ((word.length() % 2) == 1)) {
	    	code1.append(word.substring(0, index+1));
		    code2.append(word.substring(index+1, word.length()));
	    }
	    else {
	        code1.append(word.substring(0, index));
	        code2.append(word.substring(index, word.length()));
	    }	    
	    key1.append(key);    
	    key2.append(key);
	    key2.reverse();
	    
	    for(int i=0; i<key1.length()-1; i++) {
	        key1.append(key1.charAt(0));
    	    key1.deleteCharAt(0);
    	    key2.append(key2.charAt(0));
    	    key2.deleteCharAt(0);
	    }
	}
    
    public char change(char c) {               // ����� ġȯ
    	if(0==c) c = '��'; else if(1==c) c = '��'; else if(2==c) c = '��'; else if(3==c) c = '��';
    	else if(4==c) c = '��'; else if(5==c) c = '��'; else if(6==c) c = '��'; else if(7==c) c = '��';
    	else if(8==c) c = '��'; else if(9==c) c = '��'; else if(10==c) c = 'ī'; else if(11==c) c = 'Ÿ'; 
    	else if(12==c) c = '��'; else if(13==c) c = '��'; else if(14==c) c = '��'; else if(15==c) c = '��'; 
    	else if(16==c) c = '��'; else if(17==c) c = '��'; else if(18==c) c = '��'; else if(19==c) c = '��'; 
    	else if(20==c) c = '��'; else if(21==c) c = '��'; else if(22==c) c = '��'; else if(23==c) c = 'ó'; 
    	else if(24==c) c = 'Ŀ'; else if(25==c) c = '��'; else if(26==c) c = '��'; else if(27==c) c = '��'; 
    	else if(28==c) c = '��'; else if(29==c) c = '��'; else if(30==c) c = '��'; else if(31==c) c = '��'; 
    	else if(127==c) c = '��'; 
    	return c;
    }
    
    public char change2(char c) {                 // ����� ��ġȯ
    	if('��'==c) c = 0; else if('��'==c) c = 1; else if('��'==c) c = 2; else if('��'==c) c = 3;
    	else if('��'==c) c = 4; else if('��'==c) c = 5; else if('��'==c) c = 6; else if('��'==c) c = 7;
    	else if('��'==c) c = 8; else if('��'==c) c = 9; else if('ī'==c) c = 10; else if('Ÿ'==c) c = 11; 
    	else if('��'==c) c = 12; else if('��'==c) c = 13; else if('��'==c) c = 14; else if('��'==c) c = 15; 
    	else if('��'==c) c = 16; else if('��'==c) c = 17; else if('��'==c) c = 18; else if('��'==c) c = 19; 
    	else if('��'==c) c = 20; else if('��'==c) c = 21; else if('��'==c) c = 22; else if('ó'==c) c = 23; 
    	else if('Ŀ'==c) c = 24; else if('��'==c) c = 25; else if('��'==c) c = 26; else if('��'==c) c = 27; 
    	else if('��'==c) c = 28; else if('��'==c) c = 29; else if('��'==c) c = 30; else if('��'==c) c = 31; 
    	else if('��'==c) c = 127; 
    	return c;
    }
    
    public void Preposition() {             // �� ��ġ
    	key1.insert(0, key1.charAt(key1.length()-1));
    	key1.deleteCharAt(key1.length()-1);
    	key2.insert(0, key2.charAt(key2.length()-1));
    	key2.deleteCharAt(key2.length()-1);
    	
    }
    
    public void XOR() {                   // XOR ����
    	StringBuffer result = new StringBuffer();
    	StringBuffer temp = new StringBuffer();
    	int num = key1.length() - 1;
    	SnailArray(num % 4);
    	for(int m=0; m<key1.length(); m++) {	  // �迭 ��ȸ�� �� ����ġ   		
    		if(m>=1) {
    			num--;	
    			SnailArray(num % 4);    				
    			Preposition();
    			temp.append(code1);
    			code1.delete(0, code1.length());
    			code1.append(code2);
    			code2.delete(0, code2.length());
    			code2.append(temp);
    			temp.delete(0, temp.length());
    		}	
    	for(int i=0,j=0; i < code1.length(); i++,j++) {       // XOR ����
    		if(j == key2.length())
    			j = 0;
    		char c = (char) (change2(code1.charAt(i)) ^ key2.charAt(j));
    		c = change(c);
    		code1.setCharAt(i, c);	
    	}
    	for(int i=0,j=0; i < code2.length(); i++,j++) {         // XOR ����
    		if(j == key1.length())
    			j = 0;
    		char c = (char)(change2(code2.charAt(i)) ^ key1.charAt(j));
    		c = change(c);
    		code2.setCharAt(i, c);	
    	}
    	int index;
    	for(int i=0; i<code2.length(); i++) {            // ������ �迭 ��ġȯ
    		index = 0;
    		char ask = code2.charAt(i);
    		for(int j=0; j<16; j++) {
    			for(int k=0; k<8; k++) {
    				if(ask == snail[j][k]) {
    					char c = (char)change((char)index);
    					code2.setCharAt(i, c);
    				}
    				index++;
    			}
    		}
    	}
    	}   
        result.append(code1);                // ��ȣ�� �ΰ��� �ٿ��� ������ ����
        result.append(code2);
    	t1[2].setText(result.toString());
    }
    
    public void actionPerformed(ActionEvent e) {
    	if(e.getSource() == b1) {
    		first(t1[0].getText(), t1[1].getText());
    		XOR(); 		
    	}
    	else {
    		
    	}
    }
}
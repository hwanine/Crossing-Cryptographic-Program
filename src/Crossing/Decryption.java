package Crossing;

import java.awt.GridLayout;            
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

class Decryption extends JPanel implements ActionListener{       // 복호화 클래스
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
		l1[0].setText("암호문 입력");
		l1[1].setText("키 입력");
		l1[2].setText("평문");
		b1 = new JButton("복호화");
		p1.add(b1);
		b1.addActionListener(this);		
		
	}
	public void SnailArray(int num) {            // 달팽이 배열 치환
		int x = 8;
		int y = 16;
		char c = 0;
		int i;
		int j;
		int cnt = 0;
		if(num == 0) {
			i = 0;
			j = 0;		
		while(c <128) {                    // 회전 0

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
		else if(num == 1) {                   // 회전 1
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
		else if(num == 2) {                  // 회전 2
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
		else if(num == 3) {                      // 회전 3
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
	
    public void first (String word, String key) {         // 초기단계, 평문 나눔, 키 설정
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
    
    public char change(char c) {               // 제어문자 치환
    	if(0==c) c = '가'; else if(1==c) c = '나'; else if(2==c) c = '다'; else if(3==c) c = '라';
    	else if(4==c) c = '마'; else if(5==c) c = '바'; else if(6==c) c = '사'; else if(7==c) c = '아';
    	else if(8==c) c = '자'; else if(9==c) c = '차'; else if(10==c) c = '카'; else if(11==c) c = '타'; 
    	else if(12==c) c = '파'; else if(13==c) c = '하'; else if(14==c) c = '거'; else if(15==c) c = '너'; 
    	else if(16==c) c = '더'; else if(17==c) c = '러'; else if(18==c) c = '머'; else if(19==c) c = '버'; 
    	else if(20==c) c = '서'; else if(21==c) c = '어'; else if(22==c) c = '저'; else if(23==c) c = '처'; 
    	else if(24==c) c = '커'; else if(25==c) c = '터'; else if(26==c) c = '퍼'; else if(27==c) c = '허'; 
    	else if(28==c) c = '고'; else if(29==c) c = '노'; else if(30==c) c = '도'; else if(31==c) c = '로'; 
    	else if(127==c) c = '모'; 
    	return c;
    }
    
    public char change2(char c) {                 // 제어문자 역치환
    	if('가'==c) c = 0; else if('나'==c) c = 1; else if('다'==c) c = 2; else if('라'==c) c = 3;
    	else if('마'==c) c = 4; else if('바'==c) c = 5; else if('사'==c) c = 6; else if('아'==c) c = 7;
    	else if('자'==c) c = 8; else if('차'==c) c = 9; else if('카'==c) c = 10; else if('타'==c) c = 11; 
    	else if('파'==c) c = 12; else if('하'==c) c = 13; else if('거'==c) c = 14; else if('너'==c) c = 15; 
    	else if('더'==c) c = 16; else if('러'==c) c = 17; else if('머'==c) c = 18; else if('버'==c) c = 19; 
    	else if('서'==c) c = 20; else if('어'==c) c = 21; else if('저'==c) c = 22; else if('처'==c) c = 23; 
    	else if('커'==c) c = 24; else if('터'==c) c = 25; else if('퍼'==c) c = 26; else if('허'==c) c = 27; 
    	else if('고'==c) c = 28; else if('노'==c) c = 29; else if('도'==c) c = 30; else if('로'==c) c = 31; 
    	else if('모'==c) c = 127; 
    	return c;
    }
    
    public void Preposition() {             // 역 전치
    	key1.insert(0, key1.charAt(key1.length()-1));
    	key1.deleteCharAt(key1.length()-1);
    	key2.insert(0, key2.charAt(key2.length()-1));
    	key2.deleteCharAt(key2.length()-1);
    	
    }
    
    public void XOR() {                   // XOR 과정
    	StringBuffer result = new StringBuffer();
    	StringBuffer temp = new StringBuffer();
    	int num = key1.length() - 1;
    	SnailArray(num % 4);
    	for(int m=0; m<key1.length(); m++) {	  // 배열 역회전 및 역전치   		
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
    	for(int i=0,j=0; i < code1.length(); i++,j++) {       // XOR 연산
    		if(j == key2.length())
    			j = 0;
    		char c = (char) (change2(code1.charAt(i)) ^ key2.charAt(j));
    		c = change(c);
    		code1.setCharAt(i, c);	
    	}
    	for(int i=0,j=0; i < code2.length(); i++,j++) {         // XOR 연산
    		if(j == key1.length())
    			j = 0;
    		char c = (char)(change2(code2.charAt(i)) ^ key1.charAt(j));
    		c = change(c);
    		code2.setCharAt(i, c);	
    	}
    	int index;
    	for(int i=0; i<code2.length(); i++) {            // 달팽이 배열 역치환
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
        result.append(code1);                // 복호문 두개를 붙여서 최종평문 생성
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
package application;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class BruteforceController implements Initializable{
	
	 @FXML
	    private TextField len;
	 @FXML
	 	private HBox parentBox;
	 @FXML
	 	private AnchorPane anchor;
	@FXML 
		private HBox hbox2;
	private TextField filename = new TextField(); 
	static private boolean okey;
	
	 public void test(){
		 
		 len.setText("hi");
	 }
	 
	 public void generateInput(){
		 
	    System.out.println("Here!");
	    

	 }
	 
	 private TextField val[] = new TextField[10];
	 private RadioButton c[] = new RadioButton[10];
	 private RadioButton n[] = new RadioButton[10];
	 private RadioButton s[] = new RadioButton[10];
	 
	 final ToggleGroup group[] = new ToggleGroup[10];
	//static final private PrintWriter out = new PrintWriter();
	 
	 void codewrite(String code){
		 try(FileWriter fw = new FileWriter(filename.getText(), true);
				    BufferedWriter bw = new BufferedWriter(fw);
				    PrintWriter out = new PrintWriter(bw))
				{
				    out.println(code);
				    
				    
				} catch (IOException e) {
				    //exception handling left as an exercise for the reader
				}
			
	 }
	 void generate(int pos, char[][] c, String code) {
		 
		    if (pos == Integer.parseInt(len.getText())) {
		        
		        
		        	 System.out.println(code);
		             codewrite(code);   
		         return;
		    }
		    for (int i = 0 ; i != c[pos].length ; i++) {
		        generate(pos+1, c, code + c[pos][i]);
		    }
		 
		}
	 
	 @FXML
	    private void onInput(ActionEvent event) throws IOException {
	        int l= Integer.parseInt(len.getText()) ;
	        System.out.println(l);
	        
	       // generateInput();
	        
	        
	        for (int i=0; i<l; i=i+1){
	        	
	        	//private TextField[] val= new TextField;
	           	val[i] = new TextField();
	        	
	           	group[i] = new ToggleGroup();
	           	
	           	
	        	
	           	
	           	c[i] = new RadioButton("c");
	           	c[i].setUserData("c");
	        	c[i].setToggleGroup(group[i]);
	        	c[i].setSelected(true);

	        	n[i] = new RadioButton("n");
	        	n[i].setUserData("n");
	        	n[i].setToggleGroup(group[i]);
	        	 
	        	s[i] = new RadioButton("s");
	        	s[i].setUserData("s");
	        	s[i].setToggleGroup(group[i]);
	        	
	            VBox v1= new VBox();
	            v1.getChildren().addAll(val[i],c[i],n[i],s[i]);
	            parentBox.getChildren().add(v1);
	            
	           
	        } 
	        
	        
	        filename.setPromptText("FileName");
	        Button gen = new Button("Generate");
	        hbox2.getChildren().addAll(filename,gen);
	        
	        gen.setOnAction(new EventHandler<ActionEvent>() {
	            @Override public void handle(ActionEvent e) {
	                System.out.println("action");
	                
	                char[][] data= new char[l][];
	                String[] str = new String[9];
	    	        for (int i=0; i<l; i++){
	    	        	//System.out.println(val[i].getText());
	    	        	//System.out.println(group[i].getSelectedToggle().getUserData().toString());
	    	        	
	    	        	if(group[i].getSelectedToggle().getUserData().toString().equals("c")){
	    	        		
	    	        		if((val[i].getLength()==0)||(val[i].getLength()>1)){
	    	        			val[i].setPromptText("Fill");
	    	        			okey=false;
	    	        		}
	    	        		else{
	    	        		str[i]=val[i].getText().toString();
	    	        		str[i]=str[i].concat(str[i].toUpperCase());
	    	        		str[i].trim();  	 
	    	        		data[i]=str[i].toCharArray();
	    	        		}
	    	        	}
	    	        	if(group[i].getSelectedToggle().getUserData().toString().equals("n")){
	    	        		
	    	        		if(val[i].getText().equals("")){
	    	        			
	    	        			str[i]="0123456789";
	    	        			str[i].trim();
	    	        			data[i]=str[i].toCharArray();
	    	        		}
	    	        		else if((val[i].getLength()>1)){
	    	        			val[i].setPromptText("Fill");
	    	        			okey=false;
	    	        		}
	    	        		else{
	    	        			str[i]=val[i].getText().toString();
	    	        			str[i].trim();
	    	        			data[i]=str[i].toCharArray();
	    	        		}
	    	        	}
	    	        	if(group[i].getSelectedToggle().getUserData().toString().equals("s")){
	    	        		if(val[i].getText().equals("")){
	    	        			str[i]="!@#$%^&*()";
		    	        		str[i].trim();
		    	        		data[i]=str[i].toCharArray();
	    	        		}
	    	        		else if((val[i].getLength()>1)){
	    	        			val[i].setPromptText("Fill");
	    	        			okey=false;
	    	        		}
	    	        		else{
	    	        			str[i]=val[i].getText().toString();
	    	        			str[i].trim();
	    	        			data[i]=str[i].toCharArray();
	    	        		}
	    	        	}
	    	        	
	    	        }
	    	        for (int i=0; i<l; i++){
	    	        	System.out.println(str[i]); 
	    	        }
	    	        
	    	        char[][] st = new char[str.length][];
	    	        for(int i = 0; i < str.length; i++)  {
	    	        //	System.out.println(data[0]); 
	    	          //  String line = str[i];
	    	          //  System.out.println(line);
	    	          //  st[i] = line.toCharArray();
	    	          //  System.out.println(st[i]); 

	    	         }

	    	      
	    	       /*
	    	        int j = 0;
	    	        for (int i=0; i<l; i++) {
	    	            for (int k=0; k<str[i].length(); k++) {
	    	            	System.out.println(""+i+""+k);
	    	            	System.out.println(str[i].charAt(k));
	    	            	st[i][k]=str[i].charAt(k);
	    	                j=k;
	    	            }
	    	            st[i][j]='\0';
	    	            
	    	        }*/

	    	   /*     for (int i = 0; i < str.length; i++) {
	    	            st[i] = str[i].toCharArray();
	    	            System.out.println(st[i]); 
	    	        }
	    	      */  
	              if(okey){
					generate(0, data, "");
	              }

	              okey=true;  
	            }
	        });

	    }
	 
	 	
	
	 @Override
	    public void initialize(URL url, ResourceBundle rb) {
	        // TODO
	    	//test();
	    }    
	    

}

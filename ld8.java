import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import java.util.Random;

public class Main extends Application { 
  int number;
  
  // viss iet, tacu random genere citu skaitli tikai tad kad programma tiek palaista nevis kad tiek uzskiesta "new game" poga. Ja Jus zinat ka to izlabot, ludzu dodiet man zinat. Meginaju vinu visur ielikt, tacu neviena ideja neizdevas.
  @Override
  public void start(Stage primaryStage) {
    
    Label label1, label2; 
    TextField textField;
    Button btnOk, btnNewGame;
    VBox vbox;
    Scene scene;

    label1 = new Label("Input number (1-100):");
    textField = new TextField();
    textField.setStyle("-fx-background-color: #aae0dd; -fx-text-fill: 02827b;"); // mazliet krasas del ta, ka random generate neiet perfekti :)
    label2 = new Label("You have 7 attempts to guess a number");
    textField.setMaxWidth(250);

    
    btnOk = new Button("OK"); 
    btnNewGame = new Button("New Game");

    btnOk.setOnAction(new EventHandler<ActionEvent>() {
      //int number;
      int number = new Random().nextInt(100) + 1;
      int count = 0;
      @Override public void handle(ActionEvent e) {
        try{
          
        int input = Integer.parseInt(textField.getText());
        
        // Poga "OK" salīdzina textField skaitlis ar number //
        if(input <1 || input > 100){
          label2.setText("error, must be a number from 1 to 100");
        }
          else if(input == number ){
            label2.setText("You win!");
          }
          else if(input > number){
            label2.setText("my number is less than yours");
          }
          else if(input < number){
            label2.setText("my number is greater than yours ");
          } 

          count++;
          
          if (count>7){ // uztaisiju te kas skaita cik reizes "ok" uzspiests, lai smukak un isak
            label2.setText("You lose!");
            count = 0; // reset uz 0, lai sak no jauna skaitit
          }
          
          } catch (NumberFormatException ex){ // error ja nav vesels skaitlis vai skaitlis in general
          label2.setText("error");
        }
        //return;
      }
    });

    btnNewGame.setOnAction(new EventHandler<ActionEvent>() {
      Random rnd = new Random();
      @Override public void handle(ActionEvent e) {

        textField.setText("New Game");
        //Jāizdzēš teksts no teksta lauka textField //
        textField.clear();
        //label paziņojums //
        label2.setText("you have 7 attempts to guess a number");
        
      }
    });

    vbox = new VBox(label1, textField, label2, btnOk, btnNewGame);
    vbox.setSpacing(20);
    vbox.setAlignment(Pos.CENTER);
    scene = new Scene(vbox, 300, 300);
    
    primaryStage.setTitle("Guess a number");
    primaryStage.setScene(scene);
    primaryStage.show();
  } 
    
  public static void main(String[] args) {
    launch(args);
  }
} 

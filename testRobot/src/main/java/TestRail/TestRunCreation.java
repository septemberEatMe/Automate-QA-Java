package TestRail;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.security.Key;
import java.util.Locale;

public class TestRunCreation extends BaseRobot{

    public TestRunCreation(Robot robot) throws AWTException {
        super(robot);
    }

    public void CreateTestRun(){
        Step(1550,190,1000);        //Test Run button
        Click();
        Step(1000,546, 1000);       //Dropdown
        Click();
        Step(1000,580, 1000);       //Author
        Click();
        Step(800,635, 2000);        //Ok button
        Click();
    }

    public void AddTestRun(String name, String reference, String environment, String sut){
        Step(200, 250,1000);
        Click(1000);                                          //Name
        ClearTextField(10, 50);
        robot.delay(1000);
        EnterWord(name);
        Step(400, 345,1000);                            //References
        Click(1000);
        EnterWord(reference);
        Step(400, 540, 1000);                           // Assign to me
        Click(200);
        Step(400, 620, 1000);                           // Assign to me
        Click();
        Step(400, 720, 1000);                           //Description
        Click();
        EnterWord(environment);
        NextLine(1000);
        EnterWord(sut);
    }

    //Cursor goes to the end of text field and starts to delete characters
    // (number of charactets that will deleted counts {backSpaceNubmers}
    private void ClearTextField(int backSpaceNumbers, int delayBoferBackSpacing) {
        robot.keyPress(KeyEvent.VK_END);
        for(int i = 0; i < backSpaceNumbers; i++){
            robot.keyPress(KeyEvent.VK_BACK_SPACE);
            robot.delay(delayBoferBackSpacing);
        }
    }

    //TODO: fix capital word bug
    public void EnterWord(String word){
        char[] arrayOfChars = word.toCharArray();
        for(int i = 0; i < arrayOfChars.length; i++){
            robot.keyPress(word.charAt(i));
        }
    }

}

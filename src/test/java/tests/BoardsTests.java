package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Random;

public class BoardsTests extends TestBase{

    @BeforeClass
    public void loginWithData(){
        app.getHelperUser().login(user.getEmail(), user.getPassword());
    }

    @Test
    public void createNewBoardPositiveTest(){
        int i = new Random().nextInt(1000);
        String boardTitle = "QA24_"+i;
        app.getHelperBoards().createNewBoard(boardTitle);
        Assert.assertTrue(app.getHelperBoards().isTextInElementEquals_boardTitle(boardTitle));
    }

    @Test
    public void createNewBoardNegativeTest_EmptyBoardTitle(){
        app.getHelperBoards().createNewBoard("   ");
        Assert.assertTrue(app.getHelperBoards().isElementPresents_inputBoardTitle());
    }

    @AfterMethod
    public void postConditione(){
        if(app.getHelperBoards().isElementPresents_boardTitle())
           app.getHelperBoards().clickBoards();
        if(app.getHelperBoards().isElementPresents_inputBoardTitle())
            app.getHelperBoards().clickBtnCloseCreateBoardForm();

    }
}

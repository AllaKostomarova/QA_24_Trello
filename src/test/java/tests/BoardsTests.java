package tests;

import models.BoardDto;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.Random;


public class BoardsTests extends TestBase{

    @BeforeClass
    public void loginWithData(){
        app.getHelperUser().login(user.getEmail(), user.getPassword());
    }

    @Test
    public void createNewBoardPositiveTest(Method method){
        int i = new Random().nextInt(1000);
        BoardDto boardDto = BoardDto.builder()
                .boardTitle("QA24_"+i)
                .build();
        logger.info("start test "+method.getName()+" board title ---> "+boardDto.getBoardTitle());
        //String boardTitle = "QA24_"+i;
        app.getHelperBoards().createNewBoard(boardDto);
        Assert.assertTrue(app.getHelperBoards().isTextInElementEquals_boardTitle(boardDto.getBoardTitle()));
    }

    @Test
    public void createNewBoardNegativeTest_EmptyBoardTitle(Method method){
        BoardDto boardDto = BoardDto.builder()
                .boardTitle("  ")
                .build();
       logger.info("start test "+method.getName()+" board title--> "+boardDto.getBoardTitle());
        app.getHelperBoards().createNewBoard(boardDto);
        Assert.assertTrue(app.getHelperBoards().isElementPresents_inputBoardTitle());
    }

    @Test
    public void deleteBoardPositiveTest(Method method) {
        int i = new Random().nextInt(1000);
        BoardDto boardDto = BoardDto.builder()
                .boardTitle("QA24_" + i)
                .build();
        logger.info("start test "+method.getName()+" board title ---> "+boardDto.getBoardTitle());
        app.getHelperBoards().createNewBoard(boardDto);
        app.getHelperBoards().clickBoards();
        app.getHelperBoards().deleteBoard(boardDto);
        Assert.assertTrue(app.getHelperBoards().isTextInElementEquals_boardTitle(boardDto.getBoardTitle()));
    }

//    @AfterMethod
//    public void postCondition(){
//        if(app.getHelperBoards().isElementPresents_boardTitle())
//           app.getHelperBoards().clickBoards();
//        if(app.getHelperBoards().isElementPresents_inputBoardTitle())
//            app.getHelperBoards().clickBtnCloseCreateBoardForm();
//
//    }
}

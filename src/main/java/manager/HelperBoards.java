package manager;

import models.BoardDto;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperBoards extends HelperBase{

    public HelperBoards(WebDriver wd) {
        super(wd);
    }

    By btnCreateNewBoard = By.cssSelector("li[data-testid='create-board-tile']");
    By inputBoardTitle = By.cssSelector("input[data-testid='create-board-title-input']");
    By btnCreateSubmit = By.cssSelector("button[data-testid='create-board-submit-button']");
    By boardTitle = By.cssSelector("h1[data-testid='board-name-display']");
    By titleBoard = By.cssSelector("a[data-testid='open-boards-link']");
    By btnCloseCreateBoardForm = By.cssSelector("button[data-testid='popover-close']");

    //---------------------------------------
    By btnDots = By.xpath("//button[@aria-label='Show menu']");
    By btnCloseBoard = By.xpath("//a[@class='board-menu-navigation-item-link " +
            "board-menu-navigation-item-link-v2 js-close-board']");
    By btnCloseSubmit = By.xpath("//input[@type='submit']");
    //By.cssSelector("input[value='Close']");
    By btnDeleteBoard = By.cssSelector("button[data-testid='close-board-delete-board-button']");
    By btnDeleteConfirm = By.cssSelector("button[data-testid='close-board-delete-board-confirm-button']");



    public void createNewBoard(BoardDto boardDto) {
        clickBase(btnCreateNewBoard);
        typeBase(inputBoardTitle, boardDto.getBoardTitle());
        pause(3);
        clickBase(btnCreateSubmit);
    }

    public void deleteBoard(BoardDto boardDto){
        clickBoardTitle(boardDto.getBoardTitle());
        clickBase(btnDots);
        clickBase(btnCloseBoard);
        clickBase(btnCloseSubmit);
        clickBase(btnDeleteBoard);
        clickBase(btnDeleteConfirm);
    }

    private void clickBoardTitle(String boardTitle) {
        String xPAthBoardTitle = "//div[@title='"+boardTitle+"']";
        clickBase(By.xpath(xPAthBoardTitle));
    }

    public boolean isTextInElementEquals_boardTitle(String text) {
        return isTextElementEquals(boardTitle, text);
    }

    public void clickBoards(){
        clickBase(titleBoard);
    }

    public boolean isElementPresents_inputBoardTitle(){
        return isElementPresent(inputBoardTitle);
    }

    public void clickBtnCloseCreateBoardForm(){
        clickBase(btnCloseCreateBoardForm);
    }

    public boolean isElementPresents_boardTitle() {
        return isElementPresent(boardTitle);
    }
}

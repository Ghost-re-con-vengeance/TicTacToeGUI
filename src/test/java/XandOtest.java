package test.java;
import main.XandO;
import org.junit.*;

public class XandOtest
{
    XandO xando;
    @Before
    public void SetUpInstance()
    {
        xando = new XandO();
    }

    @Test
    public void checkWin()
    {

        xando.setCell(0, 0, 'X');
        xando.setCell(0, 1, 'X');
        xando.setCell(0, 2, 'X');
        Assert.assertTrue(xando.checkWin('X'));

        xando.reset();
        xando.setCell(0, 0, 'O');
        xando.setCell(1, 0, 'O');
        xando.setCell(2, 0, 'O');
        Assert.assertTrue(xando.checkWin('O'));

        xando.reset();
        xando.setCell(0, 0, 'X');
        xando.setCell(1, 1, 'X');
        xando.setCell(2, 2, 'X');
        Assert.assertTrue(xando.checkWin('X'));

        xando.reset();
        xando.setCell(0, 0, 'X');
        xando.setCell(1, 1, 'O');
        xando.setCell(2, 2, 'X');
        Assert.assertFalse(xando.checkWin('X'));
    }

    @Test
    public void CheckDraw()
    {
        xando.reset();
        xando.setCell(0, 0, 'X');
        xando.setCell(0, 1, 'O');
        xando.setCell(0, 2, 'X');
        xando.setCell(1, 0, 'X');
        xando.setCell(1, 1, 'O');
        xando.setCell(1, 2, 'O');
        xando.setCell(2, 0, 'O');
        xando.setCell(2, 1, 'X');
        xando.setCell(2, 2, 'X');
        Assert.assertTrue(xando.draw());
    }

    @Test
    public void CheckReset()
    {
        xando.setCell(0, 0, 'X');
        xando.setCell(0, 1, 'O');
        xando.setCell(0, 2, 'X');
        xando.reset();
        char cellValue = xando.getCell(0, 0);
        char currentPlayer = xando.getCurrentPlayer();
        Assert.assertFalse(cellValue == 'X' || cellValue == 'O');
        Assert.assertEquals('X', currentPlayer);
    }
}

import org.junit.Test;

import static org.junit.Assert.*;


public class OthelloModelTest {

    OthelloModel model = new OthelloModel();


    @Test
    public void SpotIsKosher(){

        assertEquals(true, model.placePiece(OthModInter.GamePiece.BLACK,4,2));
    }

    @Test
    public void blackIsInThatSquare(){
        assertEquals(OthModInter.GamePiece.BLACK, model.whatsInThatSquare(3,3));
    }

    @Test
    public void whiteIsInThatSquare(){
        assertEquals(OthModInter.GamePiece.WHITE, model.whatsInThatSquare(4,3));
    }

    @Test
    public void blankIsInThatSquare(){
        assertEquals(OthModInter.GamePiece.BLANK, model.whatsInThatSquare(0,0));
    }

    @Test
    public void scorekeeper(){
        model.placePiece(OthModInter.GamePiece.BLACK,4,2);
        assertEquals(4,model.getBlackScore());
        assertEquals(1,model.getWhiteScore());

    }

    @Test
    public void restart(){
        model.placePiece(OthModInter.GamePiece.BLACK,4,2);
        model.restart();

        assertEquals(2,model.getBlackScore());
        assertEquals(2,model.getWhiteScore());
        assertEquals(OthModInter.GamePiece.BLANK, model.whatsInThatSquare(4,2));
    }

}

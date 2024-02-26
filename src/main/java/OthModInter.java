public interface OthModInter {


    /*
     *
     */
    public boolean placePiece(GamePiece color, int x, int y);

    //flips the pieces
    public int bigFlipper(int flipXToLeft , int flipXToRight, int flipYToBot,  int flipYToTop,
                          int upRightDiag, int upLeftDiag, int downLeftDiag, int downRightDiag, int row, int col);

    /*
     *
     */
    public void printPoints();

    //checks if a player has any possible moves. If not, skips the player
    public boolean anyKosherMoves(GamePiece player);

    //checks if game is over, announces winner
    public boolean isGameOver();

    //resets game if a player gives up, or if game is over
    public void restart();

    enum GamePiece{
        BLACK, WHITE, BLANK;
        public String toIcon(){
            if (this == GamePiece.BLACK){return "\u2B24";}
            if (this == GamePiece.WHITE){return "\u25CB";}
            return " "; //no GamePiece
        }
    }


}

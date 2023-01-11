# Tic-Tac-Toe
Create a simple tic tac toe game using integer position from 1 to 9.

/*  Gameboard placement 
 * 1|2|3
 * -+-+- 
 * 4|5|6
 * -+-+-
 * 7|8|9
 * 
 */
 
 The game was created using a char array.
 - Using Array List to store player's moves and cpu's moves 
 - Showing error message and playing piece for player if player enter the position that already played in the game board OR cpu enter enter a position that is already played by player.
 - Check the result after each player turn and each cpu turn. 
 -------
 3 method was used: 
 + printGameBoard(char[][] gameBoard)
 + placePiece(char[][] gameBoard, int pos, String user)
 + checkWinner()

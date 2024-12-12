package idle.projects;

public enum ProjectType {
  RATTYTOUILLE,
  ANDYBOT,
  PONG,
  TICTACTOE,
  FRUIT_NINJA,
  CARTOON,
  DOODLE_JUMP,
  TETRIS,
  INDY;

  public String displayName() {
    switch (this) {
      case RATTYTOUILLE:
        return "Rattytouille";
      case ANDYBOT:
        return "Andybot";
      case PONG:
          return "Pong";
      case TICTACTOE:
        return "Tic-Tac-Toe";
      case FRUIT_NINJA:
        return "Fruit Ninja";
      case CARTOON:
        return "Cartoon";
      case DOODLE_JUMP:
        return "Doodle Jump";
      case TETRIS:
        return "Tetris";
      case INDY:
        return "Indy";
      default:
        return "??";
    }
  }
  public String description() {
    switch (this) {
      case RATTYTOUILLE:
        return "The little rats scramble on the keyboard one letter at a time!";
      case ANDYBOT:
        return "BEEP-BOOP | MOVE-LEFT | [SOLVE PASSWORD]";
      case PONG:
        return "Bounces back and forth, it might get a lucky bounce!";
      case TICTACTOE:
        return "Get 3 in a row to win!";
      case FRUIT_NINJA:
        return "";
      case CARTOON:
        return "Every Andy click now has a chance to win a Cartoon competition! More cartoons results in a higher chance of winning and a greater win reward!";
      case DOODLE_JUMP:
        return "Infinite scroll";
      case TETRIS:
        return "Pieces together everything nicely!";
      case INDY:
        return "Obviously.";
      default:
        return "??";
    }
  }

  public String producerLabel() {
    switch (this) {
      case RATTYTOUILLE:
        return "Produces CHARACTERS!";
      case ANDYBOT:
        return "Deciphers CHARACTERS into LINES of code!";
      case PONG:
        return "Bounces around ";
      case TICTACTOE:
        return "Slowly produces lines";
      case FRUIT_NINJA:
        return "Converts METHODS into CLASSES!";
      case CARTOON:
        return "Every Andy click now has a chance to win a Cartoon competition! More cartoons results in a higher chance of winning and a greater win reward!";
      case DOODLE_JUMP:
        return "Bounces and clicks Andy automatically! Also increases click power";
      case TETRIS:
        return "Decreases conversion costs";
      case INDY:
        return "Improves the efficiency of everything!";
      default:
        return "??";
    }
  }
}





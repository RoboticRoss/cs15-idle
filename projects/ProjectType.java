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
  PAC_MAN;

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
      case PAC_MAN:
        return "Pac-Man";
      default:
        return "??";
    }
  }
}





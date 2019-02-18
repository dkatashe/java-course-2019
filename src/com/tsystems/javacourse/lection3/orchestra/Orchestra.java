package com.tsystems.javacourse.lection3.orchestra;

import com.tsystems.javacourse.lection3.orchestra.instrument.*;
import java.util.ArrayList;

public class Orchestra
{
  private ArrayList<Instrument> instruments = new ArrayList<>();

  private void addInstrument(String name) {
    Instrument i = null;

    switch (name) {
      case "Violin":
        i = new Violin();
        break;
      case "Flute":
        i = new Flute();
        break;
      case "Oboe":
        i = new Oboe();
        break;
      case "Cello":
        i = new Cello();
        break;
    }

    instruments.add(i);
  }

  private void playConcert() {
    instruments.forEach(Instrument::play);
  }

  public static void main(String[] args)
  {
    Orchestra orchestra  = new Orchestra();
    orchestra.addInstrument("Violin");
    orchestra.addInstrument("Flute");
    orchestra.addInstrument("Oboe");
    orchestra.addInstrument("Cello");
    orchestra.playConcert();
  }
}

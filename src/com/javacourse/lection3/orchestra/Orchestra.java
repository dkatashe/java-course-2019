package com.javacourse.lection3.orchestra;

import com.javacourse.lection3.orchestra.instrument.*;
import java.util.ArrayList;

public class Orchestra
{
  private ArrayList<Instrument> instruments = new ArrayList<>();

  private void addInstrument(Instrument i) {
    instruments.add(i);
  }

  private void playConcert() {
    instruments.forEach(Instrument::play);
  }

  public static void main(String[] args)
  {
    Orchestra orchestra = new Orchestra();
    orchestra.addInstrument(new Violin());
    orchestra.addInstrument(new Flute());
    orchestra.addInstrument(new Oboe());
    orchestra.addInstrument(new Cello());
    orchestra.playConcert();
  }
}

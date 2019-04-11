package mvc.beatMachine;

import javax.sound.midi.*;
import java.util.*;

public class BeatModel implements BeatModelInterface, MetaEventListener
{
    private Sequencer sequencer;
    private ArrayList<BeatObserver> beatObservers = new ArrayList<>();
    private ArrayList<BPMObserver> bpmObservers = new ArrayList<>();
    private int bpm = 90;
    private Sequence sequence;
    private Track track;

    public void initialize()
    {
        setUpMidi();
        buildTrackAndStart();
    }

    public void on()
    {
        System.out.println("Starting the sequencer");
        sequencer.start();
        setBPM(90);
    }

    public void off()
    {
        setBPM(0);
        sequencer.stop();
    }

    public void setBPM(int bpm)
    {
        this.bpm = bpm;
        sequencer.setTempoInBPM(getBPM());
        notifyBPMObservers();
    }

    public int getBPM()
    {
        return bpm;
    }

    private void beatEvent()
    {
        System.out.println("Beat Event Called");
        notifyBeatObservers();
    }


    public void registerObserver(BeatObserver o)
    {
        beatObservers.add(o);
    }

    private void notifyBeatObservers()
    {
        for (BeatObserver beatObserver : beatObservers)
        {
            beatObserver.updateBeat();
        }
    }

    public void registerObserver(BPMObserver o)
    {
        bpmObservers.add(o);
    }

    private void notifyBPMObservers()
    {
        for (BPMObserver bpmObserver : bpmObservers)
        {
            bpmObserver.updateBPM();
        }
    }


    public void removeObserver(BeatObserver o)
    {
        int i = beatObservers.indexOf(o);
        if (i >= 0)
        {
            beatObservers.remove(i);
        }
    }


    public void removeObserver(BPMObserver o)
    {
        int i = bpmObservers.indexOf(o);
        if (i >= 0)
        {
            bpmObservers.remove(i);
        }
    }


    public void meta(MetaMessage message)
    {
        if (message.getType() == 47)
        {
            beatEvent();
            sequencer.start();
            setBPM(getBPM());
        }
    }

    private void setUpMidi()
    {
        try
        {
            sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequencer.addMetaEventListener(this);
            sequence = new Sequence(Sequence.PPQ, 4);
            track = sequence.createTrack();
            sequencer.setTempoInBPM(getBPM());
            sequencer.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void buildTrackAndStart()
    {
        int[] trackList = {35, 0, 46, 0};

        sequence.deleteTrack(null);
        track = sequence.createTrack();

        makeTracks(trackList);
        track.add(makeEvent(192, 9, 1, 0, 4));
        try
        {
            sequencer.setSequence(sequence);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void makeTracks(int[] list)
    {
        for (int i = 0; i < list.length; i++)
        {
            int key = list[i];

            if (key != 0)
            {
                track.add(makeEvent(144, 9, key, 100, i));
                track.add(makeEvent(128, 9, key, 100, i));
                MidiEvent midiEvent = makeEvent(128, 9, key, 100, i + 1);
                track.add(midiEvent);
                track.add(makeMetaEvent(midiEvent, i + 2));
            }
        }
    }

    private MidiEvent makeEvent(int comd, int chan, int one, int two, int tick)
    {
        MidiEvent event = null;
        try
        {
            ShortMessage a = new ShortMessage();
            a.setMessage(comd, chan, one, two);
            event = new MidiEvent(a, tick);

        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return event;
    }

    private MidiEvent makeMetaEvent(MidiEvent midiEvent, int tick)
    {
        MidiEvent event = null;

        try
        {
            MetaMessage message = new MetaMessage(47,
                    midiEvent.getMessage().getMessage(),
                    midiEvent.getMessage().getLength());
            event = new MidiEvent(message, tick);
        } catch (InvalidMidiDataException e)
        {
            e.printStackTrace();
        }

        return event;
    }
}

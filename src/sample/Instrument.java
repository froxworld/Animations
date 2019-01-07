package sample;

import javax.sound.midi.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author (francois Auxietre)
 */
public class Instrument {

    public int volume = 100;
    private Synthesizer synthetiseur;
    private MidiChannel canal;

    public Instrument(){

        try {
            //On récupère le synthétiseur, on l'ouvre et on obtient un canal
            synthetiseur = MidiSystem.getSynthesizer();
            synthetiseur.open();
        } catch (MidiUnavailableException exception) {
            Logger.getLogger(javax.sound.midi.Instrument.class.getName()).log(Level.SEVERE, null, exception);
        }
        canal = synthetiseur.getChannels()[0];

        //On initialise l'instrument 0 (le piano) pour le canal
        canal.programChange(0);
    }

    //Joue la note dont le numéro est en paramètre
    public void note_on(int note){
        canal.noteOn(note, volume);
    }
    //Arrête de jouer la note dont le numéro est en paramètre
    public void note_off(int note){
        canal.noteOff(note);
    }
    //Set le type d'instrument dont le numéro MIDI est précisé en paramètre
    public void set_instrument(int instru){
        canal.programChange(instru);
    }
}

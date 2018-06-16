/*
Challenge #343 [Easy]

For the purpose of this challenge, the 12 musical notes in the chromatic scale are named:

C  C#  D  D#  E  F  F#  G  G#  A  A#  B
The interval between each pair of notes is called a semitone, and the sequence wraps around. So for instance, E is 1
semitone above D#, C is 1 semitone above B, F# is 4 semitones above D, and C# is 10 semitones above D#.

A major scale comprises 7 out of the 12 notes in the chromatic scale. There are 12 different major scales, one for each
note. For instance, the D major scale comprises these 7 notes:

D  E  F#  G  A  B  C#
The notes in a major scale are the notes that are 0, 2, 4, 5, 7, 9, and 11 semitones above the note that the scale is
named after. In the movable do solfège system, these are referred to by the names Do, Re, Mi, Fa, So, La, and Ti,
respectively.

Write a function that takes the name of a major scale and the solfège name of a note, and
returns the corresponding note in that scale.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class MajorScales {
    private static final String[] NOTES = {"C", "C#", "D", "D#", "E", "F", "F#", "G", "G#", "A", "A#", "B"};

    private enum SolfegeNote {
        DO, RE, MI, FA, SO, LA, TI
    }
    private static final int[] SOLFEGE_NOTE_OFFSET = {0, 2, 4, 5, 7, 9, 11};
    private static HashMap<SolfegeNote, Integer> solfegeNoteMap = new HashMap<>();

    public static void main(String[] args) {
        SolfegeNote[] values = SolfegeNote.values();
        for (int i = 0; i < values.length; i++) {
            solfegeNoteMap.put(values[i], SOLFEGE_NOTE_OFFSET[i]);
        }

        Scanner inputScan = new Scanner(System.in);

        System.out.println("Major scale: ");
        String note = inputScan.next();

        System.out.println("Solfege note: ");
        SolfegeNote solfegeNote = SolfegeNote.valueOf(inputScan.next().toUpperCase());
        int solfegeNoteOffset = solfegeNoteMap.get(solfegeNote);

        int noteIndex = Arrays.asList(NOTES).indexOf(note);
        int finalNoteIndex = (noteIndex + solfegeNoteOffset) % 12;

        System.out.println(NOTES[finalNoteIndex]);
    }
}